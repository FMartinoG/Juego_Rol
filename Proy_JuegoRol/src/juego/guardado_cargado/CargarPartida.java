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
	 * Método que lee el fichero serializable y devuelve el objeto estadísticas
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
	 * Método encargado de seleccionar y devolver el mapa que se mostrará al
	 * cargar la partida.
	 * 
	 * @param mapa
	 * @return mapaCarga String.
	 */
	public static String mapaACargar(int mapa) {
		String textoMapa = "";
		System.out.println(mapa);
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
