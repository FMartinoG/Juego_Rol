package juego.herramientas;

import java.awt.Color;
import java.awt.Graphics;

import juego.entes.Estadisticas;
import juego.entes.Jugador;

public class Barras {
	
	private Graphics g;
	private Estadisticas estadisticasJugador;
	private int posX, posY;
	
	public Barras(Graphics g, Jugador j, int posX, int posY) {
		this.g = g;
		estadisticasJugador = j.getEstadisticas();
		this.posX = posX;
		this.posY = posY;
	}
	
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
