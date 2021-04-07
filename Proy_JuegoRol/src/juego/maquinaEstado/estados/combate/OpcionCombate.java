package juego.maquinaEstado.estados.combate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Clase de la que se crean las diferentes secciones de los menús.
 * 
 * @author Fernando Martino
 *
 */
public class OpcionCombate {

	private final String nombre;
	private final Rectangle etiqueta;

	/**
	 * Constructor de la clase opcion de combate.
	 * 
	 * @param nombre
	 * @param etiqueta
	 */
	public OpcionCombate(String nombre, Rectangle etiqueta) {
		this.nombre = nombre;
		this.etiqueta = etiqueta;
	}

	/**
	 * Método que dibuja las etiquetas que no están seleccionadas.
	 * 
	 * @param g
	 */
	public void dibujarEtiquetaInactiva(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(etiqueta.x - 1, etiqueta.y - 1, etiqueta.width + 2, etiqueta.height + 2);

		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);

		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 5, etiqueta.y + 20);
	}

	/**
	 * Método que dibuja las etiquetas que están seleccionadas.
	 * 
	 * @param g
	 */
	public void dibujarEtiquetaActiva(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);

		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 5, etiqueta.y + 20);

		g.setColor(Color.red);
		g.drawRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);
	}
}
