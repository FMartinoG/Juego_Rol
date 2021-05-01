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
		String[] conversacion1 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion2 = { "BUENOS D�AS JOVEN", "HE VENIDO A POR LOS IMPUESTOS" };
		String[] conversacion3 = { "LA CASA DEL GOBERNADOR ES LA DEL SUR" };
		String[] conversacion4 = { "UNO MENOS EN LA LISTA", "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA",
				"CHICO, SER� MEJOR QUE TE VAYAS Y NO DIGAS NADA" };
		String[] conversacion5 = { "�TODAV�A ME SIGUES?", "BUENO, SUPONGO QUE ERA INEVITABLE",
				"PERO PARECE QUE NI SIQUERA SABES PELEAR", "YA QUE HAS VENIDO TE ENSE�AR� A LUCHAR" };
		String[] conversacion6 = { "BUENO CHAVAL, YO ME VOY A LA CAPITAL, NOS VEMOS" };
		String[] conversacion7 = { "ERES UN POCO PESADO, DEJA DE SEGURIME",
				"BUENO, YO A LO MIO, VOY A MATAR AL REY Y ESAS COSAS..." };
		String[] conversacion8 = { "AHORA MISMO NO SE PUEDE ENTRAR, TENGA UN BUEN D�A" };
		String[] conversacion9 = { "OYE CHAVAL, YA CASI QUE ME CAES BIEN", "AUNQUE NO ENTIENDO POR QU� ME SIGUES",
				"NI SIQUIERA S� TU NOMBRE, Y T� TAMPOCO SABES EL MIO", "PERO SEGURAMENTE AS� SEA MEJOR",
				"AC�RCATE Y TE VOY A CONTAR UNA HISTORIA" };
		String[] conversacion10 = { "HACE A�OS HAB�A 5 HEROES EN EL REINO", "PERO UN D�A, UNO TRAICION� A LOS DEM�S",
				"Y POR ESO ESTOY AQU�", "PARA VENGARME DE ESE TRAIDOR", "PERO NO VALE CON MATARLO",
				"TAMBI�N MATAR� A TODOS LOS QUE ESTABAN CON �L", "SOLO QUEDAN EL REY Y �L", "...",
				"Y AHORA QUE LO SABES...", "�QU� VAS A HACER?" };
		String[] conversacion11 = { "POR AQU� NO SE PUEDE PASAR, TENGA UN BUEN D�A" };

		Constantes.CONVERSACIONES.add(conversacion1);
		Constantes.CONVERSACIONES.add(conversacion2);
		Constantes.CONVERSACIONES.add(conversacion3);
		Constantes.CONVERSACIONES.add(conversacion4);
		Constantes.CONVERSACIONES.add(conversacion5);
		Constantes.CONVERSACIONES.add(conversacion6);
		Constantes.CONVERSACIONES.add(conversacion7);
		Constantes.CONVERSACIONES.add(conversacion8);
		Constantes.CONVERSACIONES.add(conversacion9);
		Constantes.CONVERSACIONES.add(conversacion10);
		Constantes.CONVERSACIONES.add(conversacion11);
	}
}
