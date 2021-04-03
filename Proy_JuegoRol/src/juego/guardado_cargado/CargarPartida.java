package juego.guardado_cargado;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import juego.Constantes;
import juego.entes.Estadisticas;

public class CargarPartida {

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
			textoMapa = Constantes.MAPA_CARGA_MUNDO;
			break;
		case 9:
			textoMapa = Constantes.MAPA_CARGA_PUEBLO;
			break;
		default:
			break;
		}
		return textoMapa;
	}
}
