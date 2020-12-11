package principal.sprites;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Clase encargada de leer los sprites.
 * 
 * @author Fernando Martino
 *
 */
public class Sprite implements Serializable{

	private final BufferedImage imagen;
	private final int ancho;
	private final int alto;

	public Sprite(final BufferedImage imagen) {
		this.imagen = imagen;
		ancho = imagen.getHeight();
		alto = imagen.getHeight();
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
