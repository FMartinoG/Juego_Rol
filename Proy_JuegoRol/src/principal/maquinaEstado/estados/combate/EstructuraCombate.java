package principal.maquinaEstado.estados.combate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import principal.Constantes;
import principal.control.Controles;

public class EstructuraCombate {

	private boolean enCombate;

	private int opcion;

	private OpcionCombate[] opciones;
	private OpcionCombate seleccionado;

	private OpcionCombate[] opcionesAtaque;
	private OpcionCombate seleccionadoAtaque;

	private double puntero;

	public EstructuraCombate() {
		enCombate = true;
		puntero = 0;
		opcion = 0;
		opciones = new OpcionCombate[4];
		opciones[0] = new OpcionCombate("Ataque Físico", new Rectangle(40, 290, 100, 40));
		opciones[1] = new OpcionCombate("Magia", new Rectangle(190, 290, 100, 40));
		opciones[2] = new OpcionCombate("Objeto", new Rectangle(340, 290, 100, 40));
		opciones[3] = new OpcionCombate("Huir", new Rectangle(490, 290, 100, 40));

		seleccionado = opciones[(int) puntero];
	}

	public void actualizar() {
		if (Controles.TECLADO.izdaMenu && puntero > 0) {
			puntero -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && puntero < 3) {
			puntero += 0.4;
		}

		if (opcion == 0) {
			seleccionado = opciones[(int) puntero];
			if (Controles.TECLADO.seleccion) {
				opcion = (int) puntero;
			}
		}

		if (opcion == 3) {
			enCombate = false;
		}

	}

	public void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.setColor(Color.gray);
		g.fillRect(0, 100, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.setColor(Color.black);
		g.fillRect(0, 260, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA - 260);

		g.setColor(Color.white);
		g.fillRoundRect(5, 265, Constantes.ANCHO_VENTANA - 10, Constantes.ALTO_VENTANA - 270, 40, 40);

		if (opcion == 0) {
			for (OpcionCombate o : opciones) {
				if (o == seleccionado)
					o.dibujarEtiquetaActiva(g);
				else
					o.dibujarEtiquetaInactiva(g);
			}
		}
	}

	public boolean isEnCombate() {
		return enCombate;
	}

}
