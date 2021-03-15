package juego.maquinaEstado.estados.derrota;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import juego.Constantes;
import juego.HUD.Mensaje;

public class EstructuraDerrota {

	private boolean finalizado;

	public EstructuraDerrota() {
		finalizado = false;
	}

	public void actualizar() {
	}

	public void dibujar(Graphics g) {
		ponerPantallaNegro(g);

		mostrarMensajeDerrota(g);

		esperar(5000);

		finalizado = true;
	}

	private void mostrarMensajeDerrota(Graphics g) {
		ponerPantallaNegro(g);
		mostrarMensaje(g);
	}

	private void mostrarMensaje(Graphics g) {
		String texto = "HAS MUERTO";
		FontMetrics fm = g.getFontMetrics();
		int altura = (Constantes.ALTO_VENTANA / 2) - 100;
		int posicionX = (Constantes.ANCHO_VENTANA / 2) - ((fm.stringWidth(texto) / 2)) - 15;
		Mensaje ms = new Mensaje(texto, posicionX, altura, false);
		ms.dibujar(g);
		altura += 40;

	}

	private void ponerPantallaNegro(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}

	private void esperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isFinalizado() {
		return finalizado;
	}

}
