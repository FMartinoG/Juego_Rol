package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;
import juego.entes.Enemigo;

public class CreadorEnemigos {

	public static void crearEnemigos() {
		Constantes.ENEMIGOS = new Enemigo[2];
		Constantes.ENEMIGOS[0] = crearBotman();
		Constantes.ENEMIGOS[1] = crearRecaudador();
		
	}
	
	private static Enemigo crearRecaudador() {
		int[] estadisticas = { 1000, 1000, 1000, 1000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Buscar dinero", "Amenazar", "Contar Chiste", "Negociar" };
		String[] reacciones = { "Te mete prisa", "Ni siquiera se da cuenta de que lo amenazas", "Se rie discretamente",
				"Te dice que vayas a hablar con el gobernador en la casa al sur." };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(0);
		ordenAcciones.add(2);
		ordenAcciones.add(3);
	
		Enemigo recaudador = new Enemigo("RECAUDADOR DE IMPUESTOS", Constantes.RECAUDADOR, estadisticas, resistenciasMagicas, acciones, reacciones,
				ordenAcciones, 0, 0);
		
		return recaudador;
	}
	
	private static Enemigo crearBotman() {
		int[] estadisticas = { 1000, 1000, 1000, 1000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Observar", "Imitar", "Contar Chiste", "Hablar" };
		String[] reacciones = { "Se ruboriza", "Hace gestos obscenos", "Se rie fuertemente",
				"No te responde" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);
	
		Enemigo botman = new Enemigo("BOTMAN", Constantes.BOTMAN, estadisticas, resistenciasMagicas, acciones, reacciones,
				ordenAcciones, 50, 40);
		
		return botman;
	}
	
	/*
	 * PLANTILLA DE ENEMIGO
	 * 
	 * NOMBRE, RUTA IMAGEN, ESTADISTICAS -> [VIDA, PODER FISICO, PODER MAGICO, RESISTENCIA FISICA],
	 * RESISTENCIA MAGICA -> [FUEGO, HIELO, RAYO], ACCIONES, REACCIONES, ORDEN ACCIONES, EXP, % HUIDA
	 */
}
