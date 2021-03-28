package juego.herramientas;

import juego.Constantes;
import juego.sprites.HojaSprites;

public class SeleccionadorHojaSprite {

	public static HojaSprites seleccionarHojaSprite(String textoHojas) {
		HojaSprites hs = null;
		switch (textoHojas) {
		case "0":
			hs = new HojaSprites(Constantes.HOJA_TEXTURAS_1, 32, true);
			break;
		case "1":
			hs = new HojaSprites(Constantes.TEXTURAS_BOSQUE_1, 32, true);
			break;
		default:
			break;
		}
		return hs;
	}
}
