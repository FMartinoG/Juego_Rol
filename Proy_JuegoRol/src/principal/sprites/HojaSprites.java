package principal.sprites;

import java.awt.image.BufferedImage;

import principal.herramientas.CargadorRecursos;

public class HojaSprites {

	final private int ANCHO_HOJA_PX;
	final private int ALTO_HOJA_PX;

	final private int ANCHO_HOJA_SPRITES;
	final private int ALTO_HOJA_SPRITES;

	final private int ANCHO_SPRITE;
	final private int ALTO_SPRITE;

	final private Sprite[] SPRITES;

	public HojaSprites(final String ruta, final int spriteSize, boolean opaco) {
		final BufferedImage IMAGEN;

		if (opaco) {
			IMAGEN = CargadorRecursos.cargarImagenOpaca(ruta);
		} else {
			IMAGEN = CargadorRecursos.cargarImagenTranslucida(ruta);
		}

		ANCHO_HOJA_PX = IMAGEN.getWidth();
		ALTO_HOJA_PX = IMAGEN.getHeight();

		ANCHO_HOJA_SPRITES = ANCHO_HOJA_PX / spriteSize;
		ALTO_HOJA_SPRITES = ALTO_HOJA_PX / spriteSize;

		ANCHO_SPRITE = spriteSize;
		ALTO_SPRITE = spriteSize;

		SPRITES = new Sprite[ANCHO_HOJA_SPRITES * ALTO_HOJA_SPRITES];

		extraerSprites(IMAGEN);
	}

	public HojaSprites(final String ruta, final int anchoSprite, final int altoSprite, boolean opaco) {
		final BufferedImage IMAGEN;

		if (opaco) {
			IMAGEN = CargadorRecursos.cargarImagenOpaca(ruta);
		} else {
			IMAGEN = CargadorRecursos.cargarImagenTranslucida(ruta);
		}

		ANCHO_HOJA_PX = IMAGEN.getWidth();
		ALTO_HOJA_PX = IMAGEN.getHeight();

		ANCHO_HOJA_SPRITES = ANCHO_HOJA_PX / anchoSprite;
		ALTO_HOJA_SPRITES = ALTO_HOJA_PX / altoSprite;

		ANCHO_SPRITE = anchoSprite;
		ALTO_SPRITE = altoSprite;

		SPRITES = new Sprite[ANCHO_HOJA_SPRITES * ALTO_HOJA_SPRITES];

		extraerSprites(IMAGEN);
	}

	private void extraerSprites(final BufferedImage imagen) {
		for (int i = 0; i < ALTO_HOJA_SPRITES; ++i) {
			for (int j = 0; j < ANCHO_HOJA_SPRITES; ++j) {
				final int posicionX = j * ANCHO_SPRITE;
				final int posicionY = i * ALTO_SPRITE;

				SPRITES[j + i * ANCHO_HOJA_SPRITES] = new Sprite(
						imagen.getSubimage(posicionX, posicionY, ANCHO_SPRITE, ALTO_SPRITE));
			}
		}
	}
	
	public Sprite getSprite(final int indice) {
		return SPRITES[indice];
	}
	
	public Sprite getSprite(final int x, final int y) {
		return SPRITES[x + y * ANCHO_HOJA_SPRITES];
	}
}
