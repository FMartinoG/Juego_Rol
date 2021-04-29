package juego.maquinaEstado.estados.juego;

import java.awt.Graphics;
import java.awt.Rectangle;

import juego.Constantes;
import juego.HUD.Mensaje;
import juego.control.Controles;
import juego.entes.Jugador;
import juego.herramientas.ComprobadorDeMapa;
import juego.mapas.Mapa;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorJuego implements EstadoJuego {

	private Mapa mapa;
	private Jugador jugador;
	private boolean puedeContinuar = false;
	private boolean enConversacion = false;
	private int conversacion = 0;
	private boolean enCombate = false;
	private int combate = 0;
	private boolean isFinJuego = false;

	/**
	 * Constructor de la clase gestor de juego cuando es una nueva partida.
	 */
	public GestorJuego() {
		iniciarMapa(Constantes.MAPA_PUEBLO_1);
		iniciarJugador();
	}

	/**
	 * Constructor de la clase gestor de juego cuando es una partida cargada.
	 * 
	 * @param jugador Jugador - Objeto jugador.
	 */
	public GestorJuego(Jugador jugador) {
		this.jugador = jugador;
		iniciarMapa(jugador.getMapa().getRuta());
	}

	/**
	 * Método que guarda un objeto mapa a partir de la ruta del mapa.
	 * 
	 * @param ruta
	 */
	private void iniciarMapa(String ruta) {
		mapa = new Mapa(ruta);
	}

	/**
	 * Método que crea un nuevo jugador.
	 */
	private void iniciarJugador() {
		jugador = new Jugador(mapa);
	}

	/**
	 * Método que cambia el mapa actual por el mapa siguiente y actualiza la
	 * información.
	 */
	private void recargarJuego() {
		final String siguienteMapa = ComprobadorDeMapa.comprobarSiguienteMapa(mapa.getSiguienteMapa());
		iniciarMapa(siguienteMapa);

		jugador.setMapa(mapa);
		jugador.setPosicionX(mapa.getPosicionInicial().x);
		jugador.setPosicionY(mapa.getPosicionInicial().y);
		ComprobadorDeMapa.guardarMapa(jugador, mapa.getRuta());
	}

	/**
	 * Método que actualiza los diferentes elementos del estado.
	 */
	@Override
	public void actualizar() {
		if (puedeContinuar) {
			puedeContinuar = false;
			recargarJuego();
		}
		if (jugador.getLIMITE_ARRIBA().intersects(mapa.getZonaSalida()))
			puedeContinuar = true;

		if (!mapa.getZonaConversaciones().isEmpty())
			comprobarLlegaConversacion();

		if (!mapa.getZonaCombates().isEmpty())
			comprobarLlegaCombate();
		
		if (Constantes.isFinJuego)
			isFinJuego = true;

		jugador.actualizar();
		mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
	}

	/**
	 * Método que comprueba si ha llegado a una zona de conversación, y si es
	 * así manda mostrar la conversación y la borra.
	 */
	private void comprobarLlegaConversacion() {
		boolean encontrado = false;
		int punteroBorrar = -1;
		for (int i = 0; i < mapa.getZonaConversaciones().size() && !encontrado; ++i) {
			Rectangle rect = mapa.getZonaConversaciones().get(i);
			if (jugador.getLIMITE_ARRIBA().intersects(rect)) {
				conversacion = mapa.getPunteroConversacion().get(i);
				enConversacion = true;
				punteroBorrar = i;
				encontrado = true;
			}
		}
		if (encontrado)
			mapa.quitarConversacion(punteroBorrar);
	}

	/**
	 * Método que comprueba si ha llegado a una zona de combate, y si es así
	 * manda cambiar al estado de combate y la borra.
	 */
	private void comprobarLlegaCombate() {
		boolean encontrado = false;
		int punteroBorrar = -1;
		for (int i = 0; i < mapa.getZonaCombates().size() && !encontrado; ++i) {
			Rectangle rect = mapa.getZonaCombates().get(i);
			if (jugador.getLIMITE_ARRIBA().intersects(rect)) {
				combate = mapa.getPunteroCombates().get(i);
				enCombate = true;
				punteroBorrar = i;
				encontrado = true;
			}
		}
		if (encontrado)
			mapa.quitarCombate(punteroBorrar);
	}

	/**
	 * Devuelve el puntero que hace referencia al combate.
	 * 
	 * @return combate int
	 */
	public int getCombate() {
		return combate;
	}

	/**
	 * Método que dibuja los elementos del estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);
		if (enConversacion) {
			mostarMensajes(g);
			enConversacion = false;
		}
	}

	/**
	 * Método que muestra los mensajes de la conversación.s
	 * 
	 * @param g
	 */
	private void mostarMensajes(Graphics g) {
		Mensaje m = null;
		for (String s : Constantes.CONVERSACIONES.get(conversacion)) {
			m = new Mensaje(s, 200, 300, true);
			m.dibujar(g);
			long msInicio = System.currentTimeMillis();
			long msActual = System.currentTimeMillis();
			while ((msActual - msInicio) < 500)
				msActual = System.currentTimeMillis();

			while (!Controles.TECLADO.seleccion) {
				System.out.println("Enter para continuar");
			}
		}
	}

	/**
	 * Método que devuelve el objeto del jugador.
	 * 
	 * @return jugador Jugador - Objeto jugador.
	 */
	public Jugador getJugador() {
		return jugador;
	}

	/**
	 * Método que indica si ha entrado en combate para que cambie de estado.
	 * 
	 * @return enCombate boolean
	 */
	public boolean isEnCombate() {
		return enCombate;
	}

	/**
	 * Método que modifica la variable que indica si está en combate.
	 * 
	 * @param enCombate boolean - Indica si está en combate.
	 */
	public void setEnCombate(boolean enCombate) {
		this.enCombate = enCombate;
	}
	
	/**
	 * Método que indica si se ha llegado al final del juego.
	 * 
	 * @return isFinJuego boolean
	 */
	public boolean isFinJuego() {
		return isFinJuego;
	}

}
