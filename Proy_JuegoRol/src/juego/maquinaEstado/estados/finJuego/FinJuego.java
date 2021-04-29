package juego.maquinaEstado.estados.finJuego;

import java.awt.Graphics;

import juego.entes.Estadisticas;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase que se encarga del estado delfin del juego
 * 
 * @author Fernando Martino
 *
 */
public class FinJuego implements EstadoJuego {

	private EstructuraFin ei;
	private boolean finalizado;

	/**
	 * Contructor de la clase Fin de Juego.
	 */
	public FinJuego(Estadisticas estadisticas) {
		ei = new EstructuraFin(estadisticas);
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
