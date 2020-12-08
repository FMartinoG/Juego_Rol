package principal.HUD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import principal.Constantes;
import principal.entes.Jugador;

/**
 * Clase encargada de dibujar la interfaz de usuario que se encuentra en la
 * parte inferior del estado de juego.
 * 
 * @author Fernando Martino
 *
 */
public class InterfazUsuario {

	private int verticalBarra = 4;
	private int HorizontalBarra = 100;

	private Jugador jugador;
	private Rectangle areaDetalles;
	private Rectangle bordeAreaDetalles;
	private Color colorBlanco = Color.white;
	private Color colorRojo = Color.red;
	private Color colorRojoOscuro = new Color(150, 0, 0);
	private Color colorAzul = Color.blue;
	private Color colorAzulOscuro = new Color(0, 0, 150);
	private Color colorMorado = new Color(127, 49, 255);
	private Color colorMoradoOscuro = new Color(99, 29, 214);

	public InterfazUsuario(final Jugador jugador) {
		this.jugador = jugador;
		int alto = 64;
		areaDetalles = new Rectangle(0, Constantes.ALTO_VENTANA - alto, Constantes.ANCHO_VENTANA, alto);
		bordeAreaDetalles = new Rectangle(areaDetalles.x, areaDetalles.y - 1, areaDetalles.width, 1);
	}

	public void dibujar(Graphics g) {
		dibujarArea(g);
	}

	private void dibujarArea(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(areaDetalles.x, areaDetalles.y, areaDetalles.width, areaDetalles.height);
		g.setColor(Color.WHITE);
		g.fillRect(bordeAreaDetalles.x, bordeAreaDetalles.y, bordeAreaDetalles.width, bordeAreaDetalles.height);

		g.setColor(colorBlanco);
		g.drawString("NIVEL: " + jugador.getNivel(), 10, areaDetalles.y + 13);

		dibujarBarraVida(g);
		dibujarBarraMana(g);
		dibujarBarraExp(g);
	}

	private void dibujarBarraVida(Graphics g) {
		double salud = ((double) jugador.getSalud() / (double) jugador.getSaludMaxima()) * 100;

		g.setColor(colorBlanco);
		g.drawString("PS", 10, areaDetalles.y + 38);
		g.setColor(Color.black);
		g.fillRect(35, areaDetalles.y + 28, HorizontalBarra, verticalBarra * 3);
		g.setColor(colorRojo);
		g.fillRect(35, areaDetalles.y + 28, (int) salud, verticalBarra);
		g.setColor(colorRojoOscuro);
		g.fillRect(35, areaDetalles.y + 32, (int) salud, verticalBarra * 2);
		g.setColor(colorBlanco);
		g.drawString("" + jugador.getSalud(), HorizontalBarra + 45, areaDetalles.y + 38);
	}

	private void dibujarBarraMana(Graphics g) {
		double mana = ((double) jugador.getMana() / (double) jugador.getManaMaximo()) * 100;

		g.setColor(colorBlanco);
		g.drawString("PM", 210, areaDetalles.y + 38);
		g.setColor(Color.black);
		g.fillRect(235, areaDetalles.y + 28, HorizontalBarra, verticalBarra * 3);
		g.setColor(colorAzul);
		g.fillRect(235, areaDetalles.y + 28, (int) mana, verticalBarra);
		g.setColor(colorAzulOscuro);
		g.fillRect(235, areaDetalles.y + 32, (int) mana, verticalBarra * 2);
		g.setColor(colorBlanco);
		g.drawString("" + jugador.getMana(), HorizontalBarra + 245, areaDetalles.y + 38);
	}

	private void dibujarBarraExp(Graphics g) {
		double exp = ((double) jugador.getExp() / (double) jugador.getExpMaxima()) * 100;

		g.setColor(colorBlanco);
		g.drawString("EXP", 410, areaDetalles.y + 38);
		g.setColor(Color.black);
		g.fillRect(435, areaDetalles.y + 28, HorizontalBarra, verticalBarra * 3);
		g.setColor(colorMorado);
		g.fillRect(435, areaDetalles.y + 28, (int) exp, verticalBarra);
		g.setColor(colorMoradoOscuro);
		g.fillRect(435, areaDetalles.y + 32, (int) exp, verticalBarra * 2);
		g.setColor(colorBlanco);
		g.drawString("" + jugador.getExp() + " / " + jugador.getExpMaxima(), HorizontalBarra + 445,
				areaDetalles.y + 38);
	}
}
