package juego.maquinaEstado.estados.menuJuego;

import java.awt.Graphics;

import juego.entes.Jugador;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el men� principal.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenu implements EstadoJuego {

	private EstructuraMenu em;

	/**
	 * Contructor del men� del juego.
	 * 
	 * @param jugador Jugador - Objeto jugador.
	 */
	public GestorMenu(Jugador jugador) {
		em = new EstructuraMenu(jugador);
	}

	/**
	 * M�todo encargado de actualizar el men� del juego en cada actualizaci�n
	 * del juego.
	 */
	@Override
	public void actualizar() {
		em.actualizar();
	}

	/**
	 * M�todo encargado de dibujar el men� del juego.
	 */
	@Override
	public void dibujar(Graphics g) {
		em.dibujar(g);
	}

}
