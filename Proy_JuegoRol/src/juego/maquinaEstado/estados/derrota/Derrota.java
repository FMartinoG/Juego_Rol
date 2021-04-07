package juego.maquinaEstado.estados.derrota;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * _Clase encargada de mostrar y controlar el estado de derrota.
 * 
 * @author Fernando Martino
 *
 */
public class Derrota implements EstadoJuego {

	private EstructuraDerrota ei;
	private boolean finalizado;

	/**
	 * Constructor de la clase derrota.
	 */
	public Derrota() {
		ei = new EstructuraDerrota();
		finalizado = false;
	}

	/**
	 * Método encargado de actualizar el estado.s
	 */
	@Override
	public void actualizar() {
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
	 * Indica si el estado ya ha finalizado.
	 * 
	 * @return finalizado boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
