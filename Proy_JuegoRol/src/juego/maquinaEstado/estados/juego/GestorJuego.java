package juego.maquinaEstado.estados.juego;

import java.awt.Graphics;
import java.awt.Rectangle;

import juego.Constantes;
import juego.HUD.Mensaje;
import juego.control.Controles;
import juego.entes.Jugador;
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
	private boolean enCombate = false;

	public GestorJuego() {
		iniciarMapa(Constantes.MAPA_1);
		iniciarJugador();
	}

	public GestorJuego(Jugador jugador) {
		iniciarMapa(Constantes.MAPA_1);
		this.jugador = jugador;
		jugador.getEstadisticas().cambiarMapa(1);
	}

	private void iniciarMapa(String ruta) {
		mapa = new Mapa(ruta);
	}

	private void iniciarJugador() {
		jugador = new Jugador(mapa);
		jugador.getEstadisticas().cambiarMapa(1);
	}

	private void recargarJuego() {
		final String siguienteMapa = comprobarSiguienteMapa(mapa.getSiguienteMapa());
		iniciarMapa(siguienteMapa);

		jugador.setMapa(mapa);
		jugador.setPosicionX(mapa.getPosicionInicial().x);
		jugador.setPosicionY(mapa.getPosicionInicial().y);
		switch (mapa.getRuta()) {
		case Constantes.MAPA_1:
			jugador.getEstadisticas().cambiarMapa(1);
			break;
		case Constantes.MAPA_2:
			jugador.getEstadisticas().cambiarMapa(2);
			break;
		default:
			break;
		}
	}

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

		jugador.actualizar();
		mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
	}

	private void comprobarLlegaConversacion() {
		boolean encontrado = false;
		int punteroBorrar = -1;
		for (int i = 0; i < mapa.getZonaConversaciones().size() && !encontrado; ++i) {
			Rectangle rect = mapa.getZonaConversaciones().get(i);
			if (jugador.getLIMITE_ARRIBA().intersects(rect)) {
				enConversacion = true;
				punteroBorrar = i;
				encontrado = true;
			}
		}
		if (encontrado)
			mapa.quitarConversacion(punteroBorrar);
	}

	private void comprobarLlegaCombate() {
		boolean encontrado = false;
		int punteroBorrar = -1;
		for (int i = 0; i < mapa.getZonaCombates().size() && !encontrado; ++i) {
			Rectangle rect = mapa.getZonaCombates().get(i);
			if (jugador.getLIMITE_ARRIBA().intersects(rect)) {
				enCombate = true;
				punteroBorrar = i;
				encontrado = true;
			}
		}
		if (encontrado)
			mapa.quitarCombate(punteroBorrar);
	}

	@Override
	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);
		if (enConversacion) {
			mostarMensajes(g);
			enConversacion = false;
		}
	}

	private void mostarMensajes(Graphics g) {
		Mensaje m = new Mensaje(Constantes.CONVERSACIONES[0], 300, 300, true);
		m.dibujar(g);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!Controles.TECLADO.seleccion) {
			System.out.println("Enter para continuar");
		}
	}

	private String comprobarSiguienteMapa(String siguienteMapa) {
		String nuevoMapa = "";
		switch (siguienteMapa) {
		case "m1":
			nuevoMapa = Constantes.MAPA_1;
			break;
		case "m1_1":
			nuevoMapa = Constantes.MAPA_1_1;
			break;
		case "m2":
			nuevoMapa = Constantes.MAPA_2;
			break;
		default:
			break;
		}
		return nuevoMapa;
	}

	public Jugador getJugador() {
		return jugador;
	}
	
	public boolean isEnCombate() {
		return enCombate;
	}
	
	public void setEnCombate(boolean enCombate) {
		this.enCombate = enCombate;
	}

}
