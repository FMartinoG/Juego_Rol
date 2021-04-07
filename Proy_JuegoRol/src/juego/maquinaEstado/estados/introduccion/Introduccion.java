package juego.maquinaEstado.estados.introduccion;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase que se encarga del estado de la introduccio�n del juego
 * 
 * @author Fernando Martino
 *
 */
public class Introduccion implements EstadoJuego {

	private EstructuraIntroduccion ei;
	private boolean finalizado;

	/**
	 * Contructor de la clase Introducci�n.
	 */
	public Introduccion() {
		ei = new EstructuraIntroduccion();
		finalizado = false;
	}

	/**
	 * M�todo encargado de actualizar el estado en cada actualizaci�n del juego.
	 */
	@Override
	public void actualizar() {
		ei.actualizar();
		if (ei.isFinalizado())
			finalizado = true;
	}

	/**
	 * M�todo encargado de dibujar el estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		ei.dibujar(g);
	}

	/**
	 * M�todo que indica si ya ha finalizado el estado de introducci�n.
	 * 
	 * @return finalizado boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
