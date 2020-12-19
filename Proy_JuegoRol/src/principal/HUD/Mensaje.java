package principal.HUD;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Mensaje {

	private String mensaje;
	private boolean marco;
	private int posX, posY;

	public Mensaje(String mensaje, int posX, int posY, boolean marco) {
		this.mensaje = mensaje;
		this.posX = posX;
		this.posY = posY;
		this.marco = marco;
	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
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
		for (int i = 0; i < mensaje.length(); ++i) {
			g.drawString(mensaje.charAt(i) + "", posX + 10   + puntero, posY + 10);
			avance = fm.stringWidth(mensaje.charAt(i) + "");
			puntero += avance;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
