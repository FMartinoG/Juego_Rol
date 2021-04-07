package juego.entes;

import java.io.Serializable;
import java.util.Random;

/**
 * Clase encargada de almacenar y cambiar las estadísticas del jugador.
 * 
 * @author Fernando Martino
 *
 */
public class Estadisticas implements Serializable {
	private static final long serialVersionUID = 230022786243647812L;

	private int nivel;
	private int expMaxima, exp;
	private int saludMaxima, salud;
	private int manaMaximo, mana;
	private int ataque, defensa;
	private int poderMagico, defensaMagica;

	// Código numérico que identifica al mapa para cargar la partida.
	private int mapa;

	public Estadisticas() {
		nivel = 1;
		expMaxima = 100;
		mapa = 1;
		this.saludMaxima = this.salud = 50;
		this.manaMaximo = this.mana = 50;
		this.ataque = 50;
		this.defensa = 50;
		this.poderMagico = 50;
		this.defensaMagica = 50;
	}

	/**
	 * Método que devuelve la salud máxima.
	 * 
	 * @return saludMaxima int - La salud máxima del personaje.
	 */
	public int getSaludMaxima() {
		return saludMaxima;
	}

	/**
	 * Método que devuelve la salud actual.
	 * 
	 * @return salud int - La salud actual del personaje.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * Método que aumenta la salud del personaje con la cantidad indicada.
	 * 
	 * @param cura int - Salud a curar.
	 */
	public void curar(int cura) {
		salud += cura;
		if (salud > saludMaxima)
			salud = saludMaxima;
	}

	/**
	 * Método que cura completamente al personaje.
	 */
	public void curaTotal() {
		salud = saludMaxima;
	}

	public int recibirAtaqueFisico(int n) {
		int ataque = 0;
		if (n > defensa) {
			ataque = n - defensa;
			salud -= ataque;
			if (salud < 0)
				salud = 0;
		}
		return ataque;
	}

	public int recibirAtaqueMagico(int n) {
		int ataque = 0;
		if (n > defensa) {
			ataque = n - defensaMagica;
			salud -= ataque;
			if (salud < 0)
				salud = 0;
		}
		return ataque;
	}

	public int realizarAtaqueFisico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(ataque);
		return ataqueRealizado;
	}

	public int realizarAtaqueMagico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(poderMagico);
		return ataqueRealizado;
	}

	public int getManaMaximo() {
		return manaMaximo;
	}

	public int getMana() {
		return mana;
	}

	public void gastarMana(int gasto) {
		this.mana -= gasto;
	}

	public void recuperarTodoMana() {
		this.mana = this.manaMaximo;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getPoderMagico() {
		return poderMagico;
	}

	public int getDefensaMagica() {
		return defensaMagica;
	}

	public int getNivel() {
		return nivel;
	}

	public int getExpMaxima() {
		return expMaxima;
	}

	public int getExp() {
		return exp;
	}

	public void aumentarExp(int exp) {
		this.exp += exp;
		if (this.exp > expMaxima) {
			subirNivel();
		}
	}

	private void subirNivel() {
		++nivel;
		exp -= expMaxima;
		ataque += 5;
		defensa += 5;
		poderMagico += 5;
		defensaMagica += 5;
	}

	public int getMapa() {
		return mapa;
	}

	public void cambiarMapa(int n) {
		this.mapa = n;
	}

}
