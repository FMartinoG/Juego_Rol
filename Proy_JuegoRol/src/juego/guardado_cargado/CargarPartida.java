package juego.guardado_cargado;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
}
