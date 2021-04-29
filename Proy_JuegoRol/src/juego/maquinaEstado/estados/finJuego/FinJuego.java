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
