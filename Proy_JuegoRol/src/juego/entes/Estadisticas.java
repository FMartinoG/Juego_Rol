package juego.entes;

import java.io.Serializable;
import java.util.Random;

public class Estadisticas implements Serializable {
	private static final long serialVersionUID = 230022786243647812L;

	private int nivel;
	private int expMaxima, exp;
	private int saludMaxima, salud;
	private int manaMaximo, mana;
	private int ataque, defensa;
	private int poderMagico, defensaMagica;

	private int mapa;

	public Estadisticas(int saludMaxima, int manaMaximo, int ataque, int defensa, int poderMagico, int defensaMagica) {
		nivel = 1;
		expMaxima = 100;
		mapa = 1;
		this.saludMaxima = this.salud = saludMaxima;
		this.manaMaximo = this.mana = manaMaximo;
		this.ataque = ataque;
		this.defensa = defensa;
		this.poderMagico = poderMagico;
		this.defensaMagica = defensaMagica;
	}

	public int getSaludMaxima() {
		return saludMaxima;
	}

	public int getSalud() {
		return salud;
	}

	public void curar(int cura) {
		salud += cura;
		if (salud > saludMaxima)
			salud = saludMaxima;
	}

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
