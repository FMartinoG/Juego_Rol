package juego.maquinaEstado;

import java.awt.Color;
import java.awt.Graphics;

import javax.sound.sampled.Clip;

import juego.Constantes;
import juego.control.Controles;
import juego.entes.Estadisticas;
import juego.entes.Jugador;
import juego.guardado_cargado.CargarPartida;
import juego.herramientas.CargadorRecursos;
import juego.herramientas.CreadorConversaciones;
import juego.herramientas.CreadorEnemigos;
import juego.mapas.Mapa;
import juego.maquinaEstado.estados.combate.GestorCombate;
import juego.maquinaEstado.estados.informacion.GestorPaginaInformacion;
import juego.maquinaEstado.estados.introduccion.Introduccion;
import juego.maquinaEstado.estados.juego.GestorJuego;
import juego.maquinaEstado.estados.menuJuego.GestorMenu;
import juego.maquinaEstado.estados.menuPrincipal.GestorMenuPrincipal;

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
	private Clip musica = CargadorRecursos.cargarSonido(Constantes.MUSICA);
	private Clip sonidoInicio = CargadorRecursos.cargarSonido(Constantes.SONIDO);

	private boolean mostrarMensajeNoCarga = false;

	/**
	 * Constructor de la clase GestoEstados. Llama al método para crear la lista de
	 * estados y al método para inicializar el primer estado.
	 */
	public GestorEstados() {
		posicionActual = 0;
		iniciarEstados();
		iniciarEstadoActual();
		musica.start();
		musica.loop(Clip.LOOP_CONTINUOUSLY);
		CreadorConversaciones.crearConversaciones();
		CreadorEnemigos.crearEnemigos();
	}

	/**
	 * Inicializa la lista de los estados y se le añaden los estados.
	 */
	private void iniciarEstados() {
		estados = new EstadoJuego[6];
		estados[0] = new GestorMenuPrincipal();
		estados[1] = new GestorJuego();
		estados[2] = new GestorMenu(((GestorJuego) estados[1]).getJugador());
		estados[4] = new Introduccion();

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
			actualizarMenuPrincipal();
		}

		if (estadoActual == estados[1]) {
			actualizarJuego();
		}

		if (estadoActual == estados[2]) {
			if (!Controles.TECLADO.menuAbierto)
				cambiarEstado(1);
		}

		if (estadoActual == estados[3]) {
			if (!((GestorCombate) estadoActual).isEnCombate()) {
				cambiarEstado(1);
				((GestorJuego) estados[1]).setEnCombate(false);
			}
		}

		if (estadoActual == estados[4]) {
			if (((Introduccion) estadoActual).isFinalizado())
				cambiarEstado(1);
		}

		if (estadoActual == estados[5]) {
			if (((GestorPaginaInformacion) estadoActual).isPulsadoVolver()) {
				estados[0] = new GestorMenuPrincipal();
				cambiarEstado(0);
			}
		}
	}

	private void actualizarMenuPrincipal() {
		if (((GestorMenuPrincipal) estadoActual).nuevaPartida()) {
			musica.stop();
			sonidoInicio.start();
			cambiarEstado(4);
			mostrarMensajeNoCarga = false;
		} else if (((GestorMenuPrincipal) estadoActual).cargarPartida()) {
			musica.stop();
			sonidoInicio.start();
			pulsarCargarPartida();
		} else if (((GestorMenuPrincipal) estadoActual).seleccionarInformacion()) {
			pulsarInformacion();
		}
	}

	private void pulsarInformacion() {
		estados[5] = new GestorPaginaInformacion();
		cambiarEstado(5);
	}

	private void pulsarCargarPartida() {
		Estadisticas s = CargarPartida.cargar();
		if (s == null)
			mostrarMensajeNoCarga = true;
		else {
			String textoMapa = "";
			switch (s.getMapa()) {
			case 1:
				textoMapa = Constantes.MAPA_1;
				break;
			case 2:
				textoMapa = Constantes.MAPA_2;
				break;
			default:
				break;
			}
			Mapa mapa = new Mapa(textoMapa);
			Jugador j = new Jugador(mapa);
			j.setEstadisticas(s);
			estados[1] = new GestorJuego(j);
			estados[2] = new GestorMenu(j);
			cambiarEstado(1);
		}
	}

	private void actualizarJuego() {
		if (Controles.TECLADO.menuAbierto)
			estados[2] = new GestorMenu(((GestorJuego) estados[1]).getJugador());
		cambiarEstado(2);
		if (((GestorJuego) estados[1]).isEnCombate()) {
			Jugador j = ((GestorJuego) estados[1]).getJugador();
			estados[3] = new GestorCombate(j, Constantes.ENEMIGOS[0]);
			cambiarEstado(3);
		}
	}

	/**
	 * Llama al método dibujar del estado actual.
	 * 
	 * @param g Graphics - Objeto encargado de dibujar en la ventana.
	 */
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);

		if (mostrarMensajeNoCarga) {
			g.setColor(Color.darkGray);
			g.fillRoundRect(280, 180, 160, 30, 10, 10);
			g.setColor(Color.white);
			g.drawString("Ninguna partida guardada", 290, 200);
		}
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
