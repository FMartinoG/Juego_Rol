package juego.guardado_cargado;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import juego.entes.Jugador;

public class GuardarPartida {

	public static void guardar(Jugador jugador) {
		File f = new File("recursos/guardados/save.s");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(jugador.getEstadisticas());
			oos.close();
		} catch (IOException e) {
		}
		
		
	}
}
