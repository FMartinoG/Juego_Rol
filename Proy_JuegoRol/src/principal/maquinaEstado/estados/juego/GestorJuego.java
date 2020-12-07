package principal.maquinaEstado.estados.juego;

import java.awt.Graphics;

import principal.Constantes;
import principal.HUD.InterfazUsuario;
import principal.entes.Jugador;
import principal.mapas.Mapa;
import principal.maquinaEstado.EstadoJuego;

public class GestorJuego implements EstadoJuego {

	private Mapa mapa;
	private Jugador jugador;
	private InterfazUsuario iu;

	public GestorJuego() {
		iniciarMapa(Constantes.MAPA_1);
		iniciarJugador();
		iu = new InterfazUsuario(jugador);
	}

	private void iniciarMapa(String ruta) {
		mapa = new Mapa(ruta);
	}

	private void iniciarJugador() {
		jugador = new Jugador(mapa);
	}

	private void recargarJuego() {
		final String siguienteMapa = comprobarSiguienteMapa(mapa.getSiguienteMapa());
		iniciarMapa(siguienteMapa);
		
		jugador.setMapa(mapa);
		jugador.setPosicionX(mapa.getPosicionInicial().x);
		jugador.setPosicionY(mapa.getPosicionInicial().y);
	}

	@Override
	public void actualizar() {
		if(jugador.getLIMITE_ARRIBA().intersects(mapa.getZonaSalida())) {
			recargarJuego();
		}
		jugador.actualizar();
		mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
	}

	@Override
	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);
		iu.dibujar(g);
	}

	private String comprobarSiguienteMapa(String siguienteMapa) {
		String nuevoMapa = "";
		switch (siguienteMapa) {
		case "m1":
			nuevoMapa = Constantes.MAPA_1;
			break;
		case "m2":
			nuevoMapa = Constantes.MAPA_2;
			break;
		default:
			break;
		}
		return nuevoMapa;
	}

}
