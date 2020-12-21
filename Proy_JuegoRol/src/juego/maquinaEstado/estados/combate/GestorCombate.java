package juego.maquinaEstado.estados.combate;

import java.awt.Graphics;

import juego.Constantes;
import juego.entes.Jugador;
import juego.herramientas.CargadorRecursos;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el juego.
 * 
 * @author Fernando Martino
 *
 */
public class GestorCombate implements EstadoJuego {

	private boolean enCombate;
	private EstructuraCombate ec;

	public GestorCombate() {
		enCombate = true;
		ec = new EstructuraCombate(CargadorRecursos.cargarImagenTranslucida(Constantes.PERSONAJE), CargadorRecursos.cargarImagenTranslucida(Constantes.BOTMAN));
	}

	public GestorCombate(Jugador jugador) {
	}

	@Override
	public void actualizar() {
		ec.actualizar();
		enCombate = ec.isEnCombate();
	}

	@Override
	public void dibujar(Graphics g) {
		ec.dibujar(g);
	}
	
	public boolean isEnCombate() {
		return enCombate;
	}
}
