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

	/**
	 * Constructor de la clase GestorMenuPrincipal
	 */
	public GestorMenuPrincipal() {
		emp = new EstructuraMenuPrincipal();
	}

	/**
	 * Método encargado de actualizar el menú principal en cada actualización
	 * del juego.
	 */
	@Override
	public void actualizar() {
		emp.actualizar();
		nuevaPartidaSeleccionada = emp.isNuevaPartidaSeleccionada();
		cargarPartidaSeleccionada = emp.isCargarPartidaSeleccionada();
		informacionSeleccionado = emp.isVentanaInformacion();
	}

	/**
	 * Método que dibuja el menú principal.
	 */
	@Override
	public void dibujar(Graphics g) {
		emp.dibujar(g);
	}

	/**
	 * Método que indica si se ha seleccionado la opción de nueva partida.
	 * 
	 * @return nuevaPartidaSeleccionada boolean
	 */
	public boolean nuevaPartida() {
		return nuevaPartidaSeleccionada;
	}

	/**
	 * Método que indica si se ha seleccionado la opción de cargar partida.
	 * 
	 * @return cargarPartidaSeleccionada boolean
	 */
	public boolean cargarPartida() {
		return cargarPartidaSeleccionada;
	}

	/**
	 * Método que indica si se ha seleccionado la opción de entrar en la
	 * pantalla de información.
	 * 
	 * @return informacionSeleccionado boolean
	 */
	public boolean seleccionarInformacion() {
		return informacionSeleccionado;
	}
}
