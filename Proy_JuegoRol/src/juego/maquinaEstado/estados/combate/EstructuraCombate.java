package juego.maquinaEstado.estados.combate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import juego.Constantes;
import juego.control.Controles;
import juego.herramientas.CargadorRecursos;

public class EstructuraCombate {
	
	private Image personaje;
	private Image enemigo;

	private boolean enCombate;

	private int opcion;

	private OpcionCombate[] opciones;
	private OpcionCombate seleccionado;

	private OpcionCombate[] opcionesAtaque;
	private OpcionCombate seleccionadoAtaque;

	private double punteroPrincipal;
	private double punteroAtaque;

	public EstructuraCombate(Image personaje, Image enemigo) {
		this.personaje = personaje;
		this.enemigo = enemigo;
		
		enCombate = true;
		opcion = 0;

		inicializarPrincipal();
		inicializarAtaque();

	}

	private void inicializarPrincipal() {
		punteroPrincipal = 0;
		opciones = new OpcionCombate[4];
		opciones[0] = new OpcionCombate("Ataque Físico", new Rectangle(40, 290, 100, 40));
		opciones[1] = new OpcionCombate("Magia", new Rectangle(190, 290, 100, 40));
		opciones[2] = new OpcionCombate("Objeto", new Rectangle(340, 290, 100, 40));
		opciones[3] = new OpcionCombate("Huir", new Rectangle(490, 290, 100, 40));

		seleccionado = opciones[(int) punteroPrincipal];
	}

	private void inicializarAtaque() {
		punteroAtaque = 0;
		opcionesAtaque = new OpcionCombate[4];
		opcionesAtaque[0] = new OpcionCombate("Ataque Rápido", new Rectangle(40, 290, 100, 40));
		opcionesAtaque[1] = new OpcionCombate("Ataque Normal", new Rectangle(190, 290, 100, 40));
		opcionesAtaque[2] = new OpcionCombate("Ataque Fuerte", new Rectangle(340, 290, 100, 40));
		opcionesAtaque[3] = new OpcionCombate("Ataque Cargado", new Rectangle(490, 290, 100, 40));

		seleccionadoAtaque = opcionesAtaque[0];
	}

	public void actualizar() {
		if (opcion == 0)
			actualizarPrincipal();
		else if (opcion == 1)
			actualizarAtaque();
	}

	private void actualizarPrincipal() {
		if (Controles.TECLADO.izdaMenu && punteroPrincipal > 0) {
			punteroPrincipal -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && punteroPrincipal < 3) {
			punteroPrincipal += 0.2;
		}

		seleccionado = opciones[(int) punteroPrincipal];
		if (Controles.TECLADO.seleccion)
			opcion = (int) punteroPrincipal + 1;

		if (opcion == 4)
			enCombate = false;

	}

	private void actualizarAtaque() {
		if (Controles.TECLADO.izdaMenu && punteroAtaque > 0) {
			punteroAtaque -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && punteroAtaque < 3) {
			punteroAtaque += 0.2;
		}

		seleccionadoAtaque = opcionesAtaque[(int) punteroAtaque];
		if (Controles.TECLADO.bt_Escape)
			opcion = 0;

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
		
		g.drawImage(enemigo, 75, 20, null);
		g.drawImage(personaje, 400, 40, null);

		if (opcion == 0) {
			dibujarPrincipal(g);
		}
		if (opcion == 1) {
			dibujarAtaque(g);
		}
	}

	private void dibujarPrincipal(Graphics g) {
		for (OpcionCombate o : opciones) {
			if (o == seleccionado)
				o.dibujarEtiquetaActiva(g);
			else
				o.dibujarEtiquetaInactiva(g);
		}
	}

	private void dibujarAtaque(Graphics g) {
		for (OpcionCombate o : opcionesAtaque) {
			if (o == seleccionadoAtaque)
				o.dibujarEtiquetaActiva(g);
			else
				o.dibujarEtiquetaInactiva(g);
		}
	}

	public boolean isEnCombate() {
		return enCombate;
	}

}
