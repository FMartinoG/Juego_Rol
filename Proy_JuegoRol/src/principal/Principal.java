package principal;

public class Principal {

	public static void main(String[] args) {
		final String TITULO = "Juego";

		GestorPrincipal g = new GestorPrincipal(TITULO, Constantes.ANCHO_PANTALLA_AMPLIADA, Constantes.ALTO_PANTALLA_AMPLIADA);

		g.iniciarJuego();
		g.iniciarBuclePrincipal();
	}
}
