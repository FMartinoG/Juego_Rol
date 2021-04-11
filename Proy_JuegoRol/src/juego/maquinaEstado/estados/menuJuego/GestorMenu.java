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

	/**
	 * Contructor del menú del juego.
	 * 
	 * @param jugador Jugador - Objeto jugador.
	 */
	public GestorMenu(Jugador jugador) {
		em = new EstructuraMenu(jugador);
	}

	/**
	 * Método encargado de actualizar el menú del juego en cada actualización
	 * del juego.
	 */
	@Override
	public void actualizar() {
		em.actualizar();
	}

	/**
	 * Método encargado de dibujar el menú del juego.
	 */
	@Override
	public void dibujar(Graphics g) {
		em.dibujar(g);
	}

}
