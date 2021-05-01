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
		String[] conversacion4 = { "UNO MENOS EN LA LISTA", "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA",
				"CHICO, SERÁ MEJOR QUE TE VAYAS Y NO DIGAS NADA" };
		String[] conversacion5 = { "¿TODAVÍA ME SIGUES?", "BUENO, SUPONGO QUE ERA INEVITABLE",
				"PERO PARECE QUE NI SIQUERA SABES PELEAR", "YA QUE HAS VENIDO TE ENSEÑARÉ A LUCHAR" };
		String[] conversacion6 = { "BUENO CHAVAL, YO ME VOY A LA CAPITAL, NOS VEMOS" };
		String[] conversacion7 = { "ERES UN POCO PESADO, DEJA DE SEGURIME",
				"BUENO, YO A LO MIO, VOY A MATAR AL REY Y ESAS COSAS..." };
		String[] conversacion8 = { "AHORA MISMO NO SE PUEDE ENTRAR, TENGA UN BUEN DÍA" };
		String[] conversacion9 = { "OYE CHAVAL, YA CASI QUE ME CAES BIEN", "AUNQUE NO ENTIENDO POR QUÉ ME SIGUES",
				"NI SIQUIERA SÉ TU NOMBRE, Y TÚ TAMPOCO SABES EL MIO", "PERO SEGURAMENTE ASÍ SEA MEJOR",
				"ACÉRCATE Y TE VOY A CONTAR UNA HISTORIA" };
		String[] conversacion10 = { "HACE AÑOS HABÍA 5 HEROES EN EL REINO", "PERO UN DÍA, UNO TRAICIONÓ A LOS DEMÁS",
				"Y POR ESO ESTOY AQUÍ", "PARA VENGARME DE ESE TRAIDOR", "PERO NO VALE CON MATARLO",
				"TAMBIÉN MATARÉ A TODOS LOS QUE ESTABAN CON ÉL", "SOLO QUEDAN EL REY Y ÉL", "...",
				"Y AHORA QUE LO SABES...", "¿QUÉ VAS A HACER?" };
		String[] conversacion11 = { "POR AQUÍ NO SE PUEDE PASAR, TENGA UN BUEN DÍA" };

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
