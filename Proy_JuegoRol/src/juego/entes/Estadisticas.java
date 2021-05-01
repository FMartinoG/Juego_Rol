package juego.entes;

import java.io.Serializable;
import java.util.Random;

/**
 * Clase encargada de almacenar y cambiar las estadísticas del jugador. Es la
 * clase que se guardará en el fichero serializable.
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

	/**
	 * Constructor de la clase estadísticas.
	 */
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
	 * @param cura
	 *            int - Salud a curar.
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

	/**
	 * Método encargado de recibir el ataque físico realizado por el enemigo,
	 * cambiar la salud y devolver el daño que recibe el personaje.
	 * 
	 * @param n
	 *            int - Ataque físico del enemigo.
	 * @return ataque int - Daño recibido por el personaje.
	 */
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

	/**
	 * Método encargado de recibir el ataque mágico realizado por el enemigo,
	 * cambiar la salud y devolver el daño que recibe el personaje.
	 * 
	 * @param n
	 *            int - Ataque mágico del enemigo.
	 * @return ataque int - Daño recibido por el personaje.
	 */
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

	/**
	 * Método que devuelve el ataque físico realizado por el personaje.
	 * 
	 * @return ataque int - Ataque físico del personaje.
	 */
	public int realizarAtaqueFisico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(ataque);
		return ataqueRealizado;
	}

	/**
	 * Método que devuelve el ataque mágico realizado por el personaje.
	 * 
	 * @return ataque int - Ataque mágico del personaje.
	 */
	public int realizarAtaqueMagico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(poderMagico);
		return ataqueRealizado;
	}

	/**
	 * Método que devuelve el maná máximo del personaje.
	 * 
	 * @return manaMaximo int - Maná máximo del personaje.
	 */
	public int getManaMaximo() {
		return manaMaximo;
	}

	/**
	 * Método que devuelve el maná actual del personaje.
	 * 
	 * @return mana int - Maná actual del personaje.
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Método que disminuye la cantidad de maná actual.
	 * 
	 * @param gasto int - Maná que se gasta.
	 * @return tieneMana boolean
	 */
	public boolean gastarMana(int gasto) {
		boolean tieneMana = true;
		if (mana >= 20)
			this.mana -= gasto;
		else
			tieneMana = false;
		return tieneMana;
	}

	/**
	 * Método que aumenta el maná hasta el máximo.
	 */
	public void recuperarTodoMana() {
		this.mana = this.manaMaximo;
	}

	/**
	 * Método que devuelve el ataque físico del personaje.
	 * 
	 * @return ataque int - Poder físco del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Método que devuelve la defensa del personaje.
	 * 
	 * @return defensa int - Defensa del personaje
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Método que devuelve el poder mágico del personaje.
	 * 
	 * @return poderMagico int - Poder mágico del personaje
	 */
	public int getPoderMagico() {
		return poderMagico;
	}

	/**
	 * Método que devuelve la resistencia mágica del personaje.
	 * 
	 * @return defensaMagica int - Resistencia mágica del personaje
	 */
	public int getDefensaMagica() {
		return defensaMagica;
	}

	/**
	 * Método que devuelve el nivel del personaje;
	 * 
	 * @return nivel int - Nivel Actual del personaje.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Método que devuelve la experiencia máxima.
	 * 
	 * @return expMaxima int - Experiencia máxima
	 */
	public int getExpMaxima() {
		return expMaxima;
	}

	/**
	 * Método que devuelve la experiencia actual.
	 * 
	 * @return exp int - Experiencia actual
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Método enacargado de aumentar la experiencia y si alcanza la experiencia
	 * máxima, manda subir de nivel.
	 * 
	 * @param exp
	 *            int - Cantidad de experiencia que aumenta.
	 */
	public void aumentarExp(int exp) {
		this.exp += exp;
		if (this.exp > expMaxima) {
			subirNivel();
		}
	}

	/**
	 * Método encargado de aumentar el nivel y las estadísticas.
	 */
	private void subirNivel() {
		while (exp >= expMaxima) {
			++nivel;
			exp -= expMaxima;
			saludMaxima += 10;
			manaMaximo += 10;
			ataque += 5;
			defensa += 5;
			poderMagico += 5;
			defensaMagica += 5;
		}
	}

	/**
	 * Método que devuelve la referencia al mapa actual.
	 * 
	 * @return mapa int - Referencia al mapa actual.
	 */
	public int getMapa() {
		return mapa;
	}

	/**
	 * Método que cambia la referencia al mapa actual.
	 * 
	 * @param n
	 *            int - Referencia del nuevo mapa.
	 */
	public void cambiarMapa(int n) {
		this.mapa = n;
	}

}
