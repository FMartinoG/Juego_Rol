package juego.HUD;

import java.awt.Color;
import java.awt.Graphics;

import juego.entes.Enemigo;
import juego.entes.Estadisticas;
import juego.entes.Jugador;

/**
 * Clase encargada de dibujar y controlar las barras de vida, maná y
 * experiencia.
 * 
 * @author Fernando Martino
 *
 */
public class Barras {

	private Graphics g;
	private Estadisticas estadisticasJugador;
	private Enemigo enemigo;
	private int posX, posY;

	/**
	 * Constructor de la clase Barras para el jugador.
	 * 
	 * @param g Graphics
	 * @param j Jugador
	 * @param posX int
	 * @param posY int
	 */
	public Barras(Graphics g, Jugador j, int posX, int posY) {
		this.g = g;
		estadisticasJugador = j.getEstadisticas();
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Constructor de la clase Barras para el enemigo.
	 * @param g Graphics
	 * @param en Enemigo
	 * @param posX int
	 * @param posY int
	 */
	public Barras(Graphics g, Enemigo en, int posX, int posY) {
		this.g = g;
		enemigo = en;
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Método encargado de dibujar la barra de vida del menú del juego.
	 */
	public void dibujarBarraVidaMenu() {
		double salud = ((double) estadisticasJugador.getSalud() / (double) estadisticasJugador.getSaludMaxima()) * 100;

		g.setColor(Color.black);
		g.drawString("PS", posX, posY);
		g.fillRect(posX + 25, posY - 10, 100, 12);
		g.drawString(estadisticasJugador.getSalud() + " / " + estadisticasJugador.getSaludMaxima(), posX + 150, posY);
		g.setColor(Color.red);
		g.fillRect(posX + 25, posY - 10, (int) salud, 4);
		g.setColor(new Color(150, 0, 0));
		g.fillRect(posX + 25, posY - 6, (int) salud, 8);

	}

	/**
	 * Método encargado de dibujar la barra de vida del jugador en el combate.
	 */
	public void dibujarBarraVidaCombate() {
		double salud = ((double) estadisticasJugador.getSalud() / (double) estadisticasJugador.getSaludMaxima()) * 100;

		g.setColor(Color.WHITE);
		g.drawString("PS", posX, posY);
		g.drawRect(posX + 24, posY - 11, 102, 14);
		g.drawString(estadisticasJugador.getSalud() + " / " + estadisticasJugador.getSaludMaxima(), posX + 50, posY + 15);

		g.setColor(Color.black);
		g.fillRect(posX + 25, posY - 10, 100, 12);

		g.setColor(Color.red);
		g.fillRect(posX + 25, posY - 10, (int) salud, 4);
		g.setColor(new Color(150, 0, 0));
		g.fillRect(posX + 25, posY - 6, (int) salud, 8);
	}

	/**
	 * Método encargado de dibujar la barra de vida del enemigo en el combate.
	 */
	public void dibujarBarraVidaEnemigo() {
		double salud = ((double) enemigo.getVidaActual() / (double) enemigo.getVidaMaxima()) * 200;

		g.setColor(Color.black);
		g.fillRect(posX, posY, 200, 12);

		g.setColor(Color.red);
		g.fillRect(posX, posY, (int) salud, 4);
		g.setColor(new Color(150, 0, 0));
		g.fillRect(posX, posY + 4, (int) salud, 8);
	}

	/**
	 * Método encargado de dibujar la barra de maná del menú del juego.
	 */
	public void dibujarBarraManaMenu() {
		double mana = ((double) estadisticasJugador.getMana() / (double) estadisticasJugador.getManaMaximo()) * 100;

		g.setColor(Color.black);
		g.drawString("PM", posX, posY);
		g.fillRect(posX + 25, posY - 10, 100, 12);
		g.drawString(estadisticasJugador.getMana() + " / " + estadisticasJugador.getManaMaximo(), posX + 150, posY);
		g.setColor(Color.blue);
		g.fillRect(posX + 25, posY - 10, (int) mana, 4);
		g.setColor(new Color(0, 0, 150));
		g.fillRect(posX + 25, posY - 6, (int) mana, 8);
	}

	/**
	 * Método encargado de dibujar la barra de maná del jugador en el combate.
	 */
	public void dibujarBarraManaCombate() {
		double mana = ((double) estadisticasJugador.getMana() / (double) estadisticasJugador.getManaMaximo()) * 100;

		g.setColor(Color.WHITE);
		g.drawString("PM", posX, posY);
		g.drawRect(posX + 24, posY - 11, 102, 14);
		g.drawString(estadisticasJugador.getMana() + " / " + estadisticasJugador.getManaMaximo(), posX + 50, posY + 15);

		g.setColor(Color.black);
		g.fillRect(posX + 25, posY - 10, 100, 12);

		g.setColor(Color.blue);
		g.fillRect(posX + 25, posY - 10, (int) mana, 4);
		g.setColor(new Color(0, 0, 150));
		g.fillRect(posX + 25, posY - 6, (int) mana, 8);
	}

	/**
	 * Método encargado de dibujar la barra de experiencia del menú del juego.
	 */
	public void dibujarBarraExpMenu() {
		double exp = ((double) estadisticasJugador.getExp() / (double) estadisticasJugador.getExpMaxima()) * 100;

		g.setColor(Color.black);
		g.drawString("EXP", posX, posY);
		g.fillRect(posX + 25, posY - 10, 100, 12);
		g.drawString("" + estadisticasJugador.getExp() + " / " + estadisticasJugador.getExpMaxima(), posX + 150, posY);
		g.setColor(new Color(127, 49, 255));
		g.fillRect(posX + 25, posY - 10, (int) exp, 4);
		g.setColor(new Color(99, 29, 214));
		g.fillRect(posX + 25, posY - 6, (int) exp, 8);
	}

	/**
	 * Método encargado de dibujar la barra de experiencia del jugador en el combate.
	 */
	public void dibujarBarraExpCombate() {
		double exp = ((double) estadisticasJugador.getExp() / (double) estadisticasJugador.getExpMaxima()) * 100;

		g.setColor(Color.WHITE);
		g.drawString("EXP", posX, posY);
		g.drawRect(posX + 24, posY - 11, 102, 14);
		g.drawString("" + estadisticasJugador.getExp() + " / " + estadisticasJugador.getExpMaxima(), posX + 50, posY + 15);

		g.setColor(Color.BLACK);
		g.fillRect(posX + 25, posY - 10, 100, 12);

		g.setColor(new Color(127, 49, 255));
		g.fillRect(posX + 25, posY - 10, (int) exp, 4);
		g.setColor(new Color(99, 29, 214));
		g.fillRect(posX + 25, posY - 6, (int) exp, 8);

	}

}
