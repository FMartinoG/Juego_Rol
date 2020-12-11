package principal.entes;

import java.io.Serializable;

public class Estadisticas implements Serializable{
	private static final long serialVersionUID = 230022786243647812L;
	
	private int nivel;
	private int expMaxima, exp;
	private int saludMaxima, salud;
	private int manaMaximo, mana;
	private int ataque, defensa;
	private int poderMagico, defensaMagica;
	
	public Estadisticas(int saludMaxima, int manaMaximo, int ataque, int defensa, int poderMagico, int defensaMagica, boolean jugador) {
		if(jugador) {
			nivel = 1;
			expMaxima = 100;
		}
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

	public void setSaludMaxima(int saludMaxima) {
		this.saludMaxima = saludMaxima;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getManaMaximo() {
		return manaMaximo;
	}

	public void setManaMaximo(int manaMaximo) {
		this.manaMaximo = manaMaximo;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getPoderMagico() {
		return poderMagico;
	}

	public void setPoderMagico(int poderMagico) {
		this.poderMagico = poderMagico;
	}

	public int getDefensaMagica() {
		return defensaMagica;
	}

	public void setDefensaMagica(int defensaMagica) {
		this.defensaMagica = defensaMagica;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExpMaxima() {
		return expMaxima;
	}

	public void setExpMaxima(int expMaxima) {
		this.expMaxima = expMaxima;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	

}
