package juego.herramientas;

import juego.Constantes;
import juego.entes.Jugador;

/**
 * Clase encargada de seleccionar la ruta del mapa a partir de una referencia y
 * de actualizar las referencia al mapa.
 * 
 * @author Fernando Martino
 *
 */
public class ComprobadorDeMapa {

	/**
	 * Método que devuelve la ruta al mapa que se debe leer recibiendo su
	 * referencia.
	 * 
	 * @param siguienteMapa String - Referencia al mapa.
	 * @return rutaMapa String - Ruta al mapa referenciado.
	 */
	public static String comprobarSiguienteMapa(String siguienteMapa) {
		String nuevoMapa = "";
		switch (siguienteMapa) {
		case "m1":
			nuevoMapa = Constantes.MAPA_PUEBLO_1;
			break;
		case "m2":
			nuevoMapa = Constantes.MAPA_PUEBLO_2;
			break;
		case "m3":
			nuevoMapa = Constantes.MAPA_PUEBLO_3;
			break;
		case "m4":
			nuevoMapa = Constantes.MAPA_4;
			break;
		case "m5":
			nuevoMapa = Constantes.MAPA_5;
			break;
		case "m6":
			nuevoMapa = Constantes.MAPA_6;
			break;
		case "m7":
			nuevoMapa = Constantes.MAPA_7;
			break;
		case "m8":
			nuevoMapa = Constantes.MAPA_MUNDO;
			break;
		/*
		 * case "m9": nuevoMapa = Constantes.MAPA_PUEBLO_2; break; case "m10":
		 * nuevoMapa = Constantes.MAPA_PUEBLO_1; break;
		 */
		case "m1002":
			nuevoMapa = Constantes.MAPA_PRUEBA_1;
			break;
		case "m1000":
			nuevoMapa = Constantes.MAPA_PRUEBA_2;
			break;
		case "m1001":
			nuevoMapa = Constantes.MAPA_PRUEBA_3;
			break;
		default:
			break;
		}
		return nuevoMapa;
	}

	/**
	 * Método que actualiza la referencia, que tiene el objeto estadisticas del
	 * jugador, hacia el mapa.
	 * 
	 * @param jugador Jugador - Objeto jugador.
	 * @param mapa String - Ruta del mapa. 
	 */
	public static void guardarMapa(Jugador jugador, String mapa) {
		switch (mapa) {
		case Constantes.MAPA_PUEBLO_1:
			jugador.getEstadisticas().cambiarMapa(1);
			break;
		case Constantes.MAPA_PUEBLO_2:
			jugador.getEstadisticas().cambiarMapa(2);
			break;
		case Constantes.MAPA_PUEBLO_3:
			jugador.getEstadisticas().cambiarMapa(3);
			break;

		case Constantes.MAPA_4:
			jugador.getEstadisticas().cambiarMapa(4);
			break;
		case Constantes.MAPA_5:
			jugador.getEstadisticas().cambiarMapa(5);
			break;
		case Constantes.MAPA_6:
			jugador.getEstadisticas().cambiarMapa(6);
			break;
		case Constantes.MAPA_7:
			jugador.getEstadisticas().cambiarMapa(7);
			break;
		case Constantes.MAPA_MUNDO:
			jugador.getEstadisticas().cambiarMapa(8);
			break;

		case Constantes.MAPA_PRUEBA_1:
			jugador.getEstadisticas().cambiarMapa(1002);
			break;
		case Constantes.MAPA_PRUEBA_2:
			jugador.getEstadisticas().cambiarMapa(1000);
			break;
		case Constantes.MAPA_PRUEBA_3:
			jugador.getEstadisticas().cambiarMapa(1001);
			break;
		default:
			break;
		}
	}
}
