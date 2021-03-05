package juego.maquinaEstado.estados.combate;

import java.awt.Graphics;

import juego.Constantes;
import juego.entes.Enemigo;
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

	private Jugador jugador;
	private Enemigo enemigo;
	
	private boolean enCombate;
	private EstructuraCombate ec;

	public GestorCombate(Jugador jugador, Enemigo enemigo) {
		enCombate = true;
		this.jugador = jugador;
		this.enemigo = enemigo;
		ec = new EstructuraCombate(this.jugador, this.enemigo);
	}

	public GestorCombate(Jugador jugador, Jugador enemigo) {
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
