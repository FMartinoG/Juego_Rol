package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.control.GestorControles;
import principal.maquinaEstado.GestorEstados;

public class SuperficieDeDibujo extends Canvas {
	private static final long serialVersionUID = -2303469561959410099L;

	private int ancho;
	private int alto;

	public SuperficieDeDibujo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		setCursor(GestorControles.RATON.getCursor());
		// No forzará el repintado
		setIgnoreRepaint(true);
		// Da las medidas para el canvas
		setPreferredSize(new Dimension(ancho, alto));
		// Se le proporciona el teclado
		addKeyListener(GestorControles.TECLADO);
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

		Graphics g = buffer.getDrawGraphics();
		// Solo pintará entre actualizaciones de la pantalla
		Toolkit.getDefaultToolkit().sync();

		// Dibuja todo el fondo
		g.fillRect(0, 0, ancho, alto);

		// Dibuja el mapa
		ge.dibujar(g);

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
