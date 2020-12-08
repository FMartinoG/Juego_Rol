package principal.maquinaEstado.estados.menus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);
		
		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 5, etiqueta.y + 15);
	}
	
	public void dibujarEtiquetaActiva(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(etiqueta.x - 2, etiqueta.y - 2, etiqueta.width + 4, etiqueta.height + 4);
		
		g.setColor(Color.white);
		g.fillRect(etiqueta.x, etiqueta.y, etiqueta.width, etiqueta.height);
		
		g.setColor(Color.black);
		g.drawString(nombre, etiqueta.x + 5, etiqueta.y + 15);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	
}
