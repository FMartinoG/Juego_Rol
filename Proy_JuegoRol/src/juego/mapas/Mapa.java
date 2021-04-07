package juego.mapas;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import juego.Constantes;
import juego.herramientas.CargadorRecursos;
import juego.herramientas.SeleccionadorHojaSprite;
import juego.sprites.HojaSprites;
import juego.sprites.Sprite;

/**
 * Clase encargada de leer y dibujar el mapa.
 * 
 * @author Fernando Martino
 *
 */
public class Mapa {

	private String ruta;

	private int ancho;
	private int alto;

	private final int MARGEN_X = Constantes.ANCHO_VENTANA / 2 - Constantes.LADO_SPRITE / 2;
	private final int MARGEN_Y = Constantes.ALTO_VENTANA / 2 - Constantes.LADO_SPRITE / 2;

	private int[] numeroHojasSprites;
	private HojaSprites[] hojas;
	private int[] numeroSprite;
	private Sprite[] sprites;
	private boolean[] mapaColisiones;
	private int[] mapaSprites;

	private ArrayList<Point> conversaciones;
	private ArrayList<Rectangle> zonaConversaciones = new ArrayList<Rectangle>();
	private ArrayList<Integer> punteroConversacion;

	private ArrayList<Point> combates;
	private ArrayList<Rectangle> zonaCombates = new ArrayList<Rectangle>();
	private ArrayList<Integer> punteroCombates;

	private Point posicionInicial;
	private Point posicionSalida;
	private String siguienteMapa;
	private Rectangle zonaSalida = new Rectangle();

	public ArrayList<Rectangle> areasColision = new ArrayList<>();

	/**
	 * Contructor de la clase Mapa.
	 * 
	 * @param ruta
	 */
	public Mapa(final String ruta) {
		this.ruta = ruta;
		String mapa = CargadorRecursos.leerFicheroTexto(ruta);
		leerMapa(mapa);
	}

	/**
	 * Método encargado de actualizar el estado del mapa en cada actualización.
	 * 
	 * @param posX
	 * @param posY
	 */
	public void actualizar(final int posX, final int posY) {
		actualizarAreasColision(posX, posY);
		actualizarZonaSalida(posX, posY);
		if (conversaciones != null && !conversaciones.isEmpty())
			actualizarZonaConversacion(posX, posY);
		if (combates != null && !combates.isEmpty())
			actualizarZonaCombates(posX, posY);
	}

	/**
	 * Método encargado de dibujar el mapa en pantalla.
	 * 
	 * @param g
	 * @param posX
	 * @param posY
	 */
	public void dibujar(Graphics g, int posX, int posY) {
		int ladoSprite = Constantes.LADO_SPRITE;
		for (int i = 0; i < alto; ++i) {
			for (int j = 0; j < ancho; ++j) {

				int posxInicial = MARGEN_X + j * ladoSprite - posX;
				int posYInicial = MARGEN_Y + i * ladoSprite - posY;

				int puntero = mapaSprites[j + i * ancho];
				g.drawImage(sprites[puntero].getImagen(), posxInicial, posYInicial, null);

			}
		}
	}

	/**
	 * Método encargado de descomponer el texto recibido del mapa y mandar cada
	 * parte a analizar.
	 * 
	 * @param textoMapa
	 */
	private void leerMapa(final String textoMapa) {
		String[] partes = textoMapa.split("@");
		ancho = Integer.parseInt(partes[0]);
		alto = Integer.parseInt(partes[1]);

		String[] textoHojas = partes[2].split(",");
		guardarHojas(textoHojas);

		String[] textoSprites = partes[3].split("#");
		guardarSprites(textoSprites);

		String textoColisiones = partes[4];
		guardarColisiones(textoColisiones);

		String mapaCuadros = partes[5];
		guardarMapaSprites(mapaCuadros);

		String posJugador = partes[6];
		guardarPosicionInicial(posJugador);

		String salidaMapa = partes[7];
		guardarSalida(salidaMapa);

		String zonaConversaciones = partes[8];
		guardarZonaConversaciones(zonaConversaciones);

		String zonaCombates = partes[9];
		guardarZonaCombates(zonaCombates);
	}

	/**
	 * Recibe los códigos de las hojas de sprites que necesita el mapa y los
	 * almacena.
	 * 
	 * @param textoHojas
	 */
	private void guardarHojas(String[] textoHojas) {
		hojas = new HojaSprites[textoHojas.length];
		numeroHojasSprites = new int[textoHojas.length];
		for (int i = 0; i < textoHojas.length; ++i) {
			numeroHojasSprites[i] = Integer.parseInt(textoHojas[i]);
			hojas[i] = SeleccionadorHojaSprite.seleccionarHojaSprite(textoHojas[i]);
		}
	}

