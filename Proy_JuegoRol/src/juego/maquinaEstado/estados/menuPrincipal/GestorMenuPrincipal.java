package juego.maquinaEstado.estados.menuPrincipal;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el menú del juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenuPrincipal implements EstadoJuego {
	
	private EstructuraMenuPrincipal emp;
	
	private boolean nuevaPartidaSeleccionada = false;
	private boolean cargarPartidaSeleccionada = false;
	private boolean informacionSeleccionado = false;
	
	public GestorMenuPrincipal() {
		emp = new EstructuraMenuPrincipal();
	}

	@Override
	public void actualizar() {
		emp.actualizar();
		nuevaPartidaSeleccionada = emp.isNuevaPartidaSeleccionada();
		cargarPartidaSeleccionada = emp.isCargarPartidaSeleccionada();
		informacionSeleccionado = emp.isVentanaInformacion();
	}

	@Override
	public void dibujar(Graphics g) {
		emp.dibujar(g);
	}
	
	public boolean nuevaPartida() {
		return nuevaPartidaSeleccionada;
	}
	
	public boolean cargarPartida() {
		return cargarPartidaSeleccionada;
	}
	
	public boolean seleccionarInformacion() {
		return informacionSeleccionado;
	}
	
	public void setCargarPartidaSeleccionada(boolean cargarPartidaSeleccionada) {
		this.cargarPartidaSeleccionada = cargarPartidaSeleccionada;
	}

}
