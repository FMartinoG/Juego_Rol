package principal.maquinaEstado.estados.combate;

import java.awt.Graphics;

import principal.Constantes;
import principal.HUD.InterfazUsuario;
import principal.entes.Jugador;
import principal.herramientas.CargadorRecursos;
import principal.mapas.Mapa;
import principal.maquinaEstado.EstadoJuego;

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
		ec = new EstructuraCombate(CargadorRecursos.cargarImagenTranslucida(Constantes.PERSONAJE), CargadorRecursos.cargarImagenTranslucida(Constantes.BATMAN));
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
