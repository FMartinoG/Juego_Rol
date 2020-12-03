package principal.maquinaEstado;

import java.awt.Graphics;

import principal.maquinaEstado.estados.juego.GestorJuego;

public class GestorEstados {

	private EstadoJuego[] estados;
	private EstadoJuego estadoActual;
	
	public GestorEstados() {
		iniciarEstados();
		iniciarEstadoActual();
	}

	private void iniciarEstados() {
		estados = new EstadoJuego[1];
		estados[0] = new GestorJuego();
	}
	
	private void iniciarEstadoActual() {
		estadoActual = estados[0];
	}
	
	public void actualizar() {
		estadoActual.actualizar();
	}
	
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}
	
	private void cambiarEstado(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}
	
	public EstadoJuego getEstadoActual() {
		return estadoActual;
	}
}
