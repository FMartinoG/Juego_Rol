package juego.maquinaEstado.estados.introduccion;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * 
 * 
 * @author Fernando Martino
 *
 */
public class Introduccion implements EstadoJuego {

	private EstructuraIntroduccion ei;
	private boolean finalizado;

	public Introduccion() {
		ei = new EstructuraIntroduccion();
		finalizado = false;
	}

	@Override
	public void actualizar() {
		ei.actualizar();
		if (ei.isFinalizado())
			finalizado = true;
	}

	@Override
	public void dibujar(Graphics g) {
		ei.dibujar(g);
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

}
