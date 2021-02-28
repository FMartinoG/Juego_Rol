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

	public GestorPaginaInformacion() {
		ep = new EstructuraPaginaInformacion();
		pulsadoVolver = false;
	}

	@Override
	public void actualizar() {
		ep.actualizar();
		pulsadoVolver = ep.isPulsadoVolver();
	}

	@Override
	public void dibujar(Graphics g) {
		ep.dibujar(g);
	}

	public boolean isPulsadoVolver() {
		return pulsadoVolver;
	}

}
