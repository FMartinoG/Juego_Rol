package juego.maquinaEstado.estados.menuPrincipal;

import java.awt.Graphics;

import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el men� del juego.
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
	 * M�todo encargado de actualizar el men� principal en cada actualizaci�n
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
	 * M�todo que dibuja el men� principal.
	 */
	@Override
	public void dibujar(Graphics g) {
		emp.dibujar(g);
	}

	/**
	 * M�todo que indica si se ha seleccionado la opci�n de nueva partida.
	 * 
	 * @return nuevaPartidaSeleccionada boolean
	 */
	public boolean nuevaPartida() {
		return nuevaPartidaSeleccionada;
	}

	/**
	 * M�todo que indica si se ha seleccionado la opci�n de cargar partida.
	 * 
	 * @return cargarPartidaSeleccionada boolean
	 */
	public boolean cargarPartida() {
		return cargarPartidaSeleccionada;
	}

	/**
	 * M�todo que indica si se ha seleccionado la opci�n de entrar en la
	 * pantalla de informaci�n.
	 * 
	 * @return informacionSeleccionado boolean
	 */
	public boolean seleccionarInformacion() {
		return informacionSeleccionado;
	}
}
