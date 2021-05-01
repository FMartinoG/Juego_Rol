package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;
import juego.entes.Enemigo;

/**
 * Clase encargada de crear y guardar los enemigos del juego.
 * 
 * @author Fernando Martino
 *
 */
public class CreadorEnemigos {

	/**
	 * Método que manda crear los enemigos y los guarda.
	 */
	public static void crearEnemigos() {
		Constantes.ENEMIGOS = new Enemigo[9];
		Constantes.ENEMIGOS[0] = crearBotman();
		Constantes.ENEMIGOS[1] = crearRecaudador();
		Constantes.ENEMIGOS[2] = crearMisterioso();
		Constantes.ENEMIGOS[3] = crearEnemigoDePractica();
		Constantes.ENEMIGOS[4] = crearGuardiaEntradaCapital();
		Constantes.ENEMIGOS[5] = crearGuardiaCastillo();
		Constantes.ENEMIGOS[6] = crearGuardiaMansion();
		Constantes.ENEMIGOS[7] = crearRey();
		Constantes.ENEMIGOS[8] = crearConde();
	}

	/**
	 * Método que crea y devuelve al enemigo "Recaudador de impuestos".
	 * 
	 * @return recaudador Enemigo
	 */
	private static Enemigo crearRecaudador() {
		int[] estadisticas = { 1000, 1000, 1000, 1000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Buscar dinero", "Amenazar", "Contar Chiste", "Negociar" };
		String[] reacciones = { "Te mete prisa", "Ni siquiera se da cuenta de que lo amenazas", "Se rie discretamente",
				"Te dice que vayas a hablar con el gobernador en la casa al sur." };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(3);

		Enemigo recaudador = new Enemigo("RECAUDADOR DE IMPUESTOS", Constantes.RECAUDADOR, estadisticas,
				resistenciasMagicas, acciones, reacciones, ordenAcciones, 0, 0);
		return recaudador;
	}

	/**
	 * Método que crea y devuelve al enemigo "Hombre misterioso".
	 * 
	 * @return misterioso Enemigo
	 */
	private static Enemigo crearMisterioso() {
		int[] estadisticas = { 10000, 10000, 10000, 10000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Gritar por ayuda" };
		String[] reacciones = { "Está todo manchado de sangre, pero no tiene armas", "Te ignora",
				"Parece que se ha reido, pero finge que no", "Te observa fijamente y corre hacia la ventana" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(3);

		Enemigo misterioso = new Enemigo("HOMBRE MISTERIOSO", Constantes.MISTERIOSO, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 0, 0);
		return misterioso;
	}

	/**
	 * Método que crea y devuelve al enemigo "Enemigo de Practica".
	 * 
	 * @return practica Enemigo
	 */
	private static Enemigo crearEnemigoDePractica() {
		int[] estadisticas = { 100, 0, 0, 10 };
		int[] resistenciasMagicas = { 1, 1, 1 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Espantar" };
		String[] reacciones = { "Es un maniquí", "Es un maniquí, no te entiende",
				"Es un maniquí, no te entiende", "Bueno, venga..... Lo has espantado (pero sigue siendo un maniqui)" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(0);
		ordenAcciones.add(1);
		ordenAcciones.add(2);
		ordenAcciones.add(3);

		Enemigo practica = new Enemigo("MANIQUÍ DE PRACTICAS", Constantes.MANIQUI, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 20, 100);
		return practica;
	}
	
	/**
	 * Método que crea y devuelve al enemigo "Guardia entrada ciudad".
	 * 
	 * @return guardia Enemigo
	 */
	private static Enemigo crearGuardiaEntradaCapital() {
		int[] estadisticas = { 100, 100, 0, 10 };
		int[] resistenciasMagicas = { 1, 1, 2 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Suplicar" };
		String[] reacciones = { "Se siente incómodo si lo miras fijamente", "Parece un poco asustado",
				"No le ha hecho ninguna gracia y siente pena por ti", "Se siente muy incómodo" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);
		ordenAcciones.add(3);

		Enemigo guardia = new Enemigo("GUARDIA ENTRADA CIUDAD", Constantes.GUARDIA_ENTRADA_CIUDAD, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 50, 50);
		return guardia;
	}
	
	/**
	 * Método que crea y devuelve al enemigo "Guardia Castillo".
	 * 
	 * @return guardia Enemigo
	 */
	private static Enemigo crearGuardiaCastillo() {
		int[] estadisticas = { 100, 130, 0, 20 };
		int[] resistenciasMagicas = { 2, 1, 2 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Halagar" };
		String[] reacciones = { "Parece un poco acalorado con esa armadura metálica", "Te apunta con su lanza",
				"Le ha hecho gracia, pero no se ríe porque está trabajando", "Se sonroja levemente" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);
		ordenAcciones.add(3);
		ordenAcciones.add(2);

		Enemigo guardia = new Enemigo("GUARDIA CASTILLO", Constantes.GUARDIA_CASTILLO, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 50, 50);
		return guardia;
	}
	
	/**
	 * Método que crea y devuelve al enemigo "Guardia Mansion".
	 * 
	 * @return guardia Enemigo
	 */
	private static Enemigo crearGuardiaMansion() {
		int[] estadisticas = { 150, 150, 100, 40 };
		int[] resistenciasMagicas = { 1, 2, 0 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Bostezar" };
		String[] reacciones = { "Su armadura parece que no es muy abrigada, pero por lo menos no es metálica", "Le ha hecho gracia",
				"El chiste le ha ofendido (y con razón)", "Le provocas un bostezo" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(1);
		ordenAcciones.add(3);
		ordenAcciones.add(2);
		ordenAcciones.add(3);

		Enemigo guardia = new Enemigo("GUARDIA MANSIÓN", Constantes.GUARDIA_MANSION, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 75, 25);
		return guardia;
	}
	
	/**
	 * Método que crea y devuelve al enemigo "EL REY".
	 * 
	 * @return rey Enemigo
	 */
	private static Enemigo crearRey() {
		int[] estadisticas = { 300, 200, 100, 40 };
		int[] resistenciasMagicas = { 2, 1, 0 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Disculparse" };
		String[] reacciones = { "Su armadura brilla de forma extraña y por algún motivo parece que él también brilla", "Se lleva su mano al costado",
				"Parece que se ha relajado un poco", "No sabe si confiar en ti" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(1);
		ordenAcciones.add(2);
		ordenAcciones.add(2);
		ordenAcciones.add(2);
		ordenAcciones.add(3);

		Enemigo rey = new Enemigo("EL REY", Constantes.REY, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 2200, 0);
		return rey;
	}
	
	/**
	 * Método que crea y devuelve al enemigo "EL CONDE".
	 * 
	 * @return conde Enemigo
	 */
	private static Enemigo crearConde() {
		int[] estadisticas = { 500, 200, 200, 40 };
		int[] resistenciasMagicas = { 2, 1, 0 };
		String[] acciones = { "Obversar", "Amenazar", "Contar Chiste", "Dialogar" };
		String[] reacciones = { "Se ha bebido un frasco de algo y parece que las cosas metálicas se mueven", "Parece que sus músculos han crecido",
				"Parece demasiado enfadado para reirse", "No le caes bien, pero parece que te escucha" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(0);
		ordenAcciones.add(1);
		ordenAcciones.add(2);
		ordenAcciones.add(0);
		ordenAcciones.add(3);
		ordenAcciones.add(2);
		ordenAcciones.add(1);
		ordenAcciones.add(2);
		ordenAcciones.add(3);

		Enemigo conde = new Enemigo("EL CONDE", Constantes.CONDE, estadisticas, resistenciasMagicas,
				acciones, reacciones, ordenAcciones, 1100, 0);
		return conde;
	}

	/**
	 * Método que crea y devuelve al enemigo "Botman".
	 * 
	 * @return botman Enemigo
	 */
	private static Enemigo crearBotman() {
		int[] estadisticas = { 1000, 1000, 1000, 1000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Observar", "Imitar", "Contar Chiste", "Hablar" };
		String[] reacciones = { "Se ruboriza", "Hace gestos obscenos", "Se rie fuertemente", "No te responde" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);

		Enemigo botman = new Enemigo("BOTMAN", Constantes.BOTMAN, estadisticas, resistenciasMagicas, acciones,
				reacciones, ordenAcciones, 50, 40);

		return botman;
	}

	/*
	 * PLANTILLA DE ENEMIGO
	 * 
	 * NOMBRE, RUTA IMAGEN,
	 * 
	 * ESTADISTICAS -> [VIDA, PODER FISICO, PODER MAGICO, RESISTENCIA FISICA],
	 * 
	 * RESISTENCIA MAGICA -> [FUEGO, HIELO, RAYO],
	 * 
	 * ACCIONES, REACCIONES, ORDEN ACCIONES, EXP, % HUIDA
	 */
}
