package principal.maquinaEstado.estados.menuPrincipal;

import java.awt.Graphics;
import java.awt.Rectangle;

import principal.control.Controles;
import principal.maquinaEstado.EstadoJuego;
import principal.maquinaEstado.estados.menus.NuevaPartida;
import principal.maquinaEstado.estados.menus.Salir;
import principal.maquinaEstado.estados.menus.Seccion;

/**
 * Clase Estado de Juego encargada de crear el menú del juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenuPrincipal implements EstadoJuego {
	
	private EstructuraMenuPrincipal emp;
	private Seccion[] secciones;
	private Seccion seccionActual;

	private double puntero = 0;
	
	private boolean nuevaPartidaSeleccionada = false;
	
	public GestorMenuPrincipal() {
		emp = new EstructuraMenuPrincipal();
		
		secciones = new Seccion[2];
		secciones[0] = new NuevaPartida("NUEVA PARTIDA", new Rectangle(200, 100, 150, 20));
		secciones[1] = new Salir("SALIR", new Rectangle(200, 150, 150, 20));

		seccionActual = secciones[(int) puntero];
	}

	@Override
	public void actualizar() {
		if (Controles.TECLADO.arribaMenu && puntero > 0) {
			puntero -= 0.3;
			seccionActual = secciones[(int) puntero];
		}
		if (Controles.TECLADO.abajoMenu && puntero < secciones.length - 1) {
			puntero += 0.3;
			seccionActual = secciones[(int) puntero];
		}
		
		if(seccionActual == secciones[0] && Controles.TECLADO.seleccion)
			nuevaPartidaSeleccionada = true;
		
		if(seccionActual == secciones[1] && Controles.TECLADO.seleccion)
			System.exit(0);

	}

	@Override
	public void dibujar(Graphics g) {
		emp.dibujar(g);

		for (Seccion s : secciones) {
			if (seccionActual == s)
				s.dibujarEtiquetaActiva(g);
			else
				s.dibujarEtiquetaInactiva(g);
		}
	}
	
	public boolean nuevaPartida() {
		return nuevaPartidaSeleccionada;
	}

}
