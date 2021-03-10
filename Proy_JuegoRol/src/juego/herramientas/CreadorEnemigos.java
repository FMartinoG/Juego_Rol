package juego.herramientas;

import java.util.ArrayList;

import juego.Constantes;
import juego.entes.Enemigo;

public class CreadorEnemigos {

	public static void crearEnemigos() {
		Constantes.ENEMIGOS = new Enemigo[1];
		Constantes.ENEMIGOS[0] = crearBotman();
	}
	
	private static Enemigo crearBotman() {
		int[] estadisticas = { 1000, 1000, 1000, 1000 };
		int[] resistenciasMagicas = { 0, 0, 0 };
		String[] acciones = { "Observar", "Imitar", "Contar Chiste", "Hablar" };
		String[] reacciones = { "Se ruboriza", "Hace gestos obscenos", "Se rie fuertemente y se va riendose",
				"No te responde" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);
		Enemigo botman = new Enemigo("BOTMAN", Constantes.BOTMAN, estadisticas, resistenciasMagicas, acciones, reacciones,
				ordenAcciones, 50, 40);
		
		return botman;
	}
}
