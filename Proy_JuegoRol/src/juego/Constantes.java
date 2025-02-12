package juego;

import java.util.ArrayList;

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

	// TEXTURAS
	public static final String HOJA_TEXTURAS_1 = "/texturas/001.png";
	public static final String TEXTURAS_BOSQUE_1 = "/texturas/bosque01.png";
	public static final String TEXTURAS_ENTRADA_CUEVA = "/texturas/entrada_cueva.png";
	public static final String TEXTURAS_ENTRADA_CAPITAL = "/texturas/entrada_cueva_02.png";
	public static final String TEXTURAS_ENTRADA_CAPITAL_2 = "/texturas/entrada_cueva_02_1.png";
	public static final String TEXTURAS_ENTRADA_MANSION = "/texturas/entrada_mansion.png";
	public static final String TEXTURAS_MUNDO = "/texturas/reveland.png";
	public static final String TEXTURAS_PUEBLO = "/texturas/Villa.png";
	public static final String TEXTURAS_PUEBLO_2 = "/texturas/Villa01.png";
	public static final String TEXTURAS_CASA_GOBERNADOR_PLANTA_BAJA = "/texturas/mansion_p_01.png";
	public static final String TEXTURAS_CASA_GOBERNADOR_HABITACION = "/texturas/mansion_h_01.png";
	public static final String TEXTURAS_CASA_GOBERNADOR_HABITACION_2 = "/texturas/mansion_h_02.png";
	public static final String TEXTURAS_CIUDAD_1 = "/texturas/ciudad1.png";
	public static final String TEXTURAS_CIUDAD_2 = "/texturas/ciudad2.png";
	public static final String TEXTURAS_CASTILLO_1_1 = "/texturas/castillo1_1.png";
	public static final String TEXTURAS_CASTILLO_1_2 = "/texturas/castillo1_2.png";
	public static final String TEXTURAS_CASTILLO_1_3 = "/texturas/castillo1_3.png";
	public static final String TEXTURAS_SALA_TRONO_1 = "/texturas/sala_trono_1.png";
	public static final String TEXTURAS_SALA_TRONO_2 = "/texturas/sala_trono_2.png";
	public static final String TEXTURAS_MANSION_1 = "/texturas/mansion_1.png";
	public static final String TEXTURAS_MANSION_2 = "/texturas/mansion_2.png";
	public static final String TEXTURAS_MANSION_3 = "/texturas/mansion_3.png";
	public static final String TEXTURAS_MANSION_4 = "/texturas/mansion_4.png";
	public static final String TEXTURAS_MANSION_5 = "/texturas/mansion_5.png";
	
	// IMAGENES
	public static final String HOJA_PERSONAJE_1 = "/personaje/001.png";
	public static final String PERSONAJE = "/personaje/psCombate.png";
	
	public static final String ATAQUE = "/imagenes/explosion.png";
	public static final String CURA = "/imagenes/cruz.png";
	public static final String FUEGO = "/imagenes/fuego.png";
	public static final String HIELO = "/imagenes/Hielo.png";
	public static final String RAYO = "/imagenes/rayo.png";
	
	// IMAGENES ENEMIGOS
	public static final String BOTMAN = "/enemigos/botman.png";
	public static final String RECAUDADOR = "/enemigos/recaudador.png";
	public static final String MISTERIOSO = "/enemigos/misterioso.png";
	public static final String MANIQUI = "/enemigos/maniqui.png";
	public static final String GUARDIA_ENTRADA_CIUDAD = "/enemigos/guardiaPuerta.png";
	public static final String GUARDIA_CASTILLO = "/enemigos/guardia_real.png";
	public static final String GUARDIA_MANSION = "/enemigos/guardia_mansion.png";
	public static final String REY = "/enemigos/rey.png";
	public static final String CONDE = "/enemigos/conde.png";
	
	// MAPAS
	public static final String MAPA_PRUEBA_1 = "/mapas/prueba/mapa001.txt";
	public static final String MAPA_PRUEBA_2 = "/mapas/prueba/mapa002.txt";
	public static final String MAPA_PRUEBA_3 = "/mapas/prueba/mapa003.txt";
	
	
	public static final String MAPA_5 = "/mapas/mapa005.txt";	
	public static final String MAPA_7 = "/mapas/mapa007.txt";
	public static final String MAPA_MUNDO = "/mapas/mapa_mundo_01.txt";
	public static final String MAPA_MUNDO_2 = "/mapas/mapa_mundo_2.txt";
	
	public static final String MAPA_PUEBLO_1 = "/mapas/pueblo/mapa_pueblo_01.txt";
	public static final String MAPA_PUEBLO_2 = "/mapas/pueblo/mapa_pueblo_02.txt";
	public static final String MAPA_PUEBLO_3 = "/mapas/pueblo/mapa_pueblo_03.txt";
	public static final String MAPA_SALIDA_PUEBLO = "/mapas/pueblo/mapa_salida_pueblo.txt";
	public static final String MAPA_SALIDA_PUEBLO_2 = "/mapas/pueblo/mapa_salida_pueblo_02.txt";
	
	public static final String CASA_GOBERNADOR_1 = "/mapas/casa_gobernador/mapa_casa_gob_baja_01.txt";
	public static final String CASA_GOBERNADOR_2 = "/mapas/casa_gobernador/mapa_casa_gob_hab_01.txt";
	public static final String CASA_GOBERNADOR_3 = "/mapas/casa_gobernador/mapa_casa_gob_hab_02.txt";
	public static final String CASA_GOBERNADOR_4 = "/mapas/casa_gobernador/mapa_casa_gob_baja_02.txt";
	
	public static final String MAPA_ENTRADA_CAPITAL = "/mapas/capital/mapa_entrada_capital.txt";
	public static final String MAPA_ENTRADA_CAPITAL_2 = "/mapas/capital/mapa_entrada_capital_2.txt";
	public static final String MAPA_CAPITAL = "/mapas/capital/mapa_ciudad_1.txt";
	public static final String MAPA_CAPITAL_2 = "/mapas/capital/mapa_ciudad_2.txt";
	public static final String MAPA_CASTILLO_1_1 = "/mapas/capital/mapa_castillo_1_1.txt";
	public static final String MAPA_CASTILLO_1_2 = "/mapas/capital/mapa_castillo_1_2.txt";
	public static final String MAPA_CASTILLO_1_3 = "/mapas/capital/mapa_castillo_1_3.txt";
	public static final String MAPA_SALA_TRONO_1 = "/mapas/capital/sala_trono_1.txt";
	public static final String MAPA_SALA_TRONO_2 = "/mapas/capital/sala_trono_2.txt";
	
	public static final String MAPA_CAMINO_MANSION = "/mapas/mansion/camino_mansion.txt";
	public static final String MAPA_ENTRADA_MANSION = "/mapas/mansion/mansion_entrada.txt";
	public static final String MAPA_MANSION_1 = "/mapas/mansion/mansion_1.txt";
	public static final String MAPA_MANSION_2 = "/mapas/mansion/mansion_2.txt";
	public static final String MAPA_MANSION_3 = "/mapas/mansion/mansion_3.txt";
	public static final String MAPA_MANSION_4 = "/mapas/mansion/mansion_4.txt";
	public static final String MAPA_MANSION_5 = "/mapas/mansion/mansion_5.txt";
	
	public static final String MAPA_FIN_JUEGO = "/mapas/fin_juego.txt";
	
	
	// MAPAS DE CARGA
	public static final String MAPA_CARGA_1 = "/mapas/carga/carga1.txt";
	public static final String MAPA_CARGA_2 = "/mapas/carga/carga2.txt";
	public static final String MAPA_CARGA_3 = "/mapas/carga/carga3.txt";
	public static final String MAPA_CARGA_4 = "/mapas/carga/carga4.txt";
	public static final String MAPA_CARGA_5 = "/mapas/carga/carga5.txt";
	public static final String MAPA_CARGA_6 = "/mapas/carga/carga6.txt";
	public static final String MAPA_CARGA_7 = "/mapas/carga/carga7.txt";
	public static final String MAPA_CARGA_8 = "/mapas/carga/carga8.txt";
	public static final String MAPA_CARGA_9 = "/mapas/carga/carga9.txt";
	public static final String MAPA_CARGA_10 = "/mapas/carga/carga10.txt";
	public static final String MAPA_CARGA_11 = "/mapas/carga/carga11.txt";
	public static final String MAPA_CARGA_12 = "/mapas/carga/carga12.txt";
	public static final String MAPA_CARGA_13 = "/mapas/carga/carga13.txt";
	public static final String MAPA_CARGA_14 = "/mapas/carga/carga14.txt";
	public static final String MAPA_CARGA_15 = "/mapas/carga/carga15.txt";
	public static final String MAPA_CARGA_16 = "/mapas/carga/carga16.txt";
	public static final String MAPA_CARGA_17 = "/mapas/carga/carga17.txt";
	public static final String MAPA_CARGA_18 = "/mapas/carga/carga18.txt";
	public static final String MAPA_CARGA_19 = "/mapas/carga/carga19.txt";
	public static final String MAPA_CARGA_20 = "/mapas/carga/carga20.txt";
	public static final String MAPA_CARGA_21 = "/mapas/carga/carga21.txt";
	public static final String MAPA_CARGA_22 = "/mapas/carga/carga22.txt";
	public static final String MAPA_CARGA_23 = "/mapas/carga/carga23.txt";
	public static final String MAPA_CARGA_24 = "/mapas/carga/carga24.txt";
	public static final String MAPA_CARGA_25 = "/mapas/carga/carga25.txt";
	public static final String MAPA_CARGA_26 = "/mapas/carga/carga26.txt";
	public static final String MAPA_CARGA_27 = "/mapas/carga/carga27.txt";
	
	public static final String MAPA_CARGA_PRUEBA_1 = "/mapas/carga/carga_prueba_1.txt";
	public static final String MAPA_CARGA_PRUEBA_2 = "/mapas/carga/carga_prueba_2.txt";
	public static final String MAPA_CARGA_PRUEBA_3 = "/mapas/carga/carga_prueba_3.txt";

	// OTROS
	public static final String ICONO = "/icon/juego.png";
	
	public static final String SONIDO = "/sonidos/sonido.wav";
	public static final String BEEP = "/sonidos/beep.wav";
	public static final String TECLA = "/sonidos/tecla.wav";
	public static final String MUSICA = "/sonidos/IMissYou.wav";
	public static final String MUSICA_COMBATE = "/sonidos/HighStorm.wav";
	public static final String MUSICA_JUEGO = "/sonidos/Honor_is_dead.wav";
	public static final String MUSICA_FIN_JUEGO = "/sonidos/Tarah.wav";
	
	public static ArrayList<String[]> CONVERSACIONES;
	
	public static Enemigo[] ENEMIGOS;

	public static boolean isFinJuego = false;
}
