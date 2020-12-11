package principal.maquinaEstado.estados.menuJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import principal.Constantes;
import principal.entes.Jugador;

/**
 * Clase encargada de dibujar el menú de juego.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraMenu {

	private final Color COLOR_SUPERIOR;
	private final Color COLOR_LATERAL;
	private final Color COLOR_FONDO;

	private final Rectangle SUPERIOR;
	private final Rectangle LATERAL;
	private final Rectangle FONDO;

	public EstructuraMenu() {
		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_LATERAL = Color.black;
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		LATERAL = new Rectangle(0, SUPERIOR.height, 100, Constantes.ALTO_VENTANA - SUPERIOR.height);
		FONDO = new Rectangle(LATERAL.width, SUPERIOR.height, Constantes.ANCHO_VENTANA - LATERAL.width,
				Constantes.ALTO_VENTANA - SUPERIOR.height);

	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_LATERAL);
		g.fillRect(LATERAL.x, LATERAL.y, LATERAL.width, LATERAL.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);
	}

}