	/**
	 * Método encargado de seleccionar y guardar los sprites que se van a
	 * utilizar en el mapa.
	 * 
	 * @param textoSprites
	 */
	private void guardarSprites(String[] textoSprites) {
		sprites = new Sprite[textoSprites.length];
		numeroSprite = new int[sprites.length];
		String[] separacionTextoSprite;
		for (int i = 0; i < textoSprites.length; ++i) {
			separacionTextoSprite = textoSprites[i].split("-");
			int hojaSprite = Integer.parseInt(separacionTextoSprite[0]);
			numeroSprite[i] = Integer.parseInt(separacionTextoSprite[1]);
			int puntero = -1;
			for (int j = 0; j < numeroHojasSprites.length; ++j) {
				if (hojaSprite == numeroHojasSprites[j])
					puntero = j;
			}
			sprites[i] = hojas[puntero].getSprite(Integer.parseInt(separacionTextoSprite[3]), Integer.parseInt(separacionTextoSprite[2]));
		}
	}

	/**
	 * Método encargado de guardar las zonas a las que hay colisiones en el
	 * mapa.
	 * 
	 * @param textoColisiones
	 */
	private void guardarColisiones(String textoColisiones) {
		mapaColisiones = new boolean[textoColisiones.length()];
		for (int i = 0; i < textoColisiones.length(); ++i) {
			if (textoColisiones.charAt(i) == '0')
				mapaColisiones[i] = false;
			else
				mapaColisiones[i] = true;
		}
	}

	/**
	 * Método que guarda el orden en que los sprites van a ser dibujados en la
	 * pantalla.
	 * 
	 * @param mapaCuadros
	 */
	private void guardarMapaSprites(String mapaCuadros) {
		ArrayList<Integer> mapaAux = new ArrayList<>();
		String[] lineas = mapaCuadros.split("#");
		for (int i = 0; i < lineas.length; ++i) {
			String[] cuadrosLineas = lineas[i].split(" ");
			for (int j = 0; j < cuadrosLineas.length; ++j) {
				mapaAux.add(Integer.parseInt(cuadrosLineas[j]));
			}
		}
		mapaSprites = new int[mapaAux.size()];
		for (int i = 0; i < mapaAux.size(); ++i) {
			mapaSprites[i] = mapaAux.get(i);
		}
	}

	/**
	 * Método que guarda las zonas del mapa en que hay conversaciones.
	 * 
	 * @param zona
	 */
	private void guardarZonaConversaciones(String zona) {
		if (!zona.equals("no")) {
			conversaciones = new ArrayList<Point>();
			punteroConversacion = new ArrayList<>();
			String[] zonas = zona.split(",");
			for (int i = 0; i < zonas.length; ++i) {
				String[] partesMensaje = zonas[i].split("#");
				punteroConversacion.add(Integer.parseInt(partesMensaje[1]));
				String[] coordenadas = partesMensaje[0].split("-");
				Point p = new Point();
				p.x = Integer.parseInt(coordenadas[0]);
				p.y = Integer.parseInt(coordenadas[1]);
				conversaciones.add(i, p);
			}
		}
	}

	/**
	 * Método que guarda las zonas del mapa en que hay combates.
	 * 
	 * @param zona
	 */
	private void guardarZonaCombates(String zona) {
		if (!zona.equals("no")) {
			combates = new ArrayList<>();
			punteroCombates = new ArrayList<>();
			String[] zonas = zona.split(",");
			for (int i = 0; i < zonas.length; ++i) {
				String[] partesMensaje = zonas[i].split("#");
				punteroCombates.add(Integer.parseInt(partesMensaje[1]));
				String[] coordenadas = partesMensaje[0].split("-");
				Point p = new Point();
				p.x = Integer.parseInt(coordenadas[0]);
				p.y = Integer.parseInt(coordenadas[1]);
				combates.add(i, p);
			}
		}
	}

	/**
	 * Método que guarda la posición del mapa en que aparece el jugador al
	 * generarse.
	 * 
	 * @param posInicial
	 */
	private void guardarPosicionInicial(String posInicial) {
		String[] coordenadas = posInicial.split("-");
		posicionInicial = new Point();
		posicionInicial.x = Integer.parseInt(coordenadas[0]) * Constantes.LADO_SPRITE;
		posicionInicial.y = Integer.parseInt(coordenadas[1]) * Constantes.LADO_SPRITE;
	}

	/**
	 * Método para guardar la zona del mapa para avanzar al siguiente mapa y la
	 * referencia al siguiente mapa.
	 * 
	 * @param posSalida
	 */
	private void guardarSalida(String posSalida) {
		String[] coordenadas = posSalida.split("-");
		posicionSalida = new Point();
		posicionSalida.x = Integer.parseInt(coordenadas[0]);
		posicionSalida.y = Integer.parseInt(coordenadas[1]);
		siguienteMapa = coordenadas[2];
	}

	/**
	 * Método encargado de actualizar las zonas de colisión del mapa, en cada
	 * actualización, según la posición del jugador.
	 * 
	 * @param posX
	 * @param posY
	 */
	private void actualizarAreasColision(final int posX, final int posY) {
		if (!areasColision.isEmpty())
			areasColision.clear();

		for (int i = 0; i < alto; ++i) {
			for (int j = 0; j < ancho; ++j) {
				int puntoX = MARGEN_X + j * Constantes.LADO_SPRITE - posX;
				int puntoY = MARGEN_Y + i * Constantes.LADO_SPRITE - posY;

				if (mapaColisiones[j + i * ancho]) {
					final Rectangle r = new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
					areasColision.add(r);
				}
			}
		}

	}

