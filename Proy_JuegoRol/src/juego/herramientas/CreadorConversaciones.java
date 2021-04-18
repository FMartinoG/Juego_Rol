package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;

/**
 * Clase encargada de crear y almacenar las conversaciones del juego.
 * 
 * @author Fernando Martino
 *
 */
public class CreadorConversaciones {

	/**
	 * M�todo encargado de crear y guardar las conversaciones.
	 */
	public static void crearConversaciones() {
		Constantes.CONVERSACIONES = new ArrayList<>();
		String[] conversacion0 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion1 = { "BUENOS D�AS JOVEN", "HE VENIDO A POR LOS IMPUESTOS" };
		String[] conversacion2 = { "LA CASA DEL GOBERNADOR ES LA DEL SUR" };
		String[] conversacion3 = { "UNO MENOS EN LA LISTA" , "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA", "CHICO, SER� MEJOR QUE TE VAYAS Y NO DIGAS NADA" };

		Constantes.CONVERSACIONES.add(conversacion0);
		Constantes.CONVERSACIONES.add(conversacion1);
		Constantes.CONVERSACIONES.add(conversacion2);
		Constantes.CONVERSACIONES.add(conversacion2);
		Constantes.CONVERSACIONES.add(conversacion3);
	}
}
