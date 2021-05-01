package juego.entes;

import java.io.Serializable;
import java.util.Random;

/**
 * Clase encargada de almacenar y cambiar las estad�sticas del jugador. Es la
 * clase que se guardar� en el fichero serializable.
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

	// C�digo num�rico que identifica al mapa para cargar la partida.
	private int mapa;

	/**
	 * Constructor de la clase estad�sticas.
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
	 * M�todo que devuelve la salud m�xima.
	 * 
	 * @return saludMaxima int - La salud m�xima del personaje.
	 */
	public int getSaludMaxima() {
		return saludMaxima;
	}

	/**
	 * M�todo que devuelve la salud actual.
	 * 
	 * @return salud int - La salud actual del personaje.
	 */
	public int getSalud() {
		return salud;
	}

	/**
	 * M�todo que aumenta la salud del personaje con la cantidad indicada.
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
	 * M�todo que cura completamente al personaje.
	 */
	public void curaTotal() {
		salud = saludMaxima;
	}

	/**
	 * M�todo encargado de recibir el ataque f�sico realizado por el enemigo,
	 * cambiar la salud y devolver el da�o que recibe el personaje.
	 * 
	 * @param n
	 *            int - Ataque f�sico del enemigo.
	 * @return ataque int - Da�o recibido por el personaje.
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
	 * M�todo encargado de recibir el ataque m�gico realizado por el enemigo,
	 * cambiar la salud y devolver el da�o que recibe el personaje.
	 * 
	 * @param n
	 *            int - Ataque m�gico del enemigo.
	 * @return ataque int - Da�o recibido por el personaje.
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
	 * M�todo que devuelve el ataque f�sico realizado por el personaje.
	 * 
	 * @return ataque int - Ataque f�sico del personaje.
	 */
	public int realizarAtaqueFisico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(ataque);
		return ataqueRealizado;
	}

	/**
	 * M�todo que devuelve el ataque m�gico realizado por el personaje.
	 * 
	 * @return ataque int - Ataque m�gico del personaje.
	 */
	public int realizarAtaqueMagico() {
		Random aleatorio = new Random();
		int ataqueRealizado = aleatorio.nextInt(poderMagico);
		return ataqueRealizado;
	}

	/**
	 * M�todo que devuelve el man� m�ximo del personaje.
	 * 
	 * @return manaMaximo int - Man� m�ximo del personaje.
	 */
	public int getManaMaximo() {
		return manaMaximo;
	}

	/**
	 * M�todo que devuelve el man� actual del personaje.
	 * 
	 * @return mana int - Man� actual del personaje.
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * M�todo que disminuye la cantidad de man� actual.
	 * 
	 * @param gasto int - Man� que se gasta.
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
	 * M�todo que aumenta el man� hasta el m�ximo.
	 */
	public void recuperarTodoMana() {
		this.mana = this.manaMaximo;
	}

	/**
	 * M�todo que devuelve el ataque f�sico del personaje.
	 * 
	 * @return ataque int - Poder f�sco del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * M�todo que devuelve la defensa del personaje.
	 * 
	 * @return defensa int - Defensa del personaje
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * M�todo que devuelve el poder m�gico del personaje.
	 * 
	 * @return poderMagico int - Poder m�gico del personaje
	 */
	public int getPoderMagico() {
		return poderMagico;
	}

	/**
	 * M�todo que devuelve la resistencia m�gica del personaje.
	 * 
	 * @return defensaMagica int - Resistencia m�gica del personaje
	 */
	public int getDefensaMagica() {
		return defensaMagica;
	}

	/**
	 * M�todo que devuelve el nivel del personaje;
	 * 
	 * @return nivel int - Nivel Actual del personaje.
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * M�todo que devuelve la experiencia m�xima.
	 * 
	 * @return expMaxima int - Experiencia m�xima
	 */
	public int getExpMaxima() {
		return expMaxima;
	}

	/**
	 * M�todo que devuelve la experiencia actual.
	 * 
	 * @return exp int - Experiencia actual
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * M�todo enacargado de aumentar la experiencia y si alcanza la experiencia
	 * m�xima, manda subir de nivel.
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
	 * M�todo encargado de aumentar el nivel y las estad�sticas.
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
	 * M�todo que devuelve la referencia al mapa actual.
	 * 
	 * @return mapa int - Referencia al mapa actual.
	 */
	public int getMapa() {
		return mapa;
	}

	/**
	 * M�todo que cambia la referencia al mapa actual.
	 * 
	 * @param n
	 *            int - Referencia del nuevo mapa.
	 */
	public void cambiarMapa(int n) {
		this.mapa = n;
	}

}
