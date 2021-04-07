package juego.maquinaEstado;

import java.awt.Graphics;

/**
 * Interfaz de estados de juego.
 * 
 * @author Fernando Martino
 *
 */
public interface EstadoJuego {

	void actualizar();

	void dibujar(final Graphics g);
}
