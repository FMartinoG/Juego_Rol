package juego.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Clase encargada de identificar los eventos de teclado.
 * 
 * @author Fernando Martino
 *
 */
public final class Teclado implements KeyListener {

	public Tecla arriba = new Tecla();
	public Tecla abajo = new Tecla();
	public Tecla derecha = new Tecla();
	public Tecla izquierda = new Tecla();
	
	public boolean arribaMenu = false;
	public boolean abajoMenu = false;
	public boolean izdaMenu = false;
	public boolean drchaMenu = false;
	public boolean seleccion = false;

	public boolean FPSMostrado = false;
	public boolean corriendo = false;
	public boolean menuAbierto = false;
	public boolean bt_Escape = false;
	public boolean combate = false;

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
		case KeyEvent.VK_I:
			menuAbierto = !menuAbierto;
			break;
		case KeyEvent.VK_F1:
			FPSMostrado = !FPSMostrado;
			break;
		case KeyEvent.VK_UP:
			arribaMenu = true;
			break;
		case KeyEvent.VK_DOWN:
			abajoMenu = true;
			break;
		case KeyEvent.VK_LEFT:
			izdaMenu = true;
			break;
		case KeyEvent.VK_RIGHT:
			drchaMenu = true;
			break;
		case KeyEvent.VK_ENTER:
			seleccion = true;
			break;
		case KeyEvent.VK_P:
			combate = true;
			break;
		case KeyEvent.VK_ESCAPE:
			bt_Escape = true;
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
		case KeyEvent.VK_UP:
			arribaMenu = false;
			break;
		case KeyEvent.VK_DOWN:
			abajoMenu = false;
			break;
		case KeyEvent.VK_LEFT:
			izdaMenu = false;
			break;
		case KeyEvent.VK_RIGHT:
			drchaMenu = false;
			break;
		case KeyEvent.VK_ENTER:
			seleccion = false;
			break;
		case KeyEvent.VK_P:
			combate = false;
			break;
		case KeyEvent.VK_ESCAPE:
			bt_Escape = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
