package principal.mapas;

import java.awt.Graphics;
import java.util.ArrayList;

import principal.Constantes;
import principal.herramientas.CargadorRecursos;
import principal.sprites.HojaSprites;
import principal.sprites.Sprite;

public class Mapa {

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

	public Mapa(final String ruta) {
		String textoMapa = CargadorRecursos.leerFicheroTexto(ruta);
		leerMapa(textoMapa);
	}

	public void dibujar(Graphics g, int posX, int posY) {
		int ladoSprite = Constantes.LADO_SPRITE;
		for (int i = 0; i < alto; ++i) {
			for (int j = 0; j < ancho; ++j) {
				
				int posxInicial = 192 + j * ladoSprite - posX;
				int posYInicial = i * ladoSprite - posY;
				// Para que empiece en 0,0
				/*
				int posxInicial = MARGEN_X + j * ladoSprite - posX;
				int posYInicial = MARGEN_Y + i * ladoSprite - posY;
				*/
				
				int puntero = mapaSprites[j + i * ancho];
				g.drawImage(sprites[puntero].getImagen(), posxInicial, posYInicial, null);
				
			}
		}
	}

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
	}

	private void guardarHojas(String[] textoHojas) {
		hojas = new HojaSprites[textoHojas.length];
		numeroHojasSprites = new int[textoHojas.length];
		for (int i = 0; i < textoHojas.length; ++i) {
			numeroHojasSprites[i] = Integer.parseInt(textoHojas[i]);
			switch (textoHojas[i]) {
			case "0":
				hojas[i] = new HojaSprites(Constantes.HOJA_TEXTURAS_1, 32, true);
				break;

			default:
				break;
			}
		}
	}

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
			sprites[i] = hojas[puntero].getSprite(Integer.parseInt(separacionTextoSprite[3]),
					Integer.parseInt(separacionTextoSprite[2]));
		}

	}

	private void guardarColisiones(String textoColisiones) {
		mapaColisiones = new boolean[textoColisiones.length()];
		for (int i = 0; i < textoColisiones.length(); ++i) {
			if (textoColisiones.charAt(i) == '0')
				mapaColisiones[i] = false;
			else
				mapaColisiones[i] = true;
		}
	}

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
}
