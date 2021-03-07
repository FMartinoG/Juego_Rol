package juego.entes;

import java.util.ArrayList;
import java.util.Random;

public class Enemigo {

	private int experiencia;

	private int vidaMaxima;
	private int vidaActual;

	private int poderFisico;
	private int poderMagico;

	private int resistenciaFisica;

	private int probabilidadHuida;

	private int[] resistenciasMagicas;

	private String[] acciones;
	private ArrayList<Integer> ordenAcciones;
	private String[] reacciones;

	private String imagen;

	public Enemigo(String imagen, int[] estadisticas, int[] resistenciasMagicas, String[] acciones, String[] reacciones,
			ArrayList<Integer> ordenAcciones, int experiencia, int probHuida) {
		this.imagen = imagen;
		vidaMaxima = vidaActual = estadisticas[0];
		poderFisico = estadisticas[1];
		poderMagico = estadisticas[2];
		resistenciaFisica = estadisticas[3];
		this.resistenciasMagicas = resistenciasMagicas;
		this.acciones = acciones;
		this.experiencia = experiencia;
		this.probabilidadHuida = probHuida;
		this.reacciones = reacciones;
		this.ordenAcciones = ordenAcciones;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public boolean estaVivo() {
		return vidaActual > 0;
	}

	public int realizarAtaqueFisico() {
		Random aleatorio = new Random();
		int ataque = aleatorio.nextInt(poderFisico);
		return ataque;
	}

	public int realizarAtaqueMagico() {
		Random aleatorio = new Random();
		int ataque = aleatorio.nextInt(poderMagico);
		return ataque;
	}

	public int recibirAtaqueFisico(int n) {
		int ataque = 0;
		if (n > resistenciaFisica) {
			ataque = n - resistenciaFisica;
			vidaActual -= ataque;
		}
		return ataque;
	}

	public int recibirAtaqueMagico(int n, int elemento) {
		int ataque = n * resistenciasMagicas[elemento];
		vidaActual -= ataque;
		return ataque;
	}

	public boolean intentarHuir() {
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(100);
		return numero >= (100 - probabilidadHuida);
	}

	public String[] getAcciones() {
		return acciones;
	}

	public String getImagen() {
		return imagen;
	}

	public int getExperiencia() {
		return experiencia;
	}
	
	public String[] getReacciones() {
		return reacciones;
	}
	
	public ArrayList<Integer> getOrdenAcciones() {
		return ordenAcciones;
	}
}
