package juego.maquinaEstado.estados.combate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import juego.Constantes;
import juego.HUD.Barras;
import juego.HUD.Mensaje;
import juego.control.Controles;
import juego.entes.Enemigo;
import juego.entes.Jugador;
import juego.herramientas.CargadorRecursos;

public class EstructuraCombate {

	Jugador jugador;
	Enemigo enemigo;

	private Image imgPersonaje;
	private Image imgEnemigo;

	private boolean enCombate;
	private boolean huido, vencido, apaciguado;
	private boolean botonPulsado;
	private boolean dibujarAtaqueFisico, dibujarMagiaCura, dibujarMagiaFuego, dibujarMagiaHielo, dibujarMagiaRayo,
			dibujarReaccion, dibujarHuidaFallida;
	private int accionSeleccionada;

	private int ataqueFisico;
	private int ataqueMagico;

	private int opcion;

	private OpcionCombate[] opciones;
	private OpcionCombate seleccionado;

	private OpcionCombate[] opcionesAtaque;
	private OpcionCombate seleccionadoAtaque;

	private OpcionCombate[] opcionesMagia;
	private OpcionCombate seleccionadoMagia;

	private OpcionCombate[] opcionesAccion;
	private OpcionCombate seleccionadoAccion;

	private double punteroPrincipal;
	private double punteroAtaque;
	private double punteroMagia;
	private double punteroAccion;

	public EstructuraCombate(Jugador jugador, Enemigo enemigo) {
		this.jugador = jugador;
		this.enemigo = enemigo;

		imgPersonaje = CargadorRecursos.cargarImagenTranslucida(jugador.getImagenCombate());
		imgEnemigo = CargadorRecursos.cargarImagenTranslucida(enemigo.getImagen());

		botonPulsado = true;
		huido = apaciguado = vencido = false;

		enCombate = true;
		dibujarAtaqueFisico = dibujarMagiaCura = dibujarMagiaFuego = dibujarMagiaHielo = dibujarMagiaRayo = dibujarReaccion = dibujarHuidaFallida = false;
		ataqueFisico = ataqueMagico = 0;
		accionSeleccionada = -1;
		opcion = 0;

		inicializarPrincipal();
		inicializarAtaque();
		inicializarMagia();
		inicializarAccion();
	}

