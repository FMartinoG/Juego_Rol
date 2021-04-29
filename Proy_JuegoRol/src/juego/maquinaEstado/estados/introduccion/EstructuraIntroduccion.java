package juego.maquinaEstado.estados.introduccion;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import juego.Constantes;
import juego.HUD.Mensaje;
import juego.control.Controles;

/**
 * Clase encargada de crear y controlar los elementos del estado Introducci�n.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraIntroduccion {

	private boolean finalizado;
	private String[] textos;

	/**
	 * Contructor de la estructura.
	 */
	public EstructuraIntroduccion() {
		finalizado = false;
		inicializarTextos();
	}

	/**
	 * M�todo encargado de crear y guardar los mensajes que se van a mostrar.
	 */
	private void inicializarTextos() {
		textos = new String[9];
		textos[0] = "HACE MUCHO TIEMPO, EN UNA TIERRA AHORA DESCONOCIDA,";
		textos[1] = "EN LA QUE REINABA LA PAZ Y LA TRANQUILIDAD,";
		textos[2] = "EXIST�AN 5 H�ROES QUE VELABAN POR LA SEGURIDAD DEL REINO.";

		textos[3] = "HASTA QUE UN D�A, 4 DE ELLOS DESAPARECIERON.";
		textos[4] = "EL H�ROE QUE QUEDABA APROVECH� LA DEBILIDAD DEL REY PARA GANAR PODER.";
		textos[5] = "TODO ESTO PROVOC� UNA GRAN INESTABILIDAD EN TODO EL REINO.";

		textos[6] = "5 A�OS DESPU�S...";

		textos[7] = "NOS ENCONTRAMOS EN UN PEQUE�O PUEBLO";
		textos[8] = "DONDE VIVE UN JOVEN CON SU ABUELO.";
	}

	/**
	 * M�todo encargado de actualizar los elementos del estado.
	 */
	public void actualizar() {
		if (Controles.TECLADO.seleccion)
			finalizado = true;
	}

	/**
	 * M�todo encargado de dibujar los elementos del estado.
	 * 
	 * @param g Graphics
	 */
	public void dibujar(Graphics g) {
		ponerPantallaNegro(g);

		mostrarHistoria(g);

		esperar(3000);

		finalizado = true;
	}

	/**
	 * M�todo encargado de mostrar y borrar los mensajes en el orden correcto.
	 * 
	 * @param g
	 */
	private void mostrarHistoria(Graphics g) {
		mostrarMensajes(g, 0, 3);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 3, 3);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 6, 1);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 7, 2);
		esperar(2000);
		ponerPantallaNegro(g);

	}

	/**
	 * M�todo encargado de dibujar los mensajes en pantalla,
	 * 
	 * @param g
	 * @param posInicial
	 * @param longitud
	 */
	private void mostrarMensajes(Graphics g, int posInicial, int longitud) {
		FontMetrics fm = g.getFontMetrics();
		int altura = (Constantes.ALTO_VENTANA / 2) - 100;
		for (int i = 0; i < longitud; ++i) {
			int puntero = posInicial + i;
			int posicionX = (Constantes.ANCHO_VENTANA / 2) - ((fm.stringWidth(textos[puntero]) / 2)) - 15;
			Mensaje ms = new Mensaje(textos[puntero], posicionX, altura, false);
			ms.dibujar(g);
			altura += 40;
		}
	}

	/**
	 * M�todo que pone la pantalla en negro.
	 * 
	 * @param g
	 */
	private void ponerPantallaNegro(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}

	/**
	 * M�todo que hace que la ejecuci�n del hilo espere el tiempo indicado.
	 * 
	 * @param time
	 */
	private void esperar(long time) {
		long tiempoInicial = System.currentTimeMillis();
		long tiempoActual = tiempoInicial;
		while ((tiempoActual - tiempoInicial) < time)
			tiempoActual = System.currentTimeMillis();
	}

	/**
	 * M�todo que indica si ha terminado de mostrar la introducci�n.
	 * 
	 * @return finalizado boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
