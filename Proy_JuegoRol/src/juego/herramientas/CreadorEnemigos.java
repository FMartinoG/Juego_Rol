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
		Constantes.ENEMIGOS = new Enemigo[4];
		Constantes.ENEMIGOS[0] = crearBotman();
		Constantes.ENEMIGOS[1] = crearRecaudador();
		Constantes.ENEMIGOS[2] = crearMisterioso();
		Constantes.ENEMIGOS[3] = crearEnemigoDePractica();
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
