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
		String[] conversacion0 = { "MENSAJE 1", "MENSAJE 2" };
		String[] conversacion1 = { "BUENOS DÍAS JOVEN", "HE VENIDO A POR LOS IMPUESTOS" };
		String[] conversacion2 = { "LA CASA DEL GOBERNADOR ES LA DEL SUR" };
		String[] conversacion3 = { "UNO MENOS EN LA LISTA", "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA",
				"CHICO, SERÁ MEJOR QUE TE VAYAS Y NO DIGAS NADA" };
		String[] conversacion4 = { "¿TODAVÍA ME SIGUES?", "BUENO, SUPONGO QUE ERA INEVITABLE",
				"PERO PARECE QUE NI SIQUERA SABES PELEAR", "YA QUE HAS VENIDO TE ENSEÑARÉ A LUCHAR" };
		String[] conversacion5 = { "BUENO CHAVAL, YO ME VOY A LA CAPITAL, NOS VEMOS" };
		String[] conversacion6 = { "ERES UN POCO PESADO, DEJA DE SEGURIME",
				"BUENO, YO A LO MIO, VOY A MATAR AL REY Y ESAS COSAS..." };
		String[] conversacion7 = { "AHORA MISMO NO SE PUEDE ENTRAR, TENGA UN BUEN DÍA" };
		String[] conversacion8 = { "OYE CHAVAL, YA CASI QUE ME CAES BIEN", "AUNQUE NO ENTIENDO POR QUÉ ME SIGUES",
				"NI SIQUIERA SÉ TU NOMBRE, Y TÚ TAMPOCO SABES EL MIO", "PERO SEGURAMENTE ASÍ SEA MEJOR",
				"ACÉRCATE Y TE VOY A CONTAR UNA HISTORIA" };
		String[] conversacion9 = { "HACE AÑOS HABÍA 5 HEROES EN EL REINO", "PERO UN DÍA, UNO TRAICIONÓ A LOS DEMÁS",
				"Y POR ESO ESTOY AQUÍ", "PARA VENGARME DE ESE TRAIDOR", "PERO NO VALE CON MATARLO",
				"TAMBIÉN MATARÉ A TODOS LOS QUE ESTABAN CON ÉL", "SOLO QUEDAN EL REY Y ÉL", "...",
				"Y AHORA QUE LO SABES...", "¿QUÉ VAS A HACER?" };
		String[] conversacion10 = { "POR AQUÍ NO SE PUEDE PASAR, TENGA UN BUEN DÍA" };
		String[] conversacion11 = { "ALTO AHÍ" };
		String[] conversacion12 = { "ALGO RARO ESTÁ PASANDO DENTRO", "NO VOY A DEJARTE ENTRAR" };
		String[] conversacion13 = { "¿TÚ VIENES CON ÉL?", "ENTONCES TENDRÉ QUE MATARTE" };
		String[] conversacion14 = { "GRACIAS POR TU AYUDA", "ESTO HA SALIDO UN POCO MAL, PERO HE DESCUBIERTO ALGO",
				"EL HOMBRE AL QUE BUSCO, AHORA ES UN CONDE", "Y VIVE EN UNA MANSIÓN AL SUR DEL CONTINENTE",
				"SUPONGO QUE TAMBIÉN VENDRÁS", "NOS VEMOS ALLÍ" };
		String[] conversacion15 = { "NO ME ESPERABA QUE ESTE TIPO VINIERA AQUÍ",
				"Y MUCHO MENOS ESPERABA QUE ALGUIEN LO SIGUIERA", "PERO AL FINAL TODO ESO DA IGUAL",
				"NO SALDREIS VIVOS DE AQUÍ" };
		String[] conversacion16 = { "GRACIAS POR TODO", "AL FINAL NO HE ESTADO A LA ALTURA",
				"PERO NO VOLVERÁ A PASAR ...", "ME GUSTARÍA SABER POR QUÉ ME HAS SEGUIDO",
				"PERO TE DIRÉ COMO ACABA LA HISTORIA DE ANTES", "MI PADRE ERA UNO DE ESOS 5 HÉROES",
				"TRAS SU MUERTE TUVE QUE HUIR DEL REINO", "UN DÍA CONSEGUÍ UN ARMA MUY EXTRAÑA Y PODEROSA",
				"ENTONCES DECIDÍ INICIAR MI VENGANZA", "... ... ... ... ... ...",
				"AHORA QUE HA TERMINADO TODO, DEBERÍAS VOLVER A CASA", "O POR LO MENOS INTENTARLO" };

		Constantes.CONVERSACIONES.add(conversacion0);
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
		Constantes.CONVERSACIONES.add(conversacion12);
		Constantes.CONVERSACIONES.add(conversacion13);
		Constantes.CONVERSACIONES.add(conversacion14);
		Constantes.CONVERSACIONES.add(conversacion15);
		Constantes.CONVERSACIONES.add(conversacion16);
	}
}
