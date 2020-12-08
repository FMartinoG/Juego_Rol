package principal.maquinaEstado.estados.menus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Clase abstracta de la que se crean las diferentes secciones de los menús.
 * 
 * @author Fernando Martino
 *
 */
public abstract class Seccion {

	protected final String nombre;
	protected final Rectangle etiqueta;

	public Seccion(String nombre, Rectangle etiqueta) {
		this.nombre = nombre;
		this.etiqueta = etiqueta;
	}

	public abstract void actualizar();

	public abstract void dibujar(Graphics g);

	public void dibujarEtiquetaInactiva(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(etiqueta.x - 1, etiqueta.y - 1, etiqueta.width + 2, etiqueta.height + 2);

		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);

		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 8, etiqueta.y + 15);
	}

	public void dibujarEtiquetaActiva(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(etiqueta.x - 1, etiqueta.y - 1, etiqueta.width + 2, etiqueta.height + 2);

		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);

		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 8, etiqueta.y + 15);

		g.setColor(Color.red);
		g.fillRect(etiqueta.x, etiqueta.y, 3, etiqueta.height);
	}

	public String getNombre() {
		return nombre;
	}

}
