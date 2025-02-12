package juego.guardado_cargado;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import juego.Constantes;
import juego.entes.Estadisticas;

/**
 * Clase encargada de controlar la lectura del fichero serializable para cargar
 * la partida.
 * 
 * @author Fernando Martino
 *
 */
public class CargarPartida {

	/**
	 * M�todo que lee el fichero serializable y devuelve el objeto estad�sticas
	 * que saca.
	 * 
	 * @return estadisticasGuardadas Estadisticas.
	 */
	public static Estadisticas cargar() {
		Estadisticas s = null;
		File f = new File("recursos/guardados/save.s");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			s = (Estadisticas) ois.readObject();

			ois.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * M�todo encargado de seleccionar y devolver el mapa que se mostrar� al
	 * cargar la partida.
	 * 
	 * @param mapa int - Numero de referencia al mapa
	 * @return mapaCarga String - Ruta al mapa.
	 */
	public static String mapaACargar(int mapa) {
		String textoMapa = "";
		switch (mapa) {
		case 1:
			textoMapa = Constantes.MAPA_CARGA_1;
			break;
		case 2:
			textoMapa = Constantes.MAPA_CARGA_2;
			break;
		case 3:
			textoMapa = Constantes.MAPA_CARGA_3;
			break;
		case 4:
			textoMapa = Constantes.MAPA_CARGA_4;
			break;
		case 5:
			textoMapa = Constantes.MAPA_CARGA_5;
			break;
		case 6:
			textoMapa = Constantes.MAPA_CARGA_6;
			break;
		case 7:
			textoMapa = Constantes.MAPA_CARGA_7;
			break;
		case 8:
			textoMapa = Constantes.MAPA_CARGA_8;
			break;
		case 9:
			textoMapa = Constantes.MAPA_CARGA_9;
			break;
		case 10:
			textoMapa = Constantes.MAPA_CARGA_10;
			break;
		case 11:
			textoMapa = Constantes.MAPA_CARGA_11;
			break;
		case 12:
			textoMapa = Constantes.MAPA_CARGA_12;
			break;
		case 13:
			textoMapa = Constantes.MAPA_CARGA_13;
			break;
		case 14:
			textoMapa = Constantes.MAPA_CARGA_14;
			break;
		case 15:
			textoMapa = Constantes.MAPA_CARGA_15;
			break;
		case 16:
			textoMapa = Constantes.MAPA_CARGA_16;
			break;
		case 17:
			textoMapa = Constantes.MAPA_CARGA_17;
			break;
		case 18:
			textoMapa = Constantes.MAPA_CARGA_18;
			break;
		case 19:
			textoMapa = Constantes.MAPA_CARGA_19;
			break;
		case 20:
			textoMapa = Constantes.MAPA_CARGA_20;
			break;
		case 21:
			textoMapa = Constantes.MAPA_CARGA_21;
			break;
		case 22:
			textoMapa = Constantes.MAPA_CARGA_22;
			break;
		case 23:
			textoMapa = Constantes.MAPA_CARGA_23;
			break;
		case 24:
			textoMapa = Constantes.MAPA_CARGA_24;
			break;
		case 25:
			textoMapa = Constantes.MAPA_CARGA_25;
			break;
		case 26:
			textoMapa = Constantes.MAPA_CARGA_26;
			break;
		case 27:
			textoMapa = Constantes.MAPA_CARGA_27;
			break;
			

		// LOS DE PRUEBA
		case 1002:
			textoMapa = Constantes.MAPA_PRUEBA_1;
			break;
		case 1000:
			textoMapa = Constantes.MAPA_PRUEBA_2;
			break;
		case 1001:
			textoMapa = Constantes.MAPA_PRUEBA_3;
			break;
		default:
			break;
		}
		return textoMapa;
	}
}
