package juego.maquinaEstado.estados.informacion;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase que crea la p�gina de informaci�n
 * 
 * @author Fernando Martino
 *
 */
public class GestorPaginaInformacion implements EstadoJuego {

	private EstructuraPaginaInformacion ep;
	private boolean pulsadoVolver;

	/**
	 * Contructor de la clase del estado de informaci�n.
	 */
	public GestorPaginaInformacion() {
		ep = new EstructuraPaginaInformacion();
		pulsadoVolver = false;
	}

	/**
	 * M�todo encargado de actualizar el estado.
	 */
	@Override
	public void actualizar() {
		ep.actualizar();
		pulsadoVolver = ep.isPulsadoVolver();
	}

	/**
	 * M�todo encargado de dibujar el estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		ep.dibujar(g);
	}

	/**
	 * M�todo que indica si se ha pulsado el bot�n para volver al men�
	 * principal.
	 * 
	 * @return pulsadoVolver boolean
	 */
	public boolean isPulsadoVolver() {
		return pulsadoVolver;
	}

}
