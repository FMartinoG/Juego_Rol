package juego.maquinaEstado.estados.introduccion;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import juego.Constantes;
import juego.HUD.Mensaje;
import juego.control.Controles;

public class EstructuraIntroduccion {

	private boolean finalizado;
	private String[] textos;

	public EstructuraIntroduccion() {
		finalizado = false;
		inicializarTextos();
	}
	
	private void inicializarTextos() {
		textos = new String[9];
		textos[0] = "HACE MUCHO TIEMPO, EN UNA TIERRA AHORA DESCONOCIDA,";
		textos[1] = "EN LA QUE REINABA LA PAZ Y LA TRANQUILIDAD,";
		textos[2] = "EXISTÍAN 5 HÉROES QUE VELABAN POR LA SEGURIDAD DEL REINO.";
		
		textos[3] = "HASTA QUE UN DÍA, 4 DE ELLOS DESAPARECIERON.";
		textos[4] = "EL HÉROE QUE QUEDABA APROVECHÓ LA DEBILIDAD DEL REY PARA GANAR PODER.";
		textos[5] = "TODO ESTO PROVOCÓ UNA GRAN INESTABILIDAD EN TODO EL REINO.";
		
		textos[6] = "5 AÑOS DESPUÉS...";
		
		textos[7] = "NOS ENCONTRAMOS EN UN PEQUEÑO PUEBLO";
		textos[8] = "DONDE VIVE UN JOVEN CON SU ABUELO.";
	}

	public void actualizar() {
		if (Controles.TECLADO.seleccion)
			finalizado = true;
	}

	public void dibujar(Graphics g) {
		ponerPantallaNegro(g);
		
		mostrarHistoria(g);
		
		esperar(3000);
		
		finalizado = true;
	}
	
	private void mostrarHistoria(Graphics g) {
		mostrarMensajes(g, 0, 3);
		
		esperar(2000);
		ponerPantallaNegro(g);
		
		mostrarMensajes(g, 3, 3);
		
		esperar(2000);
		ponerPantallaNegro(g);
		
		mostrarMensajes(g, 6, 1);
		
		esperar(2000);
		ponerPantallaNegro(g);
		
		mostrarMensajes(g, 7, 2);
		esperar(2000);
		ponerPantallaNegro(g);
		
	}
	
	private void mostrarMensajes(Graphics g, int posInicial, int longitud) {
		FontMetrics fm = g.getFontMetrics();
		int altura = (Constantes.ALTO_VENTANA / 2) - 100;
		for (int i = 0; i < longitud; ++i) {
			int puntero = posInicial + i;
			int posicionX = (Constantes.ANCHO_VENTANA / 2) - ((fm.stringWidth(textos[puntero]) / 2)) - 15;
			Mensaje ms = new Mensaje(textos[puntero], posicionX, altura, false);
			ms.dibujar(g);
			altura += 40;
		}
	}
	
	private void ponerPantallaNegro(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}
	
	private void esperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

}
