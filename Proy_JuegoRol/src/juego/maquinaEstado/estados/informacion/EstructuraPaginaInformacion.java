package juego.maquinaEstado.estados.informacion;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import juego.Constantes;
import juego.control.Controles;

/**
 * Clase encargada de controlar y dibujar la página de información
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraPaginaInformacion {
	private final Color COLOR_SUPERIOR;
	private final Color COLOR_FONDO;

	private final Rectangle SUPERIOR;
	private final Rectangle FONDO;

	private boolean pulsadoVolver;

	public EstructuraPaginaInformacion() {
		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		FONDO = new Rectangle(0, SUPERIOR.height, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - SUPERIOR.height);

		pulsadoVolver = false;
	}

	public void actualizar() {
		if (Controles.TECLADO.bt_Escape) {
			pulsadoVolver = true;
		}

	}

	public void dibujar(Graphics g) {
		FontMetrics fm = g.getFontMetrics();

		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);

		g.setColor(Color.black);
		String texto1 = "Juego desarrollado por: Fernando Martino García.";
		String texto2 = "Programado en Java.";
		String texto3 = "Programado por: Fernando Martino García.";
		String texto4 = "Historia original de: Fernando Martino García.";
		String texto5 = "URL repositorio GIT: https://github.com/FMartinoG/Juego_Rol.git";
		String texto6 = "Sonidos sin derechos de autor.";

		g.drawString(texto1, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto1) / 2), 70);
		g.drawString(texto2, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto2) / 2), 110);
		g.drawString(texto3, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto3) / 2), 150);
		g.drawString(texto4, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto4) / 2), 190);
		g.drawString(texto5, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto5) / 2), 230);
		g.drawString(texto6, (Constantes.ANCHO_VENTANA / 2) - (fm.stringWidth(texto6) / 2), 270);
		g.drawString("Esc para volver.", 25, 350);
	}

	public boolean isPulsadoVolver() {
		return pulsadoVolver;
	}
}
