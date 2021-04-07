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
 * Clase encargada de dibujar el men� principal.
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

	/**
	 * Constructor de la clase de Estructar del men� principal.
	 */
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

	/**
	 * M�todo encargado de actualizar los componentes del men� principal.
	 */
	public void actualizar() {
		// Cuando utiliza las flechas se modifica la secci�n seleccionada.
		if (Controles.TECLADO.arribaMenu && puntero > 0) {
			puntero -= 0.3;
			seccionActual = secciones[(int) puntero];
		}
		if (Controles.TECLADO.abajoMenu && puntero < secciones.length - 1) {
			puntero += 0.3;
			seccionActual = secciones[(int) puntero];
		}

		// Cuando se cambia de secci�n seleccionada suena un sonido.
		if ((int) puntero != punteroAnterior) {
			Clip beep = CargadorRecursos.cargarSonido(Constantes.BEEP);
			beep.start();
			long inicio = System.currentTimeMillis();
			while ((System.currentTimeMillis() - inicio) < 100) {
			}
			beep.stop();
			punteroAnterior = (int) puntero;
		}

		// Comprueba si se pulsa el bot�n de selecci�n en alguna de las
		// secciones.
		if (seccionActual == secciones[0] && Controles.TECLADO.seleccion)
			nuevaPartidaSeleccionada = true;

		if (seccionActual == secciones[1] && Controles.TECLADO.seleccion)
			cargarPartidaSeleccionada = true;

		if (seccionActual == secciones[2] && Controles.TECLADO.seleccion)
			ventanaInformacion = true;

		if (seccionActual == secciones[3] && Controles.TECLADO.seleccion)
			System.exit(0);
	}

	/**
	 * M�todo encargado de dibujar los componentes del men� principal.
	 * 
	 * @param g
	 */
	public void dibujar(Graphics g) {
		g.setColor(COLOR_SUPERIOR);
		g.fillRect(SUPERIOR.x, SUPERIOR.y, SUPERIOR.width, SUPERIOR.height);
		g.setColor(COLOR_FONDO);
		g.fillRect(FONDO.x, FONDO.y, FONDO.width, FONDO.height);

		g.setColor(Color.black);
		g.drawRect(0, 300, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - 300);

		g.drawString("'W A S D' Mover al personaje", 5, 320);
		g.drawString("'Shift' Correr", 5, 350);
		g.drawString("'I' Para abrir el men� del juego", 190, 320);
		g.drawString("'F1' Para mostrar/cerrar FPS", 190, 350);
		g.drawString("Flechas para moverse en los men�s", 370, 320);
		g.drawString("'Enter' para seleccionar una opcion de men�", 370, 350);

		for (Seccion s : secciones) {
			if (seccionActual == s)
				s.dibujarEtiquetaActiva(g);
			else
				s.dibujarEtiquetaInactiva(g);
		}
	}

	/**
	 * Devuelve si se ha seleccionado la opci�n de nueva partida.
	 * 
	 * @return nuevaPartidaSeleccionada boolean
	 */
	public boolean isNuevaPartidaSeleccionada() {
		return nuevaPartidaSeleccionada;
	}

	/**
	 * Devuelve si se ha seleccionado la opci�n de cargar partida.
	 * 
	 * @return cargarPartidaSeleccionada boolean
	 */
	public boolean isCargarPartidaSeleccionada() {
		return cargarPartidaSeleccionada;
	}

	/**
	 * Devuelve si se ha seleccionado la opci�n de entrar a la pantalla de
	 * informaci�n.
	 * 
	 * @return ventanaInformacion boolean
	 */
	public boolean isVentanaInformacion() {
		return ventanaInformacion;
	}

}
