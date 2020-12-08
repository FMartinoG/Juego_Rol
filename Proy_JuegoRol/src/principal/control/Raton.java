package principal.control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.herramientas.CargadorRecursos;

/**
 * Crea un cursor invisible.
 * 
 * @author Fernando Martino
 *
 */
public class Raton {

	private final Cursor cursor;

	public Raton() {
		Toolkit configuracion = Toolkit.getDefaultToolkit();
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Point punta = new Point(0, 0);
		cursor = configuracion.createCustomCursor(cursorImg, punta, "Cursor");
	}

	public Cursor getCursor() {
		return cursor;
	}
}
