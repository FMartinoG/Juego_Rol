package principal.control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.herramientas.CargadorRecursos;

public class Raton {

	private final Cursor cursor;
	
	public Raton() {
		Toolkit configuracion = Toolkit.getDefaultToolkit();
		BufferedImage icono = CargadorRecursos.cargarImagenTranslucida(Constantes.CURSOR);
		Point punta = new Point(0, 0);
		cursor = configuracion.createCustomCursor(icono, punta, "Cursor");
	}
	
	public Cursor getCursor() {
		return cursor;
	}
}
