package juego.herramientas;

import juego.Constantes;
import juego.entes.Jugador;

public class ComprobadorDeMapa {
	
	public static String comprobarSiguienteMapa(String siguienteMapa) {
		String nuevoMapa = "";
		switch (siguienteMapa) {
		case "m1":
			nuevoMapa = Constantes.MAPA_1;
			break;
		case "m2":
			nuevoMapa = Constantes.MAPA_2;
			break;
		case "m3":
			nuevoMapa = Constantes.MAPA_3;
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
		default:
			break;
		}
		return nuevoMapa;
	}
	
	public static void guardarMapa(Jugador jugador, String mapa) {
		switch (mapa) {
		case Constantes.MAPA_1:
			jugador.getEstadisticas().cambiarMapa(1);
			break;
		case Constantes.MAPA_2:
			jugador.getEstadisticas().cambiarMapa(2);
			break;
		case Constantes.MAPA_3:
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
		default:
			break;
		}
	}
}
