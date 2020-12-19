package principal.maquinaEstado.estados.menuJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import principal.Constantes;
import principal.GuardarPartida;
import principal.control.Controles;
import principal.entes.Jugador;
import principal.maquinaEstado.estados.menus.Seccion;

/**
 * Clase encargada de dibujar el men� de juego.
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

	private Jugador jugador;
	private Seccion[] secciones;
	private Seccion seccionActual;
	private double puntero;

	public EstructuraMenu(Jugador jugador) {
		this.jugador = jugador;

		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_LATERAL = Color.black;
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		LATERAL = new Rectangle(0, SUPERIOR.height, 100, Constantes.ALTO_VENTANA - SUPERIOR.height);
		FONDO = new Rectangle(LATERAL.width, SUPERIOR.height, Constantes.ANCHO_VENTANA - LATERAL.width,
				Constantes.ALTO_VENTANA - SUPERIOR.height);

		puntero = 0;
		secciones = new Seccion[4];
		secciones[0] = new Seccion("Estad�sticas", new Rectangle(5, 60, 80, 20));
		secciones[1] = new Seccion("Inventario", new Rectangle(5, 100, 80, 20));
		secciones[2] = new Seccion("Guardar", new Rectangle(5, 140, 80, 20));
		secciones[3] = new Seccion("Salir", new Rectangle(5, 180, 80, 20));

		seccionActual = secciones[(int) puntero];

	}

	public void actualizar() {
		if (Controles.TECLADO.arribaMenu && puntero > 0) {
			puntero -= 0.2;
			seccionActual = secciones[(int) puntero];
		}
		if (Controles.TECLADO.abajoMenu && puntero < secciones.length - 1) {
			puntero += 0.2;
			seccionActual = secciones[(int) puntero];
		}

		if (seccionActual == secciones[2] && Controles.TECLADO.seleccion)
			GuardarPartida.guardar(jugador);

		if (seccionActual == secciones[3] && Controles.TECLADO.seleccion)
			System.exit(0);
	}

	public void dibujar(Graphics g) {
		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_LATERAL);
		g.fillRect(LATERAL.x, LATERAL.y, LATERAL.width, LATERAL.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);

		for (Seccion s : secciones) {
			if (seccionActual == s)
				s.dibujarEtiquetaActiva(g);
			else
				s.dibujarEtiquetaInactiva(g);
		}
	}

}
