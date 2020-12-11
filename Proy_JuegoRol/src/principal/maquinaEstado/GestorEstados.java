package principal.maquinaEstado;

import java.awt.Graphics;

import principal.CargarPartida;
import principal.control.Controles;
import principal.maquinaEstado.estados.combate.GestorCombate;
import principal.maquinaEstado.estados.juego.GestorJuego;
import principal.maquinaEstado.estados.menuJuego.GestorMenu;
import principal.maquinaEstado.estados.menuPrincipal.GestorMenuPrincipal;

/**
 * Clase encargada de guardar los diferentes estados del juego y de cambiarlos
 * Los estados son los menús y el juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorEstados {

	private EstadoJuego[] estados;
	private EstadoJuego estadoActual;
	private int posicionActual;

	/**
	 * Constructor de la clase GestoEstados. Llama al método para crear la lista de
	 * estados y al método para inicializar el primer estado.
	 */
	public GestorEstados() {
		posicionActual = 0;
		iniciarEstados();
		iniciarEstadoActual();
	}

	/**
	 * Inicializa la lista de los estados y se le añaden los estados.
	 */
	private void iniciarEstados() {
		estados = new EstadoJuego[4];
		estados[0] = new GestorMenuPrincipal();
		estados[1] = new GestorJuego();
		estados[2] = new GestorMenu(((GestorJuego) estados[1]).getJugador());

	}

	/**
	 * Inicializa el juego con el primer estado de la lista.
	 */
	private void iniciarEstadoActual() {
		estadoActual = estados[posicionActual];
	}

	/**
	 * Llama al método actualizar del estado actual.
	 */
	public void actualizar() {
		estadoActual.actualizar();
		if (estadoActual == estados[0]) {
			if (((GestorMenuPrincipal) estadoActual).nuevaPartida()) {
				cambiarEstado(1);
			} else if (((GestorMenuPrincipal) estadoActual).cargarPartida()) {
				System.out.println("Todavia no");
				// estados[1] = new GestorJuego(CargarPartida.cargar());
				// estados[2] = new GestorMenu(((GestorJuego) estados[1]).getJugador());
				// cambiarEstado(1);
			}
		}

		if (estadoActual == estados[1]) {
			if (Controles.TECLADO.menuAbierto)
				cambiarEstado(2);
			if (Controles.TECLADO.combate) {
				estados[3] = new GestorCombate();
				cambiarEstado(3);
			}
		}

		if (estadoActual == estados[2]) {
			if (!Controles.TECLADO.menuAbierto)
				cambiarEstado(1);
		}

		if (estadoActual == estados[3]) {
			if (!((GestorCombate) estadoActual).isEnCombate()) {
				cambiarEstado(1);
			}
		}
	}

	/**
	 * Llama al método dibujar del estado actual.
	 * 
	 * @param g Graphics - Objeto encargado de dibujar en la ventana.
	 */
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}

	/**
	 * Cambia el estado actual por el estado pedido como parámetro.
	 * 
	 * @param nuevoEstado int - Posicion en la lista de estados.
	 */
	public void cambiarEstado(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
		posicionActual = nuevoEstado;
	}

	/**
	 * Devuelve el estado actual.
	 * 
	 * @return estadoActual EstadoJuego - El estado actual.
	 */
	public EstadoJuego getEstadoActual() {
		return estadoActual;
	}

	public int getPosicionActual() {
		return posicionActual;
	}
}
