package juego.maquinaEstado.estados.menuJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.sound.sampled.Clip;

import juego.Constantes;
import juego.HUD.Barras;
import juego.control.Controles;
import juego.entes.Estadisticas;
import juego.entes.Jugador;
import juego.guardado_cargado.GuardarPartida;
import juego.herramientas.CargadorRecursos;
import juego.maquinaEstado.estados.menus.Seccion;

/**
 * Clase encargada de controlar y dibujar el menú de juego.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraMenu {

	private boolean estadisticasSeleccionado;
	private boolean informacionSeleccionado;

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
	private int punteroAnterior;

	private int pulsacion;

	private boolean guardado;

	public EstructuraMenu(Jugador jugador) {
		this.jugador = jugador;
		estadisticasJugador = jugador.getEstadisticas();

		estadisticasSeleccionado = false;
		informacionSeleccionado = false;
		pulsacion = 0;
		guardado = false;

		COLOR_SUPERIOR = new Color(124, 3, 3);
		COLOR_LATERAL = Color.black;
		COLOR_FONDO = Color.white;

		SUPERIOR = new Rectangle(0, 0, Constantes.ANCHO_VENTANA, 30);
		LATERAL = new Rectangle(0, SUPERIOR.height, 100, Constantes.ALTO_VENTANA - SUPERIOR.height);
		FONDO = new Rectangle(LATERAL.width, SUPERIOR.height, Constantes.ANCHO_VENTANA - LATERAL.width,
				Constantes.ALTO_VENTANA - SUPERIOR.height);

		puntero = punteroAnterior = 0;
		secciones = new Seccion[4];
		secciones[0] = new Seccion("Estadísticas", new Rectangle(5, 60, 80, 20));
		secciones[1] = new Seccion("Información", new Rectangle(5, 100, 80, 20));
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

		if ((int) puntero != punteroAnterior) {
			Clip beep = CargadorRecursos.cargarSonido(Constantes.BEEP);
			beep.start();
			long inicio = System.currentTimeMillis();
			while ((System.currentTimeMillis() - inicio) < 100) {
			}
			beep.stop();
			punteroAnterior = (int) puntero;
		}

		if (seccionActual == secciones[0]) {
			estadisticasSeleccionado = true;
		} else
			estadisticasSeleccionado = false;

		if (seccionActual == secciones[1]) {
			informacionSeleccionado = true;
		} else
			informacionSeleccionado = false;

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

		if (informacionSeleccionado) {
			dibujarInformacion(g);
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

	private void dibujarInformacion(Graphics g) {
		g.setColor(Color.black);
		g.drawString("INFORMACIÓN DEL JUEGO:", 150, 60);
		g.drawString("Durante los combates, el enemigo solo atacará cuando tú le ataques.", 150, 80);
		g.drawString("Todos los enemigos del juego pueden ser superados sin pelear, usando las acciones.", 150, 100);
		g.drawString("Todas las magias te costarán 20 puntos de mana.", 150, 120);
		g.drawString("Todo tipo de ataque tendrá un valor aleatorio entre 0 y el nivel de ataque o el poder mágico.", 150, 140);
		
		g.drawString("Este juego no guarda automáticamente.", 150, 180);
		g.drawString("Cada vez que se guarda la partida se sobreescribe el guardado anterior.", 150, 200);
	}

	private void dibujarEstadisticas(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Nivel: " + jugador.getEstadisticas().getNivel(), 150, 60);

		dibujarBarraVida(g);
		dibujarBarraMana(g);
		dibujarBarraExp(g);
		dibujarInformacionEstadisticas(g);
	}

	private void dibujarBarraVida(Graphics g) {
		Barras vida = new Barras(g, jugador, 150, 90);
		vida.dibujarBarraVidaMenu();
	}

	private void dibujarBarraMana(Graphics g) {
		Barras mana = new Barras(g, jugador, 150, 130);
		mana.dibujarBarraManaMenu();
	}

	private void dibujarBarraExp(Graphics g) {
		Barras exp = new Barras(g, jugador, 150, 170);
		exp.dibujarBarraExpMenu();
	}

	private void dibujarInformacionEstadisticas(Graphics g) {
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
