package principal.maquinaEstado;

import java.awt.Graphics;

/**
 * Interfaz de los diferentes estados de juego.
 * 
 * @author Fernando Martino
 *
 */
public interface EstadoJuego {

	void actualizar();

	void dibujar(final Graphics g);
}
