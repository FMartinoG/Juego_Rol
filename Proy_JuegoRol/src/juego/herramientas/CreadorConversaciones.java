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
	 * Método encargado de crear y guardar las conversaciones.
	 */
	public static void crearConversaciones() {
		Constantes.CONVERSACIONES = new ArrayList<>();
		String[] conversacion1 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion2 = { "BUENOS DÍAS JOVEN", "HE VENIDO A POR LOS IMPUESTOS" };
		String[] conversacion3 = { "LA CASA DEL GOBERNADOR ES LA DEL SUR" };
		String[] conversacion4 = { "UNO MENOS EN LA LISTA" , "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA", "CHICO, SERÁ MEJOR QUE TE VAYAS Y NO DIGAS NADA" };
		String[] conversacion5 = { "¿TODAVÍA ME SIGUES?", "BUENO, SUPONGO QUE ERA INEVITABLE", "PERO PARECE QUE NI SIQUERA SABES PELEAR", "YA QUE HAS VENIDO TE ENSEÑARÉ A LUCHAR" };
		String[] conversacion6 = { "BUENO CHAVAL, YO ME VOY A LA CAPITAL, NOS VEMOS" };
		String[] conversacion7 = { "ERES UN POCO PESADO, DEJA DE SEGURIME", "BUENO, YO A LO MIO, VOY A MATAR AL REY Y ESAS COSAS..." };
		String[] conversacion8 = { "AHORA MISMO NO SE PUEDE ENTRAR, TENGA UN BUEN DÍA" };
		
		Constantes.CONVERSACIONES.add(conversacion1);
		Constantes.CONVERSACIONES.add(conversacion2);
		Constantes.CONVERSACIONES.add(conversacion3);
		Constantes.CONVERSACIONES.add(conversacion4);
		Constantes.CONVERSACIONES.add(conversacion5);
		Constantes.CONVERSACIONES.add(conversacion6);
		Constantes.CONVERSACIONES.add(conversacion7);
		Constantes.CONVERSACIONES.add(conversacion8);
	}
}
