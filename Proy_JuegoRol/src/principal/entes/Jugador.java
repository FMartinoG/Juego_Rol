package principal.entes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.control.GestorControles;
import principal.mapas.Mapa;
import principal.sprites.HojaSprites;

public class Jugador {

	private double posicionX;
	private double posicionY;

	private double velocidadAndando = 1;
	private double velocidadActual = 1;

	private final int ANCHO_JUGADOR = 32;
	private final int ALTO_JUGADOR = 32;

	private int direccion;

	private HojaSprites hs;

	private BufferedImage imagenActual;

	private boolean enMovimiento;

	private int animacion;
	private int estado;

	private Mapa mapa;

	private final Rectangle LIMITE_ARRIBA = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2),
			(Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4), ANCHO_JUGADOR, 1);
	private final Rectangle LIMITE_ABAJO = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2),
			(Constantes.ALTO_VENTANA / 2) + (ALTO_JUGADOR / 2), ANCHO_JUGADOR, 1);
	private final Rectangle LIMITE_IZ = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2),
			(Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4), 1, (ALTO_JUGADOR / 4) + (ALTO_JUGADOR / 2));
	private final Rectangle LIMITE_DER = new Rectangle((Constantes.ANCHO_VENTANA / 2) + (ANCHO_JUGADOR / 2),
			(Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4), 1, (ALTO_JUGADOR / 4) + (ALTO_JUGADOR / 2));

	private double resistencia = 600;

	public Jugador(Mapa mapa) {
		posicionX = mapa.getPosicionInicial().x;
		posicionY = mapa.getPosicionInicial().y;
		direccion = 0;
		hs = new HojaSprites(Constantes.HOJA_PERSONAJE_1, Constantes.LADO_SPRITE, false);
		imagenActual = hs.getSprite(0, 0).getImagen();
		enMovimiento = false;
		animacion = 0;
		estado = 0;
		this.mapa = mapa;
	}

	public void actualizar() {
		comprobarCorriendo();
		cambiarAnimacionEstado();
		enMovimiento = false;
		determinarDireccion();
		animar();
	}

	private void animar() {
		if (!enMovimiento) {
			estado = 0;
			animacion = 0;
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
		} else {
			switch (direccion) {
			case 0:
				imagenActual = hs.getSprite(estado, 1).getImagen();
				break;
			case 1:
				imagenActual = hs.getSprite((estado + 2), 1).getImagen();
				break;
			case 2:
				imagenActual = hs.getSprite((estado + 4), 1).getImagen();
				break;
			case 3:
				imagenActual = hs.getSprite((estado + 6), 1).getImagen();
				break;
			default:
				break;
			}
		}

	}

	private void determinarDireccion() {
		final int velocidadX = evaluarVelocidadX();
		final int velocidadY = evaluarVelocidadY();

		if (velocidadX == 0 && velocidadY == 0) {
			return;
		} else if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)) {
			mover(velocidadX, velocidadY);
		} else {
			compararTeclas(velocidadX, velocidadY);
		}
	}

	private void compararTeclas(int velocidadX, int velocidadY) {
		if (velocidadX == -1 && velocidadY == -1) {
			if (GestorControles.TECLADO.izquierda.getUltimaPulsacion() > GestorControles.TECLADO.arriba
					.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == -1 && velocidadY == 1) {
			if (GestorControles.TECLADO.izquierda.getUltimaPulsacion() > GestorControles.TECLADO.abajo
					.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == 1 && velocidadY == -1) {
			if (GestorControles.TECLADO.derecha.getUltimaPulsacion() > GestorControles.TECLADO.arriba
					.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == 1 && velocidadY == 1) {
			if (GestorControles.TECLADO.derecha.getUltimaPulsacion() > GestorControles.TECLADO.abajo
					.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
	}

	private void mover(int velocidadX, int velocidadY) {
		enMovimiento = true;

		cambiarDireccion(velocidadX, velocidadY);

		if (!fueraMapa(velocidadX, velocidadY)) {
			if (velocidadX == -1 && !colisionIzquierda(velocidadX))
				posicionX += velocidadX * velocidadActual;
			if (velocidadX == 1 && !colisionDerecha(velocidadX))
				posicionX += velocidadX * velocidadActual;
			if (velocidadY == -1 && !colisionArriba(velocidadY))
				posicionY += velocidadY * velocidadActual;
			if (velocidadY == 1 && !colisionAbajo(velocidadY))
				posicionY += velocidadY * velocidadActual;
		}
	}

	private void cambiarDireccion(int velocidadX, int velocidadY) {
		if (velocidadX == -1) {
			direccion = 2;
		} else if (velocidadX == 1) {
			direccion = 3;
		}

		if (velocidadY == -1) {
			direccion = 1;
		} else if (velocidadY == 1) {
			direccion = 0;
		}
	}

	private int evaluarVelocidadX() {
		int velocidadX = 0;
		if (GestorControles.TECLADO.izquierda.isPulsada() && !GestorControles.TECLADO.derecha.isPulsada()) {
			velocidadX = -1;
		} else if (!GestorControles.TECLADO.izquierda.isPulsada() && GestorControles.TECLADO.derecha.isPulsada()) {
			velocidadX = 1;
		}
		return velocidadX;
	}

	private int evaluarVelocidadY() {
		int velocidadY = 0;
		if (GestorControles.TECLADO.arriba.isPulsada() && !GestorControles.TECLADO.abajo.isPulsada()) {
			velocidadY = -1;
		} else if (!GestorControles.TECLADO.arriba.isPulsada() && GestorControles.TECLADO.abajo.isPulsada()) {
			velocidadY = 1;
		}
		return velocidadY;
	}

	private void cambiarAnimacionEstado() {
		if (GestorControles.TECLADO.corriendo) {
			if (animacion < 30) {
				++animacion;
			} else {
				animacion = 0;
			}

			if (animacion < 15) {
				estado = 0;
			} else
				estado = 1;
		} else {
			if (animacion < 60) {
				++animacion;
			} else {
				animacion = 0;
			}

			if (animacion < 30) {
				estado = 0;
			} else
				estado = 1;
		}
	}

	public void dibujar(Graphics g) {
		final int CENTRO_X = (Constantes.ANCHO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		final int CENTRO_Y = (Constantes.ALTO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		g.drawImage(imagenActual, CENTRO_X, CENTRO_Y, null);
	}

	private boolean fueraMapa(final int velocidadX, final int velocidadY) {
		int posFuturaX = (int) posicionX + velocidadX * (int) velocidadActual;
		int posFuturaY = (int) posicionY + velocidadY * (int) velocidadActual;
		Rectangle bordesMapa = mapa.getBordes(posFuturaX, posFuturaY, ANCHO_JUGADOR, ALTO_JUGADOR);

		final boolean fuera;

		if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa)
				|| LIMITE_IZ.intersects(bordesMapa) || LIMITE_DER.intersects(bordesMapa))
			fuera = false;
		else
			fuera = true;

		return fuera;
	}

	private boolean colisionArriba(final int velocidadY) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x;
			int origenY = area.y + velocidadY * (int) velocidadActual + 3 * (int) velocidadActual;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE,
					Constantes.LADO_SPRITE);
			if (LIMITE_ARRIBA.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	private boolean colisionAbajo(final int velocidadY) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x;
			int origenY = area.y + velocidadY * (int) velocidadActual - 3 * (int) velocidadActual;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE,
					Constantes.LADO_SPRITE);
			if (LIMITE_ABAJO.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	private boolean colisionIzquierda(final int velocidadX) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x + velocidadX * (int) velocidadActual + 3 * (int) velocidadActual;
			int origenY = area.y;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE,
					Constantes.LADO_SPRITE);
			if (LIMITE_IZ.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	private boolean colisionDerecha(final int velocidadX) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x + velocidadX * (int) velocidadActual - 3 * (int) velocidadActual;
			int origenY = area.y;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE,
					Constantes.LADO_SPRITE);
			if (LIMITE_DER.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	private void comprobarCorriendo() {
		if (GestorControles.TECLADO.corriendo && resistencia > 0) {
			velocidadActual = 2 * velocidadAndando;
			--resistencia;

		} else {
			velocidadActual = velocidadAndando;
			if (resistencia < 600)
				resistencia += 0.5;
		}
	}

	public double getPosicionX() {
		return posicionX;
	}
	
	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}
	
	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

	public double getResistencia() {
		return resistencia;
	}
	
	public Rectangle getLIMITE_ABAJO() {
		return LIMITE_ABAJO;
	}
	
	public Rectangle getLIMITE_ARRIBA() {
		return LIMITE_ARRIBA;
	}
	
	public Rectangle getLIMITE_DER() {
		return LIMITE_DER;
	}
	
	public Rectangle getLIMITE_IZ() {
		return LIMITE_IZ;
	}
	
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
