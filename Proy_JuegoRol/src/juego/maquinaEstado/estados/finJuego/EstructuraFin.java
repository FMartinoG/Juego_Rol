package juego.maquinaEstado.estados.finJuego;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import juego.Constantes;
import juego.HUD.Mensaje;
import juego.control.Controles;
import juego.entes.Estadisticas;

/**
 * Clase encargada de crear y controlar los elementos del estado Fin de Juego.
 * 
 * @author Fernando Martino
 *
 */
public class EstructuraFin {

	private boolean finalizado;
	private String[] textos;
	private int resultadoDelJuego;


	/**
	 * Contructor de la estructura.
	 */
	public EstructuraFin(Estadisticas estadisticas) {
		finalizado = false;
		inicializarTextos();
		if (estadisticas.getNivel() > 30) {
			resultadoDelJuego = 3;
		} else if (estadisticas.getNivel() > 20) {
			resultadoDelJuego = 2;
		} else if (estadisticas.getNivel() > 10) {
			resultadoDelJuego = 1;
		} else {
			resultadoDelJuego = 0;
		}
	}

	/**
	 * M�todo encargado de crear y guardar los mensajes que se van a mostrar.
	 */
	private void inicializarTextos() {
		textos = new String[10];
		
		if (resultadoDelJuego == 3) {
			textos[0] = "TRAS LOS ACONTECIMIENTOS SUCEDIDOS";
			textos[1] = "TODO EL REINO CAMBI� PARA SIEMPRE";
			textos[2] = "...";
			
			textos[3] = "TRAS LA MUERTE DEL REY Y DE LOS PRINCIPALES DIRIGENTES";
			textos[4] = "EL REINO ENTERO ENTR� EN P�NICO";
			textos[5] = "HASTA QUE UN GRUPO DE NOBLES Y ERUDITOS DECIDI� TOMAR EL CONTROL";
			textos[6] = "Y FORMARON UNA PROSPERA REP�BLICA.";

			textos[7] = "NUESTRO PROTAGONISTA FUE ENCARCELADO POR LOS ASESINATOS DEL REY Y OTROS NOBLES,";
			textos[8] = "FINALMENTE FUE EJECUTADO.";
		} else if (resultadoDelJuego == 2) {
			textos[0] = "TRAS LOS ACONTECIMIENTOS SUCEDIDOS";
			textos[1] = "TODO EL REINO CAMBI� PARA SIEMPRE";
			textos[2] = "...";
			
			textos[3] = "TRAS LA MUERTE DEL REY Y DE LOS PRINCIPALES DIRIGENTES";
			textos[4] = "EL REINO ENTERO ENTR� EN P�NICO";
			textos[5] = "HASTA QUE UN GRUPO DE NOBLES Y ERUDITOS DECIDI� TOMAR EL CONTROL";
			textos[6] = "Y FORMARON UNA PROSPERA REP�BLICA.";

			textos[7] = "EL SOLDADO MISTERIOSO MAT� AL CONDE, Y FUE ENCARCELADO POR SU MATANZA,";
			textos[8] = "NUESTRO PROTAGONISTAFUE ENCARCELADO POR LOS ASESINATOS DEL REY,";
			textos[9] = "FINALMENTE AMBOS FUERON EJECUTADOS.";
		} else if (resultadoDelJuego == 1) {
			textos[0] = "DESPU�S DE SU AVENTURA, NUESTRO PROTAGONISTA VOLVI� A CASA.";
			textos[1] = "CUANDO EL REY SE ENTER� DE QUE EL PROTAGONISTA MAT� AL CONDE";
			textos[2] = "DECIDI� NOMBRARLO GOBERNADOR DE SU PUEBLO.";
			textos[3] = "(PARECE QUE AL REY NO LE GUSTABA EL CONDE...)";

			textos[4] = "NADIE VOLVI� A VER AL SOLDADO MISTERIOSO,";
			textos[5] = "Y NUESTRO PROTAGONISTA VIVI� TRANQUILAMENTE EL RESTO DE SU VIDA";
		} else {
			textos[0] = "DESPU�S DE SU AVENTURA, NUESTRO PROTAGONISTA VOLVI� A CASA.";
			textos[1] = "AUNQUE CUANDO VOLVI� SEGU�A SIN TENER DINERO,";
			textos[2] = "NADIE SE DIO CUENTA QUE YA NO HAB�A GOBERNADOR,";
			textos[3] = "AS� QUE NO TUVIERON QUE VOLVER A PAGAR IMPUESTOS.";

			textos[4] = "NADIE VOLVI� A VER AL SOLDADO MISTERIOSO,";
			textos[5] = "Y SE ENCONTR� EL CAD�VER DEL CONDE SIN NIGUNA HERIDA,";
			textos[6] = "NUNCA NADIE SUPO COMO MURI�.";
		}
	}

