package principal.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {
	private final int NUMERO_TECLAS = 256;
	private final boolean[] TECLAS = new boolean[NUMERO_TECLAS];
	
	private boolean arriba;
	private boolean abajo;
	private boolean izquierda;
	private boolean derecha;
	
	private boolean salir;
	
	// AQUI PONE CUALES TECLAS SON PARA MOVERSE
	public void actualizar() {
		arriba = TECLAS[KeyEvent.VK_UP];
		abajo = TECLAS[KeyEvent.VK_DOWN];
		izquierda = TECLAS[KeyEvent.VK_LEFT];
		derecha = TECLAS[KeyEvent.VK_RIGHT];
		
		salir = TECLAS[KeyEvent.VK_ESCAPE];
	}
	
	

	public boolean isArriba() {
		return arriba;
	}
	public boolean isAbajo() {
		return abajo;
	}
	public boolean isIzquierda() {
		return izquierda;
	}
	public boolean isDerecha() {
		return derecha;
	}
	public boolean isSalir() {
		return salir;
	}



	@Override
	public void keyPressed(KeyEvent e) {
		TECLAS[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		TECLAS[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
