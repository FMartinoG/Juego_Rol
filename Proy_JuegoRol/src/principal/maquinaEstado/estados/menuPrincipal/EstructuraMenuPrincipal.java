package principal.maquinaEstado.estados.menuPrincipal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import principal.Constantes;

/**
 * Clase encargada de dibujar el menú principal.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraMenuPrincipal {

	private final Color COLOR_SUPERIOR;
	private final Color COLOR_FONDO;

	private final Rectangle SUPERIOR;
	private final Rectangle FONDO;

	public EstructuraMenuPrincipal() {
		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		FONDO = new Rectangle(0, SUPERIOR.height, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - SUPERIOR.height);

	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);

		g.setColor(Color.black);
		g.drawString("'W' Arriba", 5, 70);
		g.drawString("'S' Abajo", 5, 90);
		g.drawString("'A' Izquierda", 5, 110);
		g.drawString("'D' Derecha", 5, 130);
		g.drawString("'Shift' Correr", 5, 150);
		g.drawString("'Esc' Para abrir el menú del juego", 5, 170);
		g.drawString("'F1' Para mostrar/cerrar FPS", 5, 190);
	}

}
