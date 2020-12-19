package juego.graficos;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juego.Constantes;
import juego.herramientas.CargadorRecursos;

/**
 * Clase encargada de crear la ventana en la que se van a dibujar las cosas.
 * 
 * @author Fernando Martino
 *
 */
public class Ventana extends JFrame {
	private static final long serialVersionUID = 5979421777239930009L;

	private String titulo;
	private final ImageIcon icono;

	public Ventana(final String titulo, final SuperficieDeDibujo sd) {
		this.titulo = titulo;
		BufferedImage imagen = CargadorRecursos.cargarImagenTranslucida(Constantes.ICONO);
		icono = new ImageIcon(imagen);
		configurarVentana(sd);
	}

	private void configurarVentana(SuperficieDeDibujo sd) {
		setTitle(titulo);
		// Dice al programa que se cierre si se cierra el JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// No permite modificar el tamaño de la ventana.
		setResizable(true);
		// Cambia el icono de la ventana
		setIconImage(icono.getImage());
		// Se le dice a la ventana que lo que haya dentro ocupe toda la ventana
		setLayout(new BorderLayout());
		add(sd, BorderLayout.CENTER);
		// Para quitar el borde
		setUndecorated(true);
		// Le da el formato y tamaño adecuado a la ventana
		pack();
		// Muestra la ventana en el centro
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
