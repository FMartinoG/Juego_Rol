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
			nuevoMapa = Constantes.CASA_GOBERNADOR_1;
			break;
		case "m4":
			nuevoMapa = Constantes.CASA_GOBERNADOR_2;
			break;
		case "m5":
			nuevoMapa = Constantes.CASA_GOBERNADOR_3;
			break;
		case "m6":
			nuevoMapa = Constantes.CASA_GOBERNADOR_4;
			break;
		case "m7":
			nuevoMapa = Constantes.MAPA_PUEBLO_3;
			break;
		case "m8":
			nuevoMapa = Constantes.MAPA_SALIDA_PUEBLO;
			break;
		case "m9":
			nuevoMapa = Constantes.MAPA_SALIDA_PUEBLO_2;
			break;
		case "m10":
			nuevoMapa = Constantes.MAPA_MUNDO;
			break;
		case "m11":
			nuevoMapa = Constantes.MAPA_ENTRADA_CAPITAL;
			break;
		case "m12":
			nuevoMapa = Constantes.MAPA_ENTRADA_CAPITAL_2;
			break;
		case "m13":
			nuevoMapa = Constantes.MAPA_CAPITAL;
			break;
		case "m14":
			nuevoMapa = Constantes.MAPA_CAPITAL_2;
			break;
		case "m15":
			nuevoMapa = Constantes.MAPA_CASTILLO_1_1;
			break;
		case "m16":
			nuevoMapa = Constantes.MAPA_CASTILLO_1_2;
			break;
		case "m17":
			nuevoMapa = Constantes.MAPA_CASTILLO_1_3;
			break;
		case "m18":
			nuevoMapa = Constantes.MAPA_SALA_TRONO_1;
			break;
		case "m19":
			nuevoMapa = Constantes.MAPA_SALA_TRONO_2;
			break;
		case "m20":
			nuevoMapa = Constantes.MAPA_MUNDO_2;
			break;
		case "m21":
			nuevoMapa = Constantes.MAPA_CAMINO_MANSION;
			break;
		case "m22":
			nuevoMapa = Constantes.MAPA_ENTRADA_MANSION;
			break;
		case "m23":
			nuevoMapa = Constantes.MAPA_MANSION_1;
			break;
		case "m24":
			nuevoMapa = Constantes.MAPA_MANSION_2;
			break;
		case "m25":
			nuevoMapa = Constantes.MAPA_MANSION_3;
			break;
		case "m26":
			nuevoMapa = Constantes.MAPA_MANSION_4;
			break;
		case "m27":
			nuevoMapa = Constantes.MAPA_MANSION_5;
			break;

		case "fin":
			nuevoMapa = Constantes.MAPA_FIN_JUEGO;
			Constantes.isFinJuego = true;
			break;	

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
	 * @param mapa    String - Ruta del mapa.
	 */
	public static void guardarMapa(Jugador jugador, String mapa) {
		switch (mapa) {
		// PUEBLO
		case Constantes.MAPA_PUEBLO_1:
			jugador.getEstadisticas().cambiarMapa(1);
			break;
		case Constantes.MAPA_PUEBLO_2:
			jugador.getEstadisticas().cambiarMapa(2);
			break;
		case Constantes.MAPA_PUEBLO_3:
			jugador.getEstadisticas().cambiarMapa(7);
			break;

		// CASA GOBERNADOR
		case Constantes.CASA_GOBERNADOR_1:
			jugador.getEstadisticas().cambiarMapa(3);
			break;
		case Constantes.CASA_GOBERNADOR_2:
			jugador.getEstadisticas().cambiarMapa(4);
			break;
		case Constantes.CASA_GOBERNADOR_3:
			jugador.getEstadisticas().cambiarMapa(5);
			break;
		case Constantes.CASA_GOBERNADOR_4:
			jugador.getEstadisticas().cambiarMapa(6);
			break;

		case Constantes.MAPA_SALIDA_PUEBLO:
			jugador.getEstadisticas().cambiarMapa(8);
			break;
		case Constantes.MAPA_SALIDA_PUEBLO_2:
			jugador.getEstadisticas().cambiarMapa(9);
			break;
		case Constantes.MAPA_MUNDO:
			jugador.getEstadisticas().cambiarMapa(10);
			break;
			
		// CAPITAL
		case Constantes.MAPA_ENTRADA_CAPITAL:
			jugador.getEstadisticas().cambiarMapa(11);
			break;
		case Constantes.MAPA_ENTRADA_CAPITAL_2:
			jugador.getEstadisticas().cambiarMapa(12);
			break;	
		case Constantes.MAPA_CAPITAL:
			jugador.getEstadisticas().cambiarMapa(13);
			break;
		case Constantes.MAPA_CAPITAL_2:
			jugador.getEstadisticas().cambiarMapa(14);
			break;
			
		// CASTILLO
		case Constantes.MAPA_CASTILLO_1_1:
			jugador.getEstadisticas().cambiarMapa(15);
			break;
		case Constantes.MAPA_CASTILLO_1_2:
			jugador.getEstadisticas().cambiarMapa(16);
			break;
		case Constantes.MAPA_CASTILLO_1_3:
			jugador.getEstadisticas().cambiarMapa(17);
			break;
		case Constantes.MAPA_SALA_TRONO_1:
			jugador.getEstadisticas().cambiarMapa(18);
			break;
		case Constantes.MAPA_SALA_TRONO_2:
			jugador.getEstadisticas().cambiarMapa(19);
			break;	

		// MUNDO Y MANSION
		case Constantes.MAPA_MUNDO_2:
			jugador.getEstadisticas().cambiarMapa(20);
			break;
		case Constantes.MAPA_CAMINO_MANSION:
			jugador.getEstadisticas().cambiarMapa(21);
			break;
		case Constantes.MAPA_ENTRADA_MANSION:
			jugador.getEstadisticas().cambiarMapa(22);
			break;
		case Constantes.MAPA_MANSION_1:
			jugador.getEstadisticas().cambiarMapa(23);
			break;
		case Constantes.MAPA_MANSION_2:
			jugador.getEstadisticas().cambiarMapa(24);
			break;
		case Constantes.MAPA_MANSION_3:
			jugador.getEstadisticas().cambiarMapa(25);
			break;
		case Constantes.MAPA_MANSION_4:
			jugador.getEstadisticas().cambiarMapa(26);
			break;
		case Constantes.MAPA_MANSION_5:
			jugador.getEstadisticas().cambiarMapa(27);
			break;

		// MAPAS DE PRUEBA
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
