package juego.entes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import juego.Constantes;
import juego.control.Controles;
import juego.mapas.Mapa;
import juego.sprites.HojaSprites;

/**
 * Clase encargada de dibujar y controlar al jugador.
 * 
 * @author Fernando Martino
 *
 */
public class Jugador {

	private Estadisticas estadisticas;

	private double posicionX;
	private double posicionY;

	private double velocidadAndando = 1;
	private double velocidadActual = velocidadAndando;

	private final int ANCHO_JUGADOR = 32;
	private final int ALTO_JUGADOR = 32;

	private int direccion;

	private HojaSprites hs;

	private BufferedImage imagenActual;
	private String imagenCombate;

	private boolean enMovimiento;

	private int animacion;
	private int estado;

	private Mapa mapa;

	private final Rectangle LIMITE_ARRIBA = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2), (Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4),
			ANCHO_JUGADOR, 1);
	private final Rectangle LIMITE_ABAJO = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2), (Constantes.ALTO_VENTANA / 2) + (ALTO_JUGADOR / 2),
			ANCHO_JUGADOR, 1);
	private final Rectangle LIMITE_IZ = new Rectangle((Constantes.ANCHO_VENTANA / 2) - (ANCHO_JUGADOR / 2), (Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4), 1,
			(ALTO_JUGADOR / 4) + (ALTO_JUGADOR / 2));
	private final Rectangle LIMITE_DER = new Rectangle((Constantes.ANCHO_VENTANA / 2) + (ANCHO_JUGADOR / 2), (Constantes.ALTO_VENTANA / 2) - (ALTO_JUGADOR / 4), 1,
			(ALTO_JUGADOR / 4) + (ALTO_JUGADOR / 2));

	/**
	 * Contructor de la clase jugador
	 * 
	 * @param mapa
	 *            Mapa
	 */
	public Jugador(Mapa mapa) {
		estadisticas = new Estadisticas();

		posicionX = mapa.getPosicionInicial().x;
		posicionY = mapa.getPosicionInicial().y;
		direccion = 0;
		hs = new HojaSprites(Constantes.HOJA_PERSONAJE_1, Constantes.LADO_SPRITE, false);
		imagenActual = hs.getSprite(0, 0).getImagen();
		imagenCombate = Constantes.PERSONAJE;
		enMovimiento = false;
		animacion = 0;
		estado = 0;
		this.mapa = mapa;
	}

	/**
	 * Método encargado de actulizar al personaje en cada actualización .
	 */
	public void actualizar() {
		comprobarCorriendo();
		cambiarAnimacionEstado();
		enMovimiento = false;
		determinarDireccion();
		animar();
	}

	/**
	 * Método encargado de cambiar el sprite del personaje según su dirección o
	 * si está en movimiento.
	 */
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

	/**
	 * Método encargado de seleccionar la dirección en la que se mueve el
	 * personaje,
	 */
	private void determinarDireccion() {
		final int velocidadX = evaluarVelocidadX();
		final int velocidadY = evaluarVelocidadY();
		/*
		 * Si el personaje no se mueve no cambia nada. Si el jugador solo ha
		 * pulsado una tecla de movimiento, el personaje se mueve en esa
		 * dirección. Si el jugador ha pulsado más de una tecla de movimiento,
		 * el personaje se mueve en la última que haya pulsado.
		 * 
		 */
		if (velocidadX == 0 && velocidadY == 0) {
			return;
		} else if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)) {
			mover(velocidadX, velocidadY);
		} else {
			compararTeclas(velocidadX, velocidadY);
		}
	}

	/**
	 * Método encargado de comprobar cual tecla de movimiento se ha pulsado más
	 * recientemente, en el caso de que se hayan pulsado más de una a la vez.
	 * 
	 * @param velocidadX
	 * @param velocidadY
	 */
	private void compararTeclas(int velocidadX, int velocidadY) {
		if (velocidadX == -1 && velocidadY == -1) {
			if (Controles.TECLADO.izquierda.getUltimaPulsacion() > Controles.TECLADO.arriba.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == -1 && velocidadY == 1) {
			if (Controles.TECLADO.izquierda.getUltimaPulsacion() > Controles.TECLADO.abajo.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == 1 && velocidadY == -1) {
			if (Controles.TECLADO.derecha.getUltimaPulsacion() > Controles.TECLADO.arriba.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
		if (velocidadX == 1 && velocidadY == 1) {
			if (Controles.TECLADO.derecha.getUltimaPulsacion() > Controles.TECLADO.abajo.getUltimaPulsacion()) {
				mover(velocidadX, 0);
			} else {
				mover(0, velocidadY);
			}
		}
	}

	/**
	 * Método encargado de mover al personaje en la pantalla a la velocidad
	 * indicada.
	 * 
	 * @param velocidadX
	 * @param velocidadY
	 */
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

	/**
	 * Método encargado de cambiar la dirección en la que mira el personaje
	 * según su movimiento.
	 * 
	 * @param velocidadX
	 * @param velocidadY
	 */
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

	/**
	 * Método que comprueba si se pulsa el botón de correr y devuelve la
	 * velocidad a la que se mueve el personaje en el eje X.
	 * 
	 * @return velocidad
	 */
	private int evaluarVelocidadX() {
		int velocidadX = 0;
		if (Controles.TECLADO.izquierda.isPulsada() && !Controles.TECLADO.derecha.isPulsada()) {
			velocidadX = -1;
		} else if (!Controles.TECLADO.izquierda.isPulsada() && Controles.TECLADO.derecha.isPulsada()) {
			velocidadX = 1;
		}
		return velocidadX;
	}

	/**
	 * Método que comprueba si se pulsa el botón de correr y devuelve la
	 * velocidad a la que se mueve el personaje en el eje Y.
	 * 
	 * @return velocidad
	 */
	private int evaluarVelocidadY() {
		int velocidadY = 0;
		if (Controles.TECLADO.arriba.isPulsada() && !Controles.TECLADO.abajo.isPulsada()) {
			velocidadY = -1;
		} else if (!Controles.TECLADO.arriba.isPulsada() && Controles.TECLADO.abajo.isPulsada()) {
			velocidadY = 1;
		}
		return velocidadY;
	}

	/**
	 * Método encargado de hacer los cálculos para cambiar la imagen del
	 * personaje cuando se mueve.
	 */
	private void cambiarAnimacionEstado() {
		if (Controles.TECLADO.corriendo) {
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

	/**
	 * Método encargado de dibujar al personaje en la pantalla.
	 * 
	 * @param g
	 *            Graphics
	 */
	public void dibujar(Graphics g) {
		final int CENTRO_X = (Constantes.ANCHO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		final int CENTRO_Y = (Constantes.ALTO_VENTANA / 2) - (Constantes.LADO_SPRITE / 2);
		g.drawImage(imagenActual, CENTRO_X, CENTRO_Y, null);
	}

	/**
	 * Método que comprueba si el personaje está fuera del mapa o choca con el
	 * borde del mapa, para que no siga moviendose.
	 * 
	 * @param velocidadX
	 * @param velocidadY
	 * @return fueraMapa boolean.
	 */
	private boolean fueraMapa(final int velocidadX, final int velocidadY) {
		int posFuturaX = (int) posicionX + velocidadX * (int) velocidadActual;
		int posFuturaY = (int) posicionY + velocidadY * (int) velocidadActual;
		Rectangle bordesMapa = mapa.getBordes(posFuturaX, posFuturaY, ANCHO_JUGADOR, ALTO_JUGADOR);

		final boolean fuera;

		if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa) || LIMITE_IZ.intersects(bordesMapa) || LIMITE_DER.intersects(bordesMapa))
			fuera = false;
		else
			fuera = true;

		return fuera;
	}

	/**
	 * Método que comprueba si el borde superior del personaje choca con alguna
	 * zona del mapa por la que no puede ir
	 * 
	 * @param velocidadY
	 * @return colision boolean
	 */
	private boolean colisionArriba(final int velocidadY) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x;
			int origenY = area.y + velocidadY * (int) velocidadActual + 3 * (int) velocidadActual;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
			if (LIMITE_ARRIBA.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	/**
	 * Método que comprueba si el borde inferior del personaje choca con alguna
	 * zona del mapa por la que no puede ir
	 * 
	 * @param velocidadY
	 * @return colision boolean
	 */
	private boolean colisionAbajo(final int velocidadY) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x;
			int origenY = area.y + velocidadY * (int) velocidadActual - 3 * (int) velocidadActual;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
			if (LIMITE_ABAJO.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	/**
	 * Método que comprueba si el borde izquierdo del personaje choca con alguna
	 * zona del mapa por la que no puede ir
	 * 
	 * @param velocidadX
	 * @return colision boolean
	 */
	private boolean colisionIzquierda(final int velocidadX) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x + velocidadX * (int) velocidadActual + 3 * (int) velocidadActual;
			int origenY = area.y;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
			if (LIMITE_IZ.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	/**
	 * Método que comprueba si el borde derecho del personaje choca con alguna
	 * zona del mapa por la que no puede ir
	 * 
	 * @param velocidadX
	 * @return colision boolean
	 */
	private boolean colisionDerecha(final int velocidadX) {
		boolean colision = false;
		for (int i = 0; i < mapa.areasColision.size() && !colision; ++i) {
			final Rectangle area = mapa.areasColision.get(i);

			int origenX = area.x + velocidadX * (int) velocidadActual - 3 * (int) velocidadActual;
			int origenY = area.y;

			final Rectangle posicionFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
			if (LIMITE_DER.intersects(posicionFutura))
				colision = true;
		}
		return colision;
	}

	/**
	 * Método que comprueba si se está pulsando el botón de correr y cambia la
	 * velocidad.
	 */
	private void comprobarCorriendo() {
		if (Controles.TECLADO.corriendo) {
			velocidadActual = 2 * velocidadAndando;
		} else {
			velocidadActual = velocidadAndando;
		}
	}

	/**
	 * Método que devuelve la posición del personaje en el eje X de la ventana.
	 * 
	 * @return posicionX int.
	 */
	public double getPosicionX() {
		return posicionX;
	}

	/**
	 * Método que modifica la posición del personaje en el eje X de la ventana.
	 * 
	 * @param posicionX
	 */
	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	/**
	 * Método que devuelve la posición del personaje en el eje Y de la ventana.
	 * 
	 * @return posicionY int.
	 */
	public double getPosicionY() {
		return posicionY;
	}

	/**
	 * Método que modifica la posición del personaje en el eje Y de la ventana.
	 * 
	 * @param posicionY
	 */
	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

	/**
	 * Método que devuelve el limite inferior del personaje.
	 * 
	 * @return limite_abajo Rectangle
	 */
	public Rectangle getLIMITE_ABAJO() {
		return LIMITE_ABAJO;
	}

	/**
	 * Método que devuelve el limite superior del personaje.
	 * 
	 * @return limite_arriba Rectangle
	 */
	public Rectangle getLIMITE_ARRIBA() {
		return LIMITE_ARRIBA;
	}

	/**
	 * Método que devuelve el limite derecho del personaje.
	 * 
	 * @return limite_der Rectangle
	 */
	public Rectangle getLIMITE_DER() {
		return LIMITE_DER;
	}

	/**
	 * Método que devuelve el limite izquierdo del personaje.
	 * 
	 * @return limite_iz Rectangle
	 */
	public Rectangle getLIMITE_IZ() {
		return LIMITE_IZ;
	}

	/**
	 * Método que devuelve el mapa actual en el que está el personaje.
	 * 
	 * @return mapa Mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}

	/**
	 * Método que modifica el mapa en el que está el personaje.
	 * 
	 * @param mapa
	 */
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	/**
	 * Método que devuelve el objeto de estadísticas del personaje.
	 * 
	 * @return estadisticas Estadisticas.
	 */
	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	/**
	 * Método que modifica el objeto de estadisticas del personaje.
	 * 
	 * @param estadisticas
	 */
	public void setEstadisticas(Estadisticas estadisticas) {
		this.estadisticas = estadisticas;
	}

	/**
	 * Método que devuelve la imagen actual del personaje.
	 * @return imagenActual BufferedImage
	 */
	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	/**
	 * Método que devuelve la ruta de la imagen del personaje para los combates
	 * @return imagenCombate String
	 */
	public String getImagenCombate() {
		return imagenCombate;
	}

}