	/**
	 * Método encargado de actualizar la zona de salida del mapa, en cada
	 * actualización, según la posición del jugador.
	 * 
	 * @param posX
	 * @param posY
	 */
	private void actualizarZonaSalida(final int posX, final int posY) {
		int puntoX = posicionSalida.x * Constantes.LADO_SPRITE - posX + MARGEN_X;
		int puntoY = posicionSalida.y * Constantes.LADO_SPRITE - posY + MARGEN_Y;

		zonaSalida = new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
	}

	/**
	 * Método encargado de actualizar las zonas de conversación del mapa, en
	 * cada actualización, según la posición del jugador.
	 * 
	 * @param posX
	 * @param posY
	 */
	private void actualizarZonaConversacion(final int posX, final int posY) {
		if (zonaConversaciones.size() > 0)
			zonaConversaciones.removeAll(zonaConversaciones);
		for (int i = 0; i < conversaciones.size(); ++i) {

			int puntoX = conversaciones.get(i).x * Constantes.LADO_SPRITE - posX + MARGEN_X;
			int puntoY = conversaciones.get(i).y * Constantes.LADO_SPRITE - posY + MARGEN_Y;

			zonaConversaciones.add(i, new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE));
		}
	}

	/**
	 * Método encargado de actualizar las zonas de combate del mapa, en cada
	 * actualización, según la posición del jugador.
	 * 
	 * @param posX
	 * @param posY
	 */
	private void actualizarZonaCombates(final int posX, final int posY) {
		if (zonaCombates.size() > 0)
			zonaCombates.removeAll(zonaCombates);
		for (int i = 0; i < combates.size(); ++i) {

			int puntoX = combates.get(i).x * Constantes.LADO_SPRITE - posX + MARGEN_X;
			int puntoY = combates.get(i).y * Constantes.LADO_SPRITE - posY + MARGEN_Y;

			zonaCombates.add(i, new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE));
		}
	}

	/**
	 * Método que devuelve los bordes de las zonas del mapa para comprobar
	 * colisiones.
	 * 
	 * @param posX
	 * @param posY
	 * @param anchoJugador
	 * @param altoJugador
	 * @return
	 */
	public Rectangle getBordes(final int posX, final int posY, final int anchoJugador, final int altoJugador) {
		int x = MARGEN_X - posX + anchoJugador;
		int y = MARGEN_Y - posY + altoJugador;
		int ancho = this.ancho * Constantes.LADO_SPRITE - anchoJugador * 2;
		int alto = this.alto * Constantes.LADO_SPRITE - altoJugador * 2;
		return new Rectangle(x, y, ancho, alto);
	}

	/**
	 * Método que devuelve la posición inicial del jugador.
	 * 
	 * @return posicionInicial Point
	 */
	public Point getPosicionInicial() {
		return posicionInicial;
	}

	/**
	 * Método que devuelve la referencia al siguiente mapa.
	 * 
	 * @return siguienteMapa String
	 */
	public String getSiguienteMapa() {
		return siguienteMapa;
	}

	/**
	 * Método que devuelve el rectangulo de la salida del mapa.
	 * 
	 * @return zonaSalida Rectangle
	 */
	public Rectangle getZonaSalida() {
		return zonaSalida;
	}

	/**
	 * Método que devuelve la ruta del mapa actual.
	 * 
	 * @return ruta String
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * Método que quita la conversación y la zona de conversación de la lista de
	 * conversacaciones.
	 * 
	 * @param i
	 */
	public void quitarConversacion(int i) {
		conversaciones.remove(i);
		zonaConversaciones.remove(i);
		punteroConversacion.remove(i);
	}

	/**
	 * Método que quita el combate y la zona de combate de la lista de combates.
	 * 
	 * @param i
	 */
	public void quitarCombate(int i) {
		combates.remove(i);
		zonaCombates.remove(i);
		punteroCombates.remove(i);
	}

	/**
	 * Método que devuelve la lista con las zonas de conversaciones.
	 * 
	 * @return zonaConversaciones ArrayList{Rectangle}
	 */
	public ArrayList<Rectangle> getZonaConversaciones() {
		return zonaConversaciones;
	}

	/**
	 * Método que devuelve la lista con las zonas de combates.
	 * 
	 * @return zonaCombates ArrayList{Rectangle}
	 */
	public ArrayList<Rectangle> getZonaCombates() {
		return zonaCombates;
	}

	/**
	 * Método que devuelve la lista con los punteros de referencias para seleccionar el
	 * combate.
	 * 
	 * @return punteroCombates ArrayList{Integer}
	 */
	public ArrayList<Integer> getPunteroCombates() {
		return punteroCombates;
	}

	/**
	 * Método que devuelve la lista con los punteros de referencias para seleccionar la
	 * cpnversación.
	 * 
	 * @return punteroConversaciones ArrayList{Integer}
	 */
	public ArrayList<Integer> getPunteroConversacion() {
		return punteroConversacion;
	}
}
