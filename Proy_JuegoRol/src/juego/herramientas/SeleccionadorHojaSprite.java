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
		case "2":
			hs = new HojaSprites(Constantes.TEXTURAS_ENTRADA_CUEVA, 32, true);
			break;
		case "3":
			hs = new HojaSprites(Constantes.TEXTURAS_ENTRADA_CUEVA_2, 32, true);
			break;
		case "4":
			hs = new HojaSprites(Constantes.TEXTURAS_ENTRADA_CASTILLO, 32, true);
			break;
		case "5":
			hs = new HojaSprites(Constantes.TEXTURAS_MUNDO, 32, true);
			break;
		case "6":
			hs = new HojaSprites(Constantes.TEXTURAS_PUEBLO, 32, true);
			break;
		default:
			break;
		}
		return hs;
	}
}
