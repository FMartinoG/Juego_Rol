package principal.maquinaEstado.estados.juego;

import java.awt.Graphics;

import principal.Constantes;
import principal.entes.Jugador;
import principal.mapas.Mapa;
import principal.maquinaEstado.EstadoJuego;

public class GestorJuego implements EstadoJuego {

	// private GestorMapa gm;
	Mapa mapa = new Mapa(Constantes.MAPA_1);
	Jugador jugador = new Jugador(0, 0, mapa);

	@Override
	public void actualizar() {
		jugador.actualizar();
		mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
	}

	@Override
	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);
	}

}
