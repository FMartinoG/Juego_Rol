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
		int[] estadisticas = { 100, 100, 100, 10 };
		int[] resistenciasMagicas = { 1, 1, 1 };
		String[] acciones = { "Observar", "Imitar", "Contar Chiste", "Hablar" };
		String[] reacciones = { "Se ruboriza", "Hace gestos obscenos", "Se rie fuertemente y se va riendose",
				"No te responde" };
		ArrayList<Integer> ordenAcciones = new ArrayList<>();
		ordenAcciones.add(2);
		Enemigo botman = new Enemigo(Constantes.BOTMAN, estadisticas, resistenciasMagicas, acciones, reacciones,
				ordenAcciones, 50, 40);
		
		return botman;
	}
}
