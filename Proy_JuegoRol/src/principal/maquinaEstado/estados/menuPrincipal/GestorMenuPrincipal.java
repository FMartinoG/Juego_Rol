package principal.maquinaEstado.estados.menuPrincipal;

import java.awt.Color;
import java.awt.Graphics;

import principal.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el menú del juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorMenuPrincipal implements EstadoJuego {

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.drawString("MENU PRINCIPAL", 140, 140);

	}

}
