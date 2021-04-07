package juego.maquinaEstado.estados.combate;

import java.awt.Graphics;

import juego.entes.Enemigo;
import juego.entes.Jugador;
import juego.maquinaEstado.EstadoJuego;

/**
 * Clase Estado de Juego encargada de crear el combate.
 * 
 * @author Fernando Martino
 *
 */
public class GestorCombate implements EstadoJuego {

	private Jugador jugador;
	private Enemigo enemigo;

	private boolean enCombate;
	private EstructuraCombate ec;

	/**
	 * Constructor de la clase gestor de combate.
	 * 
	 * @param jugador
	 * @param enemigo
	 */
	public GestorCombate(Jugador jugador, Enemigo enemigo) {
		enCombate = true;
		this.jugador = jugador;
		this.enemigo = enemigo;
		ec = new EstructuraCombate(this.jugador, this.enemigo);
	}

	/**
	 * Método encargado de actualizar los elementos del estado.
	 */
	@Override
	public void actualizar() {
		ec.actualizar();
		enCombate = ec.isEnCombate();
	}

	/**
	 * Método encargado de dibujar los elementos del estado.
	 */
	@Override
	public void dibujar(Graphics g) {
		ec.dibujar(g);
	}

	/**
	 * Método que indica si sigue en combate o ha terminado.
	 * 
	 * @return enCombate boolean
	 */
	public boolean isEnCombate() {
		return enCombate;
	}
}
