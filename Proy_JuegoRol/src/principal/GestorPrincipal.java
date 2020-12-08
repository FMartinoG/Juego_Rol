package principal;

import principal.control.Controles;
import principal.graficos.*;
import principal.maquinaEstado.GestorEstados;

/**
 * Clase encargada de reunir todos los objetos para que el juego funcione.
 * 
 * @author Fernando Martino
 *
 */
public class GestorPrincipal {
	private boolean enFuncionamiento = false;
	private String titulo;
	private int ancho;
	private int alto;
	private static int fps = 0;
	private static int aps = 0;

	private SuperficieDeDibujo sd;
	@SuppressWarnings("unused")
	private Ventana ventana;
	private GestorEstados ge;

	public GestorPrincipal(String titulo, int ancho, int alto) {
		this.titulo = titulo;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void iniciarJuego() {
		enFuncionamiento = true;
		inicializar();
	}

	private void inicializar() {
		sd = new SuperficieDeDibujo(ancho, alto);
		ventana = new Ventana(titulo, sd);
		ge = new GestorEstados();
	}

	public void iniciarBuclePrincipal() {
		int actualizacionesAcumuladas = 0;
		int framesAcumulados = 0;
		final int NS_POR_SEG = 1000000000;
		final int APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEG / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		while (enFuncionamiento) {
			// Metodo para calcular los aps y fps.
			final long INICIO_BUCLE = System.nanoTime();

			tiempoTranscurrido = INICIO_BUCLE - referenciaActualizacion;
			referenciaActualizacion = INICIO_BUCLE;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				++actualizacionesAcumuladas;
				--delta;
			}

			// Muestra lo que tenga que mostrar en la ventana
			dibujar();
			++framesAcumulados;

			if ((System.nanoTime() - referenciaContador) > NS_POR_SEG) {
				aps = actualizacionesAcumuladas;
				fps = framesAcumulados;

				actualizacionesAcumuladas = 0;
				framesAcumulados = 0;
				referenciaContador = System.nanoTime();
			}
			// Fin método para calcular los aps y los fps.
		}
	}

	private void dibujar() {
		sd.dibujar(ge);
	}

	private void actualizar() {
		if (ge.getPosicionActual() != 0) {
			if (Controles.TECLADO.menuAbierto) {
				ge.cambiarEstado(2);
			} else {
				ge.cambiarEstado(1);
			}
		}

		ge.actualizar();

	}

	public static int getFps() {
		return fps;
	}

	public static int getAps() {
		return aps;
	}
}
