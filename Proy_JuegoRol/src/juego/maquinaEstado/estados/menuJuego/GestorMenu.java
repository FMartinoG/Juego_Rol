package juego.maquinaEstado.estados.menuJuego;

import java.awt.Graphics;

import juego.entes.Jugador;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el menú principal.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenu implements EstadoJuego {

	private EstructuraMenu em;

	public GestorMenu(Jugador jugador) {
		em = new EstructuraMenu(jugador);
	}

	@Override
	public void actualizar() {
		em.actualizar();
	}

	@Override
	public void dibujar(Graphics g) {
		em.dibujar(g);
	}

}
