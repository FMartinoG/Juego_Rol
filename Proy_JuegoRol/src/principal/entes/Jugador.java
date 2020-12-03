package principal.entes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.control.GestorControles;
import principal.sprites.HojaSprites;

public class Jugador {

	private double posicionX;
	private double posicionY;

	private int estado;

	private int direccion;

	private HojaSprites hs;

	private BufferedImage imagenActual;

	public Jugador(double posX, double posY) {
		posicionX = posX;
		posicionY = posY;
		direccion = 0;
		hs = new HojaSprites(Constantes.HOJA_PERSONAJE_1, Constantes.LADO_SPRITE, false);
		imagenActual = hs.getSprite(0, 0).getImagen();
		estado = 0;
	}

	public void actualizar() {
		boolean enMovimiento = false;
		if (GestorControles.TECLADO.isArriba()) {
			direccion = 1;
			enMovimiento = true;
			ponerImagenMovimiento();
			posicionY -= Constantes.VELOCIDAD_MOVIMIENTO;
		}
		if (GestorControles.TECLADO.isAbajo()) {
			direccion = 0;
			enMovimiento = true;
			ponerImagenMovimiento();
			posicionY += Constantes.VELOCIDAD_MOVIMIENTO;
		}
		if (GestorControles.TECLADO.isIzquierda()) {
			direccion = 2;
			enMovimiento = true;
			ponerImagenMovimiento();
			posicionX -= Constantes.VELOCIDAD_MOVIMIENTO;
		}
		if (GestorControles.TECLADO.isDerecha()) {
			direccion = 3;
			enMovimiento = true;
			ponerImagenMovimiento();
			posicionX += Constantes.VELOCIDAD_MOVIMIENTO;
		}
		if (!enMovimiento)
			ponerImagenesParado();
	}

	private void ponerImagenesParado() {
		switch (direccion) {
		case 0:
			imagenActual = hs.getSprite(0, 0).getImagen();
			break;
		case 1:
			imagenActual = hs.getSprite(1, 0).getImagen();
			break;
		case 2:
			imagenActual = hs.getSprite(2, 0).getImagen();
			break;
		case 3:
			imagenActual = hs.getSprite(3, 0).getImagen();
			break;
		default:
			break;
		}
	}

	private void ponerImagenMovimiento() {
		++estado;
		if (estado >= 1000) {
			estado = 0;
		}

		switch (direccion)
		{
		case 0:
			if (estado % 50 < 25)
				imagenActual = hs.getSprite(0, 1).getImagen();
			else
				imagenActual = hs.getSprite(1, 1).getImagen();
			break;
		case 1:
			if (estado % 50 < 25)
				imagenActual = hs.getSprite(2, 1).getImagen();
			else
				imagenActual = hs.getSprite(3, 1).getImagen();
			break;
		case 2:
			if (estado % 50 < 25)
				imagenActual = hs.getSprite(4, 1).getImagen();
			else
				imagenActual = hs.getSprite(5, 1).getImagen();
			break;
		case 3:
			if (estado % 50 < 25)
				imagenActual = hs.getSprite(6, 1).getImagen();
			else
				imagenActual = hs.getSprite(7, 1).getImagen();
			break;
		default:
			break;
		}
	}

	public void dibujar(Graphics g) {
		final int CENTRO_X = (Constantes.ANCHO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		final int CENTRO_Y = (Constantes.ALTO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		g.drawImage(imagenActual, CENTRO_X, CENTRO_Y, null);

	}

	public double getPosicionX() {
		return posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}
}
