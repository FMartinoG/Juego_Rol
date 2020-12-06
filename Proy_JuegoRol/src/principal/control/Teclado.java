package principal.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {
	
	public Tecla arriba = new Tecla();
	public Tecla abajo = new Tecla();
	public Tecla derecha = new Tecla();
	public Tecla izquierda = new Tecla();
	
	public boolean corriendo = false;

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba.pulsarTecla();
			break;
		case KeyEvent.VK_S:
			abajo.pulsarTecla();
			break;
		case KeyEvent.VK_A:
			izquierda.pulsarTecla();
			break;
		case KeyEvent.VK_D:
			derecha.pulsarTecla();
			break;
		case KeyEvent.VK_SHIFT:
			corriendo = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba.soltarTecla();
			break;
		case KeyEvent.VK_S:
			abajo.soltarTecla();
			break;
		case KeyEvent.VK_A:
			izquierda.soltarTecla();
			break;
		case KeyEvent.VK_D:
			derecha.soltarTecla();
			break;
		case KeyEvent.VK_SHIFT:
			corriendo = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	
}
