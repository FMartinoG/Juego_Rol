package juego.guardado_cargado;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import juego.entes.Jugador;

public class GuardarPartida {

	public static int guardar(Jugador jugador) {
		File f = new File("recursos/guardados/save.s");
		int resultado = 0;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(jugador.getEstadisticas());
			oos.close();
			
			resultado = 1;
		} catch (IOException e) {
		}
		
		return resultado;
	}
}
