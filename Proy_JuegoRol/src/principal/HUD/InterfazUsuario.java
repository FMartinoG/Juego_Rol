package principal.HUD;

import java.awt.Color;
import java.awt.Graphics;

public class InterfazUsuario {

	public static void dibujarResistencia(Graphics g, double d) {
		double ancho = 100 * d / 600;
		Color rojoOscuro = new Color(153, 0, 0);
		
		g.setColor(Color.WHITE);
		g.drawRect(19, 99, 101, 17);
		
		g.setColor(Color.RED);
		g.fillRect(20, 100, (int) ancho, 5);
		
		g.setColor(rojoOscuro);
		g.fillRect(20, 105, (int) ancho, 10);
	}
}
