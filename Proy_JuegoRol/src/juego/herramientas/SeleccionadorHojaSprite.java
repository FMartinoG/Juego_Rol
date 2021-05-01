package juego.herramientas;

import juego.Constantes;
import juego.sprites.HojaSprites;

/**
 * clase encargada de seleccionar la hoja de sprites que debe mostrar el mapa.
 * 
 * @author Fernando Martino
 *
 */
public class SeleccionadorHojaSprite {

	/**
	 * Método que recibe la referencia que hace el mapa a la hoja de sprites y
	 * devuelve la hoja adecuada.
	 * 
	 * @param textoHojas String - Referencia a la hoja de sprites.
	 * @return hoja HojaSprites - Hoja de sprites seleccionada.
	 */
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
			hs = new HojaSprites(Constantes.TEXTURAS_ENTRADA_CAPITAL, 32, true);
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
		case "7":
			hs = new HojaSprites(Constantes.TEXTURAS_PUEBLO_2, 32, true);
			break;
		case "8":
			hs = new HojaSprites(Constantes.TEXTURAS_CASA_GOBERNADOR_PLANTA_BAJA, 32, true);
			break;
		case "9":
			hs = new HojaSprites(Constantes.TEXTURAS_CASA_GOBERNADOR_HABITACION, 32, true);
			break;
		case "10":
			hs = new HojaSprites(Constantes.TEXTURAS_CASA_GOBERNADOR_HABITACION_2, 32, true);
			break;
		case "11":
			hs = new HojaSprites(Constantes.TEXTURAS_ENTRADA_CAPITAL_2, 32, true);
			break;
		case "12":
			hs = new HojaSprites(Constantes.TEXTURAS_CIUDAD_1, 32, true);
			break;
		case "13":
			hs = new HojaSprites(Constantes.TEXTURAS_CIUDAD_2, 32, true);
			break;
		default:
			break;
		}
		return hs;
	}
}
