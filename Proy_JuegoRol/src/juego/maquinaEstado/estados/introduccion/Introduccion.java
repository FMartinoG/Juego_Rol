package juego.maquinaEstado.estados.introduccion;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase que se encarga del estado de la introduccioón del juego
 * 
 * @author Fernando Martino
 *
 */
public class Introduccion implements EstadoJuego {

	private EstructuraIntroduccion ei;
	private boolean finalizado;

	/**
	 * Contructor de la clase Introducción.
	 */
	public Introduccion() {
		ei = new EstructuraIntroduccion();
		finalizado = false;
	}

	/**
	 * Método encargado de actualizar el estado en cada actualización del juego.
	 */
	@Override
	public void actualizar() {
		ei.actualizar();
		if (ei.isFinalizado())
			finalizado = true;
	}

	/**
	 * Método encargado de dibujar el estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		ei.dibujar(g);
	}

	/**
	 * Método que indica si ya ha finalizado el estado de introducción.
	 * 
	 * @return finalizado boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
