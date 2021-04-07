package juego.HUD;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.sound.sampled.Clip;

import juego.Constantes;
import juego.herramientas.CargadorRecursos;

/**
 * Clase encargada de crear los mensajes y dibujarlos.
 * 
 * @author fernando Martino
 *
 */
public class Mensaje {

	private String mensaje;
	private boolean marco;
	private int posX, posY;

	/**
	 * Contructor de la clase Mensaje.
	 * 
	 * @param mensaje
	 * @param posX
	 * @param posY
	 * @param marco
	 */
	public Mensaje(String mensaje, int posX, int posY, boolean marco) {
		this.mensaje = mensaje;
		this.posX = posX;
		this.posY = posY;
		this.marco = marco;
	}

	/**
	 * Método encargado de dibujar el mensaje en la ventana.
	 * 
	 * @param g
	 */
	public void dibujar(Graphics g) {
		// Guarda las métricas de la fuente actual.
		FontMetrics fm = g.getFontMetrics();
		if (marco) {
			int longitudMarco = fm.stringWidth(mensaje);
			g.setColor(Color.white);
			g.drawRect(posX, posY, longitudMarco + 50, 30);
			g.setColor(Color.black);
			g.fillRect(posX, posY, longitudMarco + 50, 30);
		}
		g.setColor(Color.white);
		int puntero = 0;
		int avance = 0;
		String[] palabras = mensaje.split(" ");
		for (int i = 0; i < palabras.length; ++i) {
			g.drawString(palabras[i], posX + 10 + puntero, posY + 15);
			avance = fm.stringWidth(palabras[i]);
			puntero += avance + 5;
			Clip beep = CargadorRecursos.cargarSonido(Constantes.BEEP);
			beep.start();
			long inicio = System.currentTimeMillis();
			while ((System.currentTimeMillis() - inicio) < 250) {
			}
			beep.stop();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (marco) {
			String texto_continuar = "'Enter' para continuar";
			g.drawString(texto_continuar, posX, posY + 40);
		}
	}

	/**
	 * Método encargado de dibujar el mensaje en medio del combate.
	 * 
	 * @param g
	 */
	public void dibujarMensajeCombate(Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int longitudMarco = fm.stringWidth(mensaje);
		g.setColor(Color.white);
		g.drawRect(posX, posY, longitudMarco + 50, 30);
		g.setColor(Color.black);
		g.fillRect(posX, posY, longitudMarco + 50, 30);
		g.setColor(Color.white);
		g.drawString(mensaje + "", posX + 10, posY + 15);

	}

}
