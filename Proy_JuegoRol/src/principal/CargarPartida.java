package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import principal.entes.Jugador;

public class CargarPartida {

	public static Jugador cargar() {
		Jugador j = null;
		File f = new File("recursos/guardados/save.s");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			System.out.println("AQUI");
			j = (Jugador) ois.readObject();

			ois.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return j;
	}
}
