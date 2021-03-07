package juego.herramientas;

import juego.Constantes;
import juego.entes.Enemigo;

public class CreadorEnemigos {

	public static void crearEnemigos() {
		int[] estadisticas = { 100, 100, 100, 100 };
		int[] resistenciasMagicas = { 1, 1, 1 };
		String[] acciones = { "Observar", "Imitar", "Contar Chiste", "Hablar" };
		Enemigo botman = new Enemigo(Constantes.BOTMAN, estadisticas, resistenciasMagicas, acciones, 50);
		Constantes.ENEMIGOS = new Enemigo[1];
		Constantes.ENEMIGOS[0] = botman;
	}
}
