package juego.maquinaEstado.estados.menuJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import juego.Constantes;
import juego.control.Controles;
import juego.entes.Estadisticas;
import juego.entes.Jugador;
import juego.guardado_cargado.GuardarPartida;
import juego.maquinaEstado.estados.menus.Seccion;

/**
 * Clase encargada de dibujar el menú de juego.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraMenu {

	private boolean estadisticasSeleccionado;
	private boolean inventarioSeleccionado;

	private Estadisticas estadisticasJugador;

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

	private int pulsacion;

	private boolean guardado;

	public EstructuraMenu(Jugador jugador) {
		this.jugador = jugador;
		estadisticasJugador = jugador.getEstadisticas();

		estadisticasSeleccionado = false;
		inventarioSeleccionado = false;
		pulsacion = 0;
		guardado = false;

		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_LATERAL = Color.black;
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		LATERAL = new Rectangle(0, SUPERIOR.height, 100, Constantes.ALTO_VENTANA - SUPERIOR.height);
		FONDO = new Rectangle(LATERAL.width, SUPERIOR.height, Constantes.ANCHO_VENTANA - LATERAL.width,
				Constantes.ALTO_VENTANA - SUPERIOR.height);

		puntero = 0;
		secciones = new Seccion[4];
		secciones[0] = new Seccion("Estadísticas", new Rectangle(5, 60, 80, 20));
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

		if (seccionActual == secciones[0]) {
			estadisticasSeleccionado = true;
		} else
			estadisticasSeleccionado = false;

		if (seccionActual == secciones[1]) {
			inventarioSeleccionado = true;
		} else
			inventarioSeleccionado = false;

		if (seccionActual == secciones[2] && Controles.TECLADO.seleccion && pulsacion == 0) {
			++pulsacion;
			int resultado = GuardarPartida.guardar(jugador);
			if (resultado == 1) {
				guardado = true;
			}
		}

		if (seccionActual == secciones[3] && Controles.TECLADO.seleccion)
			System.exit(0);

		if (pulsacion > 0 && !Controles.TECLADO.seleccion) {
			pulsacion = 0;
		}
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

		if (estadisticasSeleccionado)
			dibujarEstadisticas(g);
		
		if(inventarioSeleccionado) {
			dibujarInventario(g);
		}

		if (guardado) {
			long tiempoActual = System.currentTimeMillis();
			while ((System.currentTimeMillis() - tiempoActual) < 2000) {
				g.setColor(Color.darkGray);
				g.fillRoundRect(280, 180, 110, 30, 10, 10);
				g.setColor(Color.white);
				g.drawString("Partida guardada", 290, 200);
			}
			guardado = false;
		}

	}

	private void dibujarInventario(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	private void dibujarEstadisticas(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Nivel: " + jugador.getEstadisticas().getNivel(), 150, 60);

		dibujarBarraVida(g);
		dibujarBarraMana(g);
		dibujarBarraExp(g);
		dibujarInformacion(g);
	}

	private void dibujarBarraVida(Graphics g) {
		double salud = ((double) estadisticasJugador.getSalud() / (double) estadisticasJugador.getSaludMaxima()) * 100;

		g.setColor(Color.black);
		g.drawString("PS", 150, 90);
		g.fillRect(175, 80, 100, 12);
		g.setColor(Color.red);
		g.fillRect(175, 80, (int) salud, 4);
		g.setColor(new Color(150, 0, 0));
		g.fillRect(175, 84, (int) salud, 8);
		g.setColor(Color.black);
		g.drawString(estadisticasJugador.getSalud() + " / " + estadisticasJugador.getSaludMaxima(), 300, 90);
	}

	private void dibujarBarraMana(Graphics g) {
		double mana = ((double) estadisticasJugador.getMana() / (double) estadisticasJugador.getManaMaximo()) * 100;

		g.setColor(Color.black);
		g.drawString("PM", 150, 130);
		g.fillRect(175, 120, 100, 12);
		g.setColor(Color.blue);
		g.fillRect(175, 120, (int) mana, 4);
		g.setColor(new Color(0, 0, 150));
		g.fillRect(175, 124, (int) mana, 8);
		g.setColor(Color.black);
		g.drawString(estadisticasJugador.getMana() + " / " + estadisticasJugador.getManaMaximo(), 300, 130);
	}

	private void dibujarBarraExp(Graphics g) {
		double exp = ((double) estadisticasJugador.getExp() / (double) estadisticasJugador.getExpMaxima()) * 100;

		g.setColor(Color.black);
		g.drawString("EXP", 150, 170);
		g.fillRect(175, 160, 100, 12);
		g.setColor(new Color(127, 49, 255));
		g.fillRect(175, 160, (int) exp, 4);
		g.setColor(new Color(99, 29, 214));
		g.fillRect(175, 164, (int) exp, 8);
		g.setColor(Color.black);
		g.drawString("" + estadisticasJugador.getExp() + " / " + estadisticasJugador.getExpMaxima(), 300, 170);
	}
	
	private void dibujarInformacion(Graphics g) {
		g.setColor(Color.black);
		g.drawString("ATAQUE FÍSICO", 150, 200);
		g.drawString("DEFENSA FÍSICA", 150, 220);
		g.drawString("PODER MÁGICO", 150, 240);
		g.drawString("DEFENSA MÁGICA", 150, 260);
		
		g.drawString(" > ", 275, 198);
		g.drawString(" > ", 275, 218);
		g.drawString(" > ", 275, 238);
		g.drawString(" > ", 275, 258);
		
		g.drawString("" + estadisticasJugador.getAtaque(), 310, 200);
		g.drawString("" + estadisticasJugador.getDefensa(), 310, 220);
		g.drawString("" + estadisticasJugador.getPoderMagico(), 310, 240);
		g.drawString("" + estadisticasJugador.getDefensaMagica(), 310, 260);
	}

}
