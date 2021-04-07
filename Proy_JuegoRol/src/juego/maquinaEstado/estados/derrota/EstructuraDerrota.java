package juego.maquinaEstado.estados.derrota;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import juego.Constantes;
import juego.HUD.Mensaje;

/**
 * Clase encargada de crear y controlar los elementos del estado de derrota.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraDerrota {

	private boolean finalizado;

	/**
	 * Contructor de la clase estructura de derrota.
	 */
	public EstructuraDerrota() {
		finalizado = false;
	}

	/**
	 * Método encargado de dibujar los elementos del estado.
	 * 
	 * @param g
	 */
	public void dibujar(Graphics g) {
		ponerPantallaNegro(g);

		mostrarMensaje(g);

		esperar(5000);

		finalizado = true;
	}

	/**
	 * Método encargado de mostrar el mensaje de derrota.
	 * 
	 * @param g
	 */
	private void mostrarMensaje(Graphics g) {
		String texto = "HAS MUERTO";
		FontMetrics fm = g.getFontMetrics();
		int altura = (Constantes.ALTO_VENTANA / 2) - 100;
		int posicionX = (Constantes.ANCHO_VENTANA / 2) - ((fm.stringWidth(texto) / 2)) - 15;
		Mensaje ms = new Mensaje(texto, posicionX, altura, false);
		ms.dibujar(g);
		altura += 40;

	}

	/**
	 * Método que dibuja toda la ventana de negro.
	 * 
	 * @param g
	 */
	private void ponerPantallaNegro(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}

	/**
	 * Método que detiene la ejecución durante el tiempo determinado.
	 * 
	 * @param time
	 */
	private void esperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Indica si el estado ha terminado.
	 * 
	 * @return
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
