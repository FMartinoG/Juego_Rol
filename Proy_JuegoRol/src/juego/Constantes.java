package juego;

import juego.entes.Enemigo;

/**
 * Clase que guarda datos importantes para poder reutilizarlos.
 * 
 * @author Fernando Martino
 *
 */
public class Constantes {

	public static final int LADO_SPRITE = 32;

	public static final int ANCHO_VENTANA = 640;
	public static final int ALTO_VENTANA = 360;

	public static int ANCHO_PANTALLA_AMPLIADA = 640 * 2;
	public static int ALTO_PANTALLA_AMPLIADA = 360 * 2;

	public static double factorEscaladoX = ANCHO_PANTALLA_AMPLIADA / ANCHO_VENTANA;
	public static double factorEscaladoY = ALTO_PANTALLA_AMPLIADA / ALTO_VENTANA;

	public static final String HOJA_TEXTURAS_1 = "/texturas/001.png";

	public static final String HOJA_PERSONAJE_1 = "/personaje/001.png";
	public static final String PERSONAJE = "/personaje/psj.png";
	public static final String BATMAN = "/personaje/batman.png";
	public static final String BOTMAN = "/personaje/botman.png";
	

	public static final String MAPA_1 = "/mapas/mapa001.txt";
	public static final String MAPA_2 = "/mapas/mapa002.txt";

	public static final String ICONO = "/icon/juego.png";

	public static final String CURSOR = "/cursor/cursor.png";
	
	public static final String SONIDO = "/sonidos/sonido.wav";
	public static final String BEEP = "/sonidos/beep.wav";
	public static final String TECLA = "/sonidos/tecla.wav";
	public static final String MUSICA = "/sonidos/IMissYou.wav";
	
	public static String[] CONVERSACIONES;
	
	public static Enemigo[] ENEMIGOS;

}
