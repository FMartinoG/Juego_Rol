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
		String[] conversacion3 = { "UNO MENOS EN LA LISTA", "EL SIGUIENTE ES EL REY", "...", "...", "OH VAYA",
				"CHICO, SER� MEJOR QUE TE VAYAS Y NO DIGAS NADA" };
		String[] conversacion4 = { "�TODAV�A ME SIGUES?", "BUENO, SUPONGO QUE ERA INEVITABLE",
				"PERO PARECE QUE NI SIQUERA SABES PELEAR", "YA QUE HAS VENIDO TE ENSE�AR� A LUCHAR" };
		String[] conversacion5 = { "BUENO CHAVAL, YO ME VOY A LA CAPITAL, NOS VEMOS" };
		String[] conversacion6 = { "ERES UN POCO PESADO, DEJA DE SEGURIME",
				"BUENO, YO A LO MIO, VOY A MATAR AL REY Y ESAS COSAS..." };
		String[] conversacion7 = { "AHORA MISMO NO SE PUEDE ENTRAR, TENGA UN BUEN D�A" };
		String[] conversacion8 = { "OYE CHAVAL, YA CASI QUE ME CAES BIEN", "AUNQUE NO ENTIENDO POR QU� ME SIGUES",
				"NI SIQUIERA S� TU NOMBRE, Y T� TAMPOCO SABES EL MIO", "PERO SEGURAMENTE AS� SEA MEJOR",
				"AC�RCATE Y TE VOY A CONTAR UNA HISTORIA" };
		String[] conversacion9 = { "HACE A�OS HAB�A 5 HEROES EN EL REINO", "PERO UN D�A, UNO TRAICION� A LOS DEM�S",
				"Y POR ESO ESTOY AQU�", "PARA VENGARME DE ESE TRAIDOR", "PERO NO VALE CON MATARLO",
				"TAMBI�N MATAR� A TODOS LOS QUE ESTABAN CON �L", "SOLO QUEDAN EL REY Y �L", "...",
				"Y AHORA QUE LO SABES...", "�QU� VAS A HACER?" };
		String[] conversacion10 = { "POR AQU� NO SE PUEDE PASAR, TENGA UN BUEN D�A" };
		String[] conversacion11 = { "ALTO AH�" };
		String[] conversacion12 = { "ALGO RARO EST� PASANDO DENTRO", "NO VOY A DEJARTE ENTRAR" };
		String[] conversacion13 = { "�T� VIENES CON �L?", "ENTONCES TENDR� QUE MATARTE" };
		String[] conversacion14 = { "GRACIAS POR TU AYUDA", "ESTO HA SALIDO UN POCO MAL, PERO HE DESCUBIERTO ALGO",
				"EL HOMBRE AL QUE BUSCO, AHORA ES UN CONDE", "Y VIVE EN UNA MANSI�N AL SUR DEL CONTINENTE",
				"SUPONGO QUE TAMBI�N VENDR�S", "NOS VEMOS ALL�" };
		String[] conversacion15 = { "NO ME ESPERABA QUE ESTE TIPO VINIERA AQU�",
				"Y MUCHO MENOS ESPERABA QUE ALGUIEN LO SIGUIERA", "PERO AL FINAL TODO ESO DA IGUAL",
				"NO SALDREIS VIVOS DE AQU�" };
		String[] conversacion16 = { "GRACIAS POR TODO", "AL FINAL NO HE ESTADO A LA ALTURA",
				"PERO NO VOLVER� A PASAR ...", "ME GUSTAR�A SABER POR QU� ME HAS SEGUIDO",
				"PERO TE DIR� COMO ACABA LA HISTORIA DE ANTES", "MI PADRE ERA UNO DE ESOS 5 H�ROES",
				"TRAS SU MUERTE TUVE QUE HUIR DEL REINO", "UN D�A CONSEGU� UN ARMA MUY EXTRA�A Y PODEROSA",
				"ENTONCES DECID� INICIAR MI VENGANZA", "... ... ... ... ... ...",
				"AHORA QUE HA TERMINADO TODO, DEBER�AS VOLVER A CASA", "O POR LO MENOS INTENTARLO" };

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
