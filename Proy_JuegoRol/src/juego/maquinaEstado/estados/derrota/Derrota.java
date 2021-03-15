package juego.maquinaEstado.estados.derrota;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * 
 * 
 * @author Fernando Martino
 *
 */
public class Derrota implements EstadoJuego {

	private EstructuraDerrota ei;
	private boolean finalizado;

	public Derrota() {
		ei = new EstructuraDerrota();
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
