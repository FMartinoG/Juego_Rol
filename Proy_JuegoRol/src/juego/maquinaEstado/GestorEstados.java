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
import juego.maquinaEstado.estados.derrota.Derrota;
import juego.maquinaEstado.estados.informacion.GestorPaginaInformacion;
import juego.maquinaEstado.estados.introduccion.Introduccion;
import juego.maquinaEstado.estados.juego.GestorJuego;
import juego.maquinaEstado.estados.menuJuego.GestorMenu;
import juego.maquinaEstado.estados.menuPrincipal.GestorMenuPrincipal;

/**
 * Clase encargada de guardar los diferentes estados del juego y de cambiarlos
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
	 * Constructor de la clase GestoEstados. Llama al m�todo para crear la lista de
	 * estados y al m�todo para inicializar el primer estado.
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
	 * Inicializa la lista de los estados y se le a�aden los estados.
	 */
	private void iniciarEstados() {
		estados = new EstadoJuego[7];
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
	 * Llama al m�todo actualizar del estado actual.
	 */
	public void actualizar() {
		estadoActual.actualizar();

		// Men� principal.
		if (estadoActual == estados[0]) {
			actualizarMenuPrincipal();
		}

		// Juego.
		if (estadoActual == estados[1]) {
			actualizarJuego();
		}

		// Men� del juego.
		if (estadoActual == estados[2]) {
			if (!Controles.TECLADO.menuAbierto)
				cambiarEstado(1);
		}

		// Combate.
		if (estadoActual == estados[3]) {
			if (!((GestorCombate) estadoActual).isEnCombate()) {
				// Si gana el combate
				if (((GestorJuego) estados[1]).getJugador().getEstadisticas().getSalud() > 0)
					cambiarEstado(1);
				else {
					// Si pierde el combate.
					estados[6] = new Derrota();
					cambiarEstado(6);
				}
				((GestorJuego) estados[1]).setEnCombate(false);
			}
		}

		// Introducci�n.
		if (estadoActual == estados[4]) {
			if (((Introduccion) estadoActual).isFinalizado())
				cambiarEstado(1);
		}

		// Pantalla de informaci�n.
		if (estadoActual == estados[5]) {
			if (((GestorPaginaInformacion) estadoActual).isPulsadoVolver()) {
				estados[0] = new GestorMenuPrincipal();
				cambiarEstado(0);
			}
		}

		// Derrota.
		if (estadoActual == estados[6]) {
			if (((Derrota) estadoActual).isFinalizado()) {
				estados[0] = new GestorMenuPrincipal();
				cambiarEstado(0);
			}
		}

	}

	/**
	 * M�todo encargado de controlar las acciones en el men� principal
	 */
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

	/**
	 * M�todo encargado de abrir la p�gina de informaci�n.
	 */
	private void pulsarInformacion() {
		estados[5] = new GestorPaginaInformacion();
		cambiarEstado(5);
	}

	/**
	 * M�todo que manda cargar la partida y cambia el estado al juego.
	 */
	private void pulsarCargarPartida() {
		Estadisticas s = CargarPartida.cargar();
		if (s == null)
			mostrarMensajeNoCarga = true;
		else {
			String textoMapa = CargarPartida.mapaACargar(s.getMapa());
			Mapa mapa = new Mapa(textoMapa);
			Jugador j = new Jugador(mapa);
			j.setEstadisticas(s);
			estados[1] = new GestorJuego(j);
			estados[2] = new GestorMenu(j);
			cambiarEstado(1);
		}
	}

	/**
	 * M�todo encargado de cambiar los estados cuando est� en el juego.
	 */
	private void actualizarJuego() {
		if (Controles.TECLADO.menuAbierto)
			estados[2] = new GestorMenu(((GestorJuego) estados[1]).getJugador());
		cambiarEstado(2);
		if (((GestorJuego) estados[1]).isEnCombate()) {
			Jugador j = ((GestorJuego) estados[1]).getJugador();
			int enemigo = ((GestorJuego) estados[1]).getCombate();
			estados[3] = new GestorCombate(j, Constantes.ENEMIGOS[enemigo]);
			cambiarEstado(3);
		}
	}

	/**
	 * Llama al m�todo dibujar del estado actual.
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
	 * Cambia el estado actual por el estado pedido como par�metro.
	 * 
	 * @param nuevoEstado int - Posicion en la lista de estados.
	 */
	public void cambiarEstado(final int nuevoEstado) {
		if (nuevoEstado == 0 && !musica.isActive()) {
			musica.start();
		}
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
