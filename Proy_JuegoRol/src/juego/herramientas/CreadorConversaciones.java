package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;

public class CreadorConversaciones {

	public static void crearConversaciones() {
		Constantes.CONVERSACIONES = new ArrayList<>();
		String[] conversacion0 = { "MENSAJE 1", "MENSAJE 2" };
		Constantes.CONVERSACIONES.add(conversacion0);
	}
}
