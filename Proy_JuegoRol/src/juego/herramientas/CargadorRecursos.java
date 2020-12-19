package juego.herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

/**
 * Clase encargada de leer ficheros externos guardados en la carpeta de
 * recursos.
 * 
 * @author Fernando Martino
 *
 */
public class CargadorRecursos {

	public static BufferedImage cargarImagenOpaca(final String ruta) {
		Image img = null;
		try {
			img = ImageIO.read(CargadorRecursos.class.getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		BufferedImage imagen = gc.createCompatibleImage(img.getWidth(null), img.getHeight(null), Transparency.OPAQUE);

		Graphics g = imagen.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();

		return imagen;
	}

	public static BufferedImage cargarImagenTranslucida(final String ruta) {
		Image img = null;

		try {
			img = ImageIO.read(CargadorRecursos.class.getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		BufferedImage imagen = gc.createCompatibleImage(img.getWidth(null), img.getHeight(null),
				Transparency.TRANSLUCENT);

		Graphics g = imagen.getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();

		return imagen;
	}

	public static String leerFicheroTexto(final String ruta) {
		String texto = "";

		InputStream is = CargadorRecursos.class.getResourceAsStream(ruta);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String linea;
		try {
			while ((linea = br.readLine()) != null) {
				texto += linea;
			}
			br.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return texto;
	}
}
