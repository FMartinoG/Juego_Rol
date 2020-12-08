package principal.maquinaEstado.estados.menuJuego;

import java.awt.Color;
import java.awt.Graphics;

import principal.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el menú principal.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenu implements EstadoJuego {

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.drawString("MENU DEL JUEGO", 140, 140);

	}

}