	/**
	 * M�todo encargado de actualizar los elementos del estado.
	 */
	public void actualizar() {
		if (Controles.TECLADO.seleccion)
			finalizado = true;
	}

	/**
	 * M�todo encargado de dibujar los elementos del estado.
	 * 
	 * @param g Graphics
	 */
	public void dibujar(Graphics g) {
		ponerPantallaNegro(g);

		mostrarHistoria(g);

		esperar(3000);

		finalizado = true;
	}

	/**
	 * M�todo encargado de mostrar y borrar los mensajes en el orden correcto.
	 * 
	 * @param g
	 */
	private void mostrarHistoria(Graphics g) {
		if (resultadoDelJuego == 3) {
			mostrarHistoriaFinal1(g);
		} else if (resultadoDelJuego == 2) {
			mostrarHistoriaFinal2(g);
		} else if (resultadoDelJuego == 1) {
			mostrarHistoriaFinal3(g);
		} else {
			mostrarHistoriaFinal4(g);
		}


	}
	
	/**
	 * M�todo encargado de mostrar la historia si matas al rey y al traidor.
	 * 
	 * @param g
	 */
	private void mostrarHistoriaFinal1(Graphics g) {
		mostrarMensajes(g, 0, 3);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 3, 4);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 7, 2);

		esperar(2000);
		ponerPantallaNegro(g);
	}
	
	/**
	 * M�todo encargado de mostrar la historia si matas al rey y no al traidor.
	 * 
	 * @param g
	 */
	private void mostrarHistoriaFinal2(Graphics g) {
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
	
	/**
	 * M�todo encargado de mostrar la historia si matas al traidor y no al rey.
	 * 
	 * @param g
	 */
	private void mostrarHistoriaFinal3(Graphics g) {
		mostrarMensajes(g, 0, 4);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 4, 2);
	}
	
	/**
	 * M�todo encargado de mostrar la historia si no matas al rey ni al traidor.
	 * 
	 * @param g
	 */
	private void mostrarHistoriaFinal4(Graphics g) {
		mostrarMensajes(g, 0, 4);

		esperar(2000);
		ponerPantallaNegro(g);

		mostrarMensajes(g, 4, 3);
	}

	/**
	 * M�todo encargado de dibujar los mensajes en pantalla,
	 * 
	 * @param g
	 * @param posInicial
	 * @param longitud
	 */
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

	/**
	 * M�todo que pone la pantalla en negro.
	 * 
	 * @param g
	 */
	private void ponerPantallaNegro(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);
	}

	/**
	 * M�todo que hace que la ejecuci�n del hilo espere el tiempo indicado.
	 * 
	 * @param time
	 */
	private void esperar(long time) {
		long tiempoInicial = System.currentTimeMillis();
		long tiempoActual = tiempoInicial;
		while ((tiempoActual - tiempoInicial) < time)
			tiempoActual = System.currentTimeMillis();
	}

	/**
	 * M�todo que indica si ha terminado de mostrar la introducci�n.
	 * 
	 * @return finalizado boolean
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

}
