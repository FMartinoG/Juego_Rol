package principal.maquinaEstado.estados.menuJuego;

import java.awt.Graphics;
import java.awt.Rectangle;

import principal.control.Controles;
import principal.maquinaEstado.EstadoJuego;
import principal.maquinaEstado.estados.menus.Estadisticas;
import principal.maquinaEstado.estados.menus.Inventario;
import principal.maquinaEstado.estados.menus.Salir;
import principal.maquinaEstado.estados.menus.Seccion;

/**
 * Clase Estado de Juego encargada de crear el menú principal.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenu implements EstadoJuego {

	private EstructuraMenu em;
	private Seccion[] secciones;
	private Seccion seccionActual;

	private double puntero = 0;

	public GestorMenu() {
		em = new EstructuraMenu();

		secciones = new Seccion[3];
		secciones[0] = new Estadisticas("Estadísticas", new Rectangle(5, 60, 80, 20));
		secciones[1] = new Inventario("Inventario", new Rectangle(5, 100, 80, 20));
		secciones[2] = new Salir("SALIR", new Rectangle(5, 140, 80, 20));

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
		
		if(seccionActual == secciones[2] && Controles.TECLADO.seleccion)
			System.exit(0);

	}

	@Override
	public void dibujar(Graphics g) {
		em.dibujar(g);

		for (Seccion s : secciones) {
			if (seccionActual == s)
				s.dibujarEtiquetaActiva(g);
			else
				s.dibujarEtiquetaInactiva(g);
		}
	}

}
