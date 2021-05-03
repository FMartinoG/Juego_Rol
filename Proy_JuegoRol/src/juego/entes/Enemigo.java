package juego.entes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase encargada de guardar los datos de los enemigos.
 * 
 * @author Fernando Martino
 *
 */
public class Enemigo {

	private String nombre;

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

	/**
	 * Constructor de la clase enemigo.
	 * 
	 * @param nombre              String
	 * @param imagen              String
	 * @param estadisticas        int[]
	 * @param resistenciasMagicas int[]
	 * @param acciones            String[]
	 * @param reacciones          String[]
	 * @param ordenAcciones       ArrayList{Integer}
	 * @param experiencia         int
	 * @param probHuida           int
	 */
	public Enemigo(String nombre, String imagen, int[] estadisticas, int[] resistenciasMagicas, String[] acciones,
			String[] reacciones, ArrayList<Integer> ordenAcciones, int experiencia, int probHuida) {
		this.nombre = nombre;
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

	/**
	 * Método que devuelve el nombre del enemigo.
	 * 
	 * @return nombre String - Nombre del enemigo.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que devuelve la vida máxima del enemigo-
	 * 
	 * @return vidaMaxima int - Vida máxima del enemigo.
	 */
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	/**
	 * Método que devuelve la vida actual del enemigo-
	 * 
	 * @return vida int - Vida actual del enemigo.
	 */
	public int getVidaActual() {
		return vidaActual;
	}

	/**
	 * Método que indica si la salud del enemigo es mayor que 0, lo que significa
	 * que sigue vivo.
	 * 
	 * @return vivo boolean - Salud mayor que 0.
	 */
	public boolean estaVivo() {
		return vidaActual > 0;
	}

	/**
	 * Método que genera y devuelve un ataque físico.
	 * 
	 * @return ataque int - Daño del ataque.
	 */
	public int realizarAtaqueFisico() {
		int ataque = 0;
		if (poderFisico > 0) {
			Random aleatorio = new Random();
			ataque = aleatorio.nextInt(poderFisico);
		}
		return ataque;
	}

	/**
	 * Método que genera y devuelve un ataque mágico.
	 * 
	 * @return ataque int - Daño del ataque.
	 */
	public int realizarAtaqueMagico() {
		int ataque = 0;
		if (poderMagico > 0) {
			Random aleatorio = new Random();
			ataque = aleatorio.nextInt(poderMagico);
		}
		return ataque;
	}

	/**
	 * Método que se encarga de recibir el ataque físico, cambiar la vida y devuelve
	 * el daño recibido.
	 * 
	 * @param n int - Poder del ataque.
	 * @return ataque int - Daño recibido.
	 */
	public int recibirAtaqueFisico(int n) {
		int ataque = 0;
		if (n > resistenciaFisica) {
			ataque = n - resistenciaFisica;
			vidaActual -= ataque;
		}
		return ataque;
	}

	/**
	 * Método que se encarga de recibir el ataque mágico, cambiar la vida y devuelve
	 * el daño recibido.
	 * 
	 * @param n        int - Poder del ataque.
	 * @param elemento int - Referencia al tipo de magia.
	 * @return ataque int - Daño recibido.
	 */
	public int recibirAtaqueMagico(int n, int elemento) {
		int ataque = n * resistenciasMagicas[elemento];
		vidaActual -= ataque;
		return ataque;
	}

	/**
	 * Método que indica si el personaje ha podido huir del combate.
	 * 
	 * @return huida boolean.
	 */
	public boolean intentarHuir() {
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(100);
		return numero >= (100 - probabilidadHuida);
	}

	/**
	 * Método que devuelve el array con las acciones.
	 * 
	 * @return acciones String[] - Array con las acciones.
	 */
	public String[] getAcciones() {
		return acciones;
	}

	/**
	 * Método que devuelve la ruta de la imagen del enemigo.
	 * 
	 * @return imagen String - Ruta de la imagen.
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Método que devuelve la experiencia que da el enemigo al derrotarlo.
	 * 
	 * @return experiencia int - Experiencia que da el enemigo.
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Método que devuelve el array con las reacciones.
	 * 
	 * @return acciones String[] - Array con las reacciones.
	 */
	public String[] getReacciones() {
		return reacciones;
	}

	/**
	 * Método que devuelve la lista con el orden en que se debe realizar las
	 * acciones.
	 * 
	 * @return ordenAcciones ArrayList{Integer} - Lista con el orden de las
	 *         acciones.
	 */
	public ArrayList<Integer> getOrdenAcciones() {
		return ordenAcciones;
	}
}