	private void inicializarPrincipal() {
		punteroPrincipal = 0;
		opciones = new OpcionCombate[4];
		opciones[0] = new OpcionCombate("Ataque Físico", new Rectangle(40, 290, 100, 40));
		opciones[1] = new OpcionCombate("Magia", new Rectangle(190, 290, 100, 40));
		opciones[2] = new OpcionCombate("Acción", new Rectangle(340, 290, 100, 40));
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

	private void inicializarMagia() {
		punteroMagia = 0;
		opcionesMagia = new OpcionCombate[4];
		opcionesMagia[0] = new OpcionCombate("Cura", new Rectangle(40, 290, 100, 40));
		opcionesMagia[1] = new OpcionCombate("Fuego", new Rectangle(190, 290, 100, 40));
		opcionesMagia[2] = new OpcionCombate("Hielo", new Rectangle(340, 290, 100, 40));
		opcionesMagia[3] = new OpcionCombate("Rayo", new Rectangle(490, 290, 100, 40));

		seleccionadoMagia = opcionesMagia[0];
	}

	private void inicializarAccion() {
		punteroAccion = 0;
		opcionesAccion = new OpcionCombate[enemigo.getAcciones().length];
		for (int i = 0; i < opcionesAccion.length; ++i)
			opcionesAccion[i] = new OpcionCombate(enemigo.getAcciones()[i],
					new Rectangle(40 + (i * 150), 290, 100, 40));

		seleccionadoAccion = opcionesAccion[0];
	}

	public void actualizar() {
		while (botonPulsado && Controles.TECLADO.seleccion) {
			System.out.println("Suelte el botón.");
		}
		botonPulsado = false;

		if (opcion == 0)
			actualizarPrincipal();
		else if (opcion == 1)
			actualizarAtaque();
		else if (opcion == 2)
			actualizarMagia();
		else if (opcion == 3)
			actualizarAccion();
	}

	private void actualizarPrincipal() {
		if (Controles.TECLADO.izdaMenu && punteroPrincipal > 0)
			punteroPrincipal -= 0.2;
		else if (Controles.TECLADO.drchaMenu && punteroPrincipal < 3)
			punteroPrincipal += 0.2;

		seleccionado = opciones[(int) punteroPrincipal];
		if (Controles.TECLADO.seleccion) {
			opcion = (int) punteroPrincipal + 1;
			botonPulsado = true;
		}

		if (opcion == 4) {
			huido = enemigo.intentarHuir();
			if (!huido)
				dibujarHuidaFallida = true;
		}

		if (!enemigo.estaVivo())
			vencido = true;

	}

	private void actualizarAtaque() {
		while (botonPulsado && Controles.TECLADO.seleccion) {
			System.out.println("Suelte el botón.");
		}
		botonPulsado = false;

		if (Controles.TECLADO.izdaMenu && punteroAtaque > 0) {
			punteroAtaque -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && punteroAtaque < 3) {
			punteroAtaque += 0.2;
		}

		seleccionadoAtaque = opcionesAtaque[(int) punteroAtaque];

		seleccionarAtaque();

		if (Controles.TECLADO.bt_Escape)
			opcion = 0;
	}

	private void seleccionarAtaque() {
		if (Controles.TECLADO.seleccion && seleccionadoAtaque == opcionesAtaque[0]) {
			realizarAtaqueFisico(50);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAtaque == opcionesAtaque[1]) {
			realizarAtaqueFisico(20);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAtaque == opcionesAtaque[2]) {
			realizarAtaqueFisico(150);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAtaque == opcionesAtaque[3]) {
			realizarAtaqueFisico(500);
			opcion = 0;
		}
	}

	private void actualizarMagia() {
		while (botonPulsado && Controles.TECLADO.seleccion) {
			System.out.println("Suelte el botón.");
		}
		botonPulsado = false;

		if (Controles.TECLADO.izdaMenu && punteroMagia > 0) {
			punteroMagia -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && punteroMagia < 3) {
			punteroMagia += 0.2;
		}

		seleccionadoMagia = opcionesMagia[(int) punteroMagia];

		seleccionarMagia();

		if (Controles.TECLADO.bt_Escape)
			opcion = 0;
	}

	private void seleccionarMagia() {
		if (Controles.TECLADO.seleccion && seleccionadoMagia == opcionesMagia[0]) {
			jugador.getEstadisticas().curar(20);
			dibujarMagiaCura = true;
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoMagia == opcionesMagia[1]) {
			realizarAtaqueMagico(20, 0);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoMagia == opcionesMagia[2]) {
			realizarAtaqueMagico(40, 1);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoMagia == opcionesMagia[3]) {
			realizarAtaqueMagico(20, 2);
			opcion = 0;
		}
	}

	private void actualizarAccion() {
		while (botonPulsado && Controles.TECLADO.seleccion) {
			System.out.println("Suelte el botón.");
		}
		botonPulsado = false;

		if (Controles.TECLADO.izdaMenu && punteroAccion > 0) {
			punteroAccion -= 0.2;
		} else if (Controles.TECLADO.drchaMenu && punteroAccion < 3) {
			punteroAccion += 0.2;
		}

		seleccionadoAccion = opcionesAccion[(int) punteroAccion];

		seleccionarAccion();

		if (Controles.TECLADO.bt_Escape)
			opcion = 0;
	}

	private void seleccionarAccion() {
		if (Controles.TECLADO.seleccion && seleccionadoAccion == opcionesAccion[0]) {
			realizarAccion(0);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAccion == opcionesAccion[1]) {
			realizarAccion(1);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAccion == opcionesAccion[2]) {
			realizarAccion(2);
			opcion = 0;
		} else if (Controles.TECLADO.seleccion && seleccionadoAccion == opcionesAccion[3]) {
			realizarAccion(3);
			opcion = 0;
		}
	}

	private void realizarAtaqueFisico(int n) {
		ataqueFisico = enemigo.recibirAtaqueFisico(n);
		dibujarAtaqueFisico = true;
	}

	private void realizarAtaqueMagico(int n, int elemento) {
		ataqueMagico = enemigo.recibirAtaqueMagico(n, elemento);
		switch (elemento) {
		case 0:
			dibujarMagiaFuego = true;
			break;
		case 1:
			dibujarMagiaHielo = true;
			break;
		case 2:
			dibujarMagiaRayo = true;
			break;
		default:
			break;
		}
	}

	private void realizarAccion(int n) {
		accionSeleccionada = n;
		dibujarReaccion = true;

		if (n == enemigo.getOrdenAcciones().get(0))
			enemigo.getOrdenAcciones().remove(0);
		if (enemigo.getOrdenAcciones().isEmpty())
			apaciguado = true;
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.setColor(Color.gray);
		g.fillRect(0, 100, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.setColor(Color.black);
		g.fillRect(0, 210, Constantes.ANCHO_VENTANA, Constantes.ALTO_VENTANA);

		g.setColor(Color.white);
		g.fillRoundRect(5, 265, Constantes.ANCHO_VENTANA - 10, Constantes.ALTO_VENTANA - 270, 40, 40);

		g.drawImage(imgPersonaje, 10, 220, null);

		Barras vida = new Barras(g, jugador, 60, 240);
		vida.dibujarBarraVidaCombate();

		Barras mana = new Barras(g, jugador, 270, 240);
		mana.dibujarBarraManaCombate();

		Barras exp = new Barras(g, jugador, 450, 240);
		exp.dibujarBarraExpCombate();

		g.drawImage(imgEnemigo, 250, 20, null);
		Barras vidaEnemigo = new Barras(g, enemigo, (Constantes.ANCHO_VENTANA / 2) - 100, 5);
		vidaEnemigo.dibujarBarraVidaEnemigo();

		if (opcion == 0)
			dibujarPrincipal(g);
		else if (opcion == 1)
			dibujarAtaque(g);
		else if (opcion == 2)
			dibujarMagia(g);
		else if (opcion == 3)
			dibujarAccion(g);

		if (dibujarAtaqueFisico)
			dibujarAtaqueFisico(g);
		if (dibujarMagiaCura)
			dibujarMagiaCura(g);
		if (dibujarMagiaFuego)
			dibujarMagiaFuego(g);
		if (dibujarMagiaHielo)
			dibujarMagiaHielo(g);
		if (dibujarMagiaRayo)
			dibujarMagiaRayo(g);
		if (dibujarReaccion)
			dibujarReaccion(g);
		if (dibujarHuidaFallida)
			dibujarHuidaFallida(g);

		if (huido || vencido || apaciguado)
			dibujarFinDeCombate(g);
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

	private void dibujarMagia(Graphics g) {
		for (OpcionCombate o : opcionesMagia) {
			if (o == seleccionadoMagia)
				o.dibujarEtiquetaActiva(g);
			else
				o.dibujarEtiquetaInactiva(g);
		}
	}

	private void dibujarAccion(Graphics g) {
		for (OpcionCombate o : opcionesAccion) {
			if (o == seleccionadoAccion)
				o.dibujarEtiquetaActiva(g);
			else
				o.dibujarEtiquetaInactiva(g);
		}
	}

	private void dibujarAtaqueFisico(Graphics g) {
		Image ataque = CargadorRecursos.cargarImagenTranslucida(Constantes.ATAQUE);
		long msInicio = System.currentTimeMillis();
		while ((System.currentTimeMillis() - msInicio) < 2000) {
			g.drawImage(ataque, 250, 100, null);
			g.setColor(Color.BLACK);
			g.drawString(ataqueFisico + "", 290, 140);
		}
		dibujarAtaqueFisico = false;
	}

	private void dibujarMagiaCura(Graphics g) {
		Image cura = CargadorRecursos.cargarImagenTranslucida(Constantes.CURA);
		g.drawImage(cura, 150, 150, null);
		long msInicio = System.currentTimeMillis();
		while ((System.currentTimeMillis() - msInicio) < 1000) {
			
		}
		dibujarMagiaCura = false;
	}

	private void dibujarMagiaFuego(Graphics g) {
		Image fuego = CargadorRecursos.cargarImagenTranslucida(Constantes.FUEGO);
		long msInicio = System.currentTimeMillis();
		while ((System.currentTimeMillis() - msInicio) < 2000) {
			g.drawImage(fuego, 250, 100, null);
			g.setColor(Color.BLACK);
			g.drawString(ataqueMagico + "", 290, 140);
		}
		dibujarMagiaFuego = false;
	}

	private void dibujarMagiaHielo(Graphics g) {
		Image hielo = CargadorRecursos.cargarImagenTranslucida(Constantes.HIELO);
		long msInicio = System.currentTimeMillis();
		while ((System.currentTimeMillis() - msInicio) < 2000) {
			g.drawImage(hielo, 250, 100, null);
			g.setColor(Color.BLACK);
			g.drawString(ataqueMagico + "", 290, 140);
		}
		dibujarMagiaHielo = false;
	}

	private void dibujarMagiaRayo(Graphics g) {
		Image rayo = CargadorRecursos.cargarImagenTranslucida(Constantes.RAYO);
		long msInicio = System.currentTimeMillis();
		while ((System.currentTimeMillis() - msInicio) < 2000) {
			g.drawImage(rayo, 250, 100, null);
			g.setColor(Color.BLACK);
			g.drawString(ataqueMagico + "", 290, 140);
		}
		dibujarMagiaRayo = false;
	}

	private void dibujarReaccion(Graphics g) {
		Mensaje mensaje = new Mensaje(enemigo.getReacciones()[accionSeleccionada], 200, 100, true);
		mensaje.dibujarMensajeCombate(g);
		dibujarReaccion = false;
		long msInicio = System.currentTimeMillis();
		long msActual = System.currentTimeMillis();
		while ((msActual - msInicio) < 2000) {
			msActual = System.currentTimeMillis();
		}
	}

	private void dibujarHuidaFallida(Graphics g) {
		Mensaje mensaje = new Mensaje("NO CONSEGUISTE HUIR", 200, 100, true);
		mensaje.dibujarMensajeCombate(g);
		dibujarHuidaFallida = false;
		long msInicio = System.currentTimeMillis();
		long msActual = System.currentTimeMillis();
		while ((msActual - msInicio) < 2000) {
			msActual = System.currentTimeMillis();
		}
		opcion = 0;
	}

	private void dibujarFinDeCombate(Graphics g) {
		Mensaje mensaje = null;
		Mensaje mensajeExp = null;
		if (huido)
			mensaje = new Mensaje("HUIDO CON ÉXITO", 200, 100, true);
		else if (vencido) {
			mensaje = new Mensaje("ENEMIGO DERROTADO", 200, 100, true);
			mensajeExp = new Mensaje("GANADOS " + enemigo.getExperiencia() + " PUNTOS DE EXP", 180, 130, true);
			jugador.getEstadisticas().setExp(enemigo.getExperiencia());
		} else {
			mensaje = new Mensaje("EL ENEMIGO SE HA IDO", 200, 100, true);
		}

		mensaje.dibujarMensajeCombate(g);
		if (mensajeExp != null)
			mensajeExp.dibujarMensajeCombate(g);

		long msInicio = System.currentTimeMillis();
		long msActual = System.currentTimeMillis();
		while ((msActual - msInicio) < 3000) {
			msActual = System.currentTimeMillis();
		}
		enCombate = false;
	}

	public boolean isEnCombate() {
		return enCombate;
	}

}
