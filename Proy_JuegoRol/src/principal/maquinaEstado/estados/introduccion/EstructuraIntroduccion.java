package principal.maquinaEstado.estados.introduccion;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import principal.Constantes;
import principal.HUD.Mensaje;

public class EstructuraIntroduccion {

	private boolean finalizado;
	private String[] textos;

	public EstructuraIntroduccion() {
		finalizado = false;
		inicializarTextos();
	}
	
	private void inicializarTextos() {
		textos = new String[10];
		textos[0] = "HACE MUCHO TIEMPO, EN UNA TIERRA AHORA DESCONOCIDA,";
		textos[1] = "EN LA QUE REINABA LA PAZ Y LA TRANQUILIDAD,";
		textos[2] = "EXISTÍAN 5 FAMOSOS GUERREROS QUE VELABAN POR LA SEGURIDAD DEL REINO.";
		textos[3] = "HASTA QUE UN DÍA, UNO DE ELLOS TRAICIONÓ A LOS DEMÁS.";
		textos[4] = "A DOS DE ELLOS LOS MATÓ MIENTRAS DORMÍAN.";
		textos[5] = "CONTRATÓ A UN ASESINO PARA QUE MATARA A OTRO.";
		textos[6] = "Y CONSPIRÓ PARA QUE EL OTRO FUERA EXILIADO.";
		textos[7] = "QUEDANDO ÉL SOLO EN EL REINO, FUE CAPAZ DE HACERSE CON TODO EL PODER.";
		textos[8] = "NADIE FUE CAPAZ DE HACERLE FRENTE.";
		textos[9] = "Y EL ANTERIORMENTE PACÍFICO REINO, AHORA SE CONVIRTIÓ EN UNA TERRIBLE DICTADURA.";
	}

	public void actualizar() {
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
		
		mostrarMensajes(g, 3, 4);
		
		esperar(2000);
		ponerPantallaNegro(g);
		
		mostrarMensajes(g, 7, 3);
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
