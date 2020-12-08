package principal.maquinaEstado;

import java.awt.Graphics;

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

	/**
	 * Constructor de la clase GestoEstados. Llama al método para crear la lista de
	 * estados y al método para inicializar el primer estado.
	 */
	public GestorEstados() {
		iniciarEstados();
		iniciarEstadoActual();
	}

	/**
	 * Inicializa la lista de los estados y se le añaden los estados.
	 */
	private void iniciarEstados() {
		estados = new EstadoJuego[3];
		estados[0] = new GestorMenuPrincipal();
		estados[1] = new GestorJuego();
		estados[2] = new GestorMenu();
	}

	/**
	 * Inicializa el juego con el primer estado de la lista.
	 */
	private void iniciarEstadoActual() {
		estadoActual = estados[0];
	}

	/**
	 * Llama al método actualizar del estado actual.
	 */
	public void actualizar() {
		estadoActual.actualizar();
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
	}

	/**
	 * Devuelve el estado actual.
	 * 
	 * @return estadoActual EstadoJuego - El estado actual.
	 */
	public EstadoJuego getEstadoActual() {
		return estadoActual;
	}
}
