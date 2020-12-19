package juego.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import juego.Constantes;
import juego.GestorPrincipal;
import juego.control.Controles;
import juego.maquinaEstado.GestorEstados;

/**
 * Clase encargada de recibir los diferentes dibujos de todos los elementos y
 * dibujarlos juntos.
 * 
 * @author Fernando Martino
 *
 */
public class SuperficieDeDibujo extends Canvas {
	private static final long serialVersionUID = -2303469561959410099L;

	private int ancho;
	private int alto;

	public SuperficieDeDibujo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		// Cuando el cursor este dentro será invisible porque se ha creado así el cursor.
		setCursor(Controles.RATON.getCursor());
		// No forzará el repintado
		setIgnoreRepaint(true);
		// Da las medidas para el canvas
		setPreferredSize(new Dimension(ancho, alto));
		// Se le proporciona el teclado
		addKeyListener(Controles.TECLADO);
		// Permite que se pueda hacer focus dentro.
		setFocusable(true);
		// Cuando se inicia el canvas se le da foco.
		requestFocus();
	}

	public void dibujar(final GestorEstados ge) {
		// Crea un buffer que va a dibujar cosas en el canvas.
		BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(1);
			return;
		}

		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		// Solo pintará entre actualizaciones de la pantalla
		Toolkit.getDefaultToolkit().sync();

		// Dibuja todo el fondo de negro
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Constantes.ANCHO_PANTALLA_AMPLIADA, Constantes.ALTO_PANTALLA_AMPLIADA);

		if (Constantes.factorEscaladoX != 1 || Constantes.factorEscaladoY != 1)
			g.scale(Constantes.factorEscaladoX, Constantes.factorEscaladoY);

		// Dibuja el mapa
		ge.dibujar(g);

		g.setColor(Color.WHITE);
		if (Controles.TECLADO.FPSMostrado) {
			g.drawString("APS: " + GestorPrincipal.getAps(), 10, 15);
			g.drawString("FPS: " + GestorPrincipal.getFps(), 10, 30);
		}

		// Borra todo lo almacenado en g para guardar la siguiente imagen y no se llene
		// la memoria
		g.dispose();

		buffer.show();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
