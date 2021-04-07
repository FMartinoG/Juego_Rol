package juego.maquinaEstado.estados.informacion;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase que crea la página de información
 * 
 * @author Fernando Martino
 *
 */
public class GestorPaginaInformacion implements EstadoJuego {

	private EstructuraPaginaInformacion ep;
	private boolean pulsadoVolver;

	/**
	 * Contructor de la clase del estado de información.
	 */
	public GestorPaginaInformacion() {
		ep = new EstructuraPaginaInformacion();
		pulsadoVolver = false;
	}

	/**
	 * Método encargado de actualizar el estado.
	 */
	@Override
	public void actualizar() {
		ep.actualizar();
		pulsadoVolver = ep.isPulsadoVolver();
	}

	/**
	 * Método encargado de dibujar el estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		ep.dibujar(g);
	}

	/**
	 * Método que indica si se ha pulsado el botón para volver al menú
	 * principal.
	 * 
	 * @return pulsadoVolver boolean
	 */
	public boolean isPulsadoVolver() {
		return pulsadoVolver;
	}

}
