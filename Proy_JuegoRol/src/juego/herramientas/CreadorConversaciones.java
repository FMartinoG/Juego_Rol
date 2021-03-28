package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;

public class CreadorConversaciones {

	public static void crearConversaciones() {
		Constantes.CONVERSACIONES = new ArrayList<>();
		String[] conversacion0 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion1 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion2 = { "MENSAJE 1", "MENSAJE 2", "MENSAJE 3" };
		String[] conversacion3 = { "MENSAJE 1", "MENSAJE 2", "MENSAJE 3", "MENSAJE 4" };
		Constantes.CONVERSACIONES.add(conversacion0);
		Constantes.CONVERSACIONES.add(conversacion1);
		Constantes.CONVERSACIONES.add(conversacion2);
		Constantes.CONVERSACIONES.add(conversacion3);
	}
}
