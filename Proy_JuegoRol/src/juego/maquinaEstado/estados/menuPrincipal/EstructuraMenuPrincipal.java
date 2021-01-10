package juego.maquinaEstado.estados.menuPrincipal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.sound.sampled.Clip;

import juego.Constantes;
import juego.control.Controles;
import juego.herramientas.CargadorRecursos;
import juego.maquinaEstado.estados.menus.Seccion;

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

	private Seccion[] secciones;
	private Seccion seccionActual;

	private double puntero;
	private int punteroAnterior;

	private boolean nuevaPartidaSeleccionada = false;
	private boolean cargarPartidaSeleccionada = false;
	private boolean ventanaInformacion = false;

	public EstructuraMenuPrincipal() {
		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		FONDO = new Rectangle(0, SUPERIOR.height, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - SUPERIOR.height);

		secciones = new Seccion[4];
		secciones[0] = new Seccion("NUEVA PARTIDA", new Rectangle(200, 100, 150, 20));
		secciones[1] = new Seccion("CARGAR PARTIDA", new Rectangle(200, 150, 150, 20));
		secciones[2] = new Seccion("ACERCA DE...", new Rectangle(200, 200, 150, 20));
		secciones[3] = new Seccion("SALIR", new Rectangle(200, 250, 150, 20));

		puntero = punteroAnterior = 0;
		seccionActual = secciones[(int) puntero];

	}

	public void actualizar() {
		if (Controles.TECLADO.arribaMenu && puntero > 0) {
			puntero -= 0.3;
			seccionActual = secciones[(int) puntero];
		}
		if (Controles.TECLADO.abajoMenu && puntero < secciones.length - 1) {
			puntero += 0.3;
			seccionActual = secciones[(int) puntero];
		}

		if ((int) puntero != punteroAnterior) {
			Clip beep = CargadorRecursos.cargarSonido(Constantes.BEEP);
			beep.start();
			long inicio = System.currentTimeMillis();
			while ((System.currentTimeMillis() - inicio) < 100) {
			}
			beep.stop();
			punteroAnterior = (int) puntero;
		}

		if (seccionActual == secciones[0] && Controles.TECLADO.seleccion)
			nuevaPartidaSeleccionada = true;

		if (seccionActual == secciones[1] && Controles.TECLADO.seleccion)
			cargarPartidaSeleccionada = true;

		if (seccionActual == secciones[2] && Controles.TECLADO.seleccion)
			ventanaInformacion = true;

		if (seccionActual == secciones[3] && Controles.TECLADO.seleccion)
			System.exit(0);
	}

	public void dibujar(Graphics g) {
		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);

		g.setColor(Color.black);
		g.drawRect(0, 300, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - 300);

		g.drawString("'W A S D' Mover al personaje", 5, 320);
		g.drawString("'Shift' Correr", 5, 350);
		g.drawString("'I' Para abrir el menú del juego", 190, 320);
		g.drawString("'F1' Para mostrar/cerrar FPS", 190, 350);
		g.drawString("Flechas para moverse en los menús", 370, 320);
		g.drawString("'Enter' para seleccionar una opcion de menú", 370, 350);

		for (Seccion s : secciones) {
			if (seccionActual == s)
				s.dibujarEtiquetaActiva(g);
			else
				s.dibujarEtiquetaInactiva(g);
		}
	}

	public boolean isNuevaPartidaSeleccionada() {
		return nuevaPartidaSeleccionada;
	}

	public boolean isCargarPartidaSeleccionada() {
		return cargarPartidaSeleccionada;
	}

	public boolean isVentanaInformacion() {
		return ventanaInformacion;
	}

}
