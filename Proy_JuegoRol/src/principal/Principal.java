package principal;

public class Principal {

	public static void main(String[] args) {
		final String TITULO = "Juego";

		GestorPrincipal g = new GestorPrincipal(TITULO, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.iniciarJuego();
		g.iniciarBuclePrincipal();
	}
}
