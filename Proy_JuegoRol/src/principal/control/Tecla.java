package principal.control;

/**
 * Clase encargada de decir si una tecla est� pulsada y cuando ha sido pulsada
 * por �tilma vez. Se usa para teclas que puedan pulsarse a la vez y se quiere
 * saber cual ha sido la �ltima.
 * 
 * @author Fernando Martino
 *
 */
public class Tecla {

	private boolean pulsada = false;
	private long ultimaPulsacion = System.nanoTime();

	public void pulsarTecla() {
		pulsada = true;
		ultimaPulsacion = System.nanoTime();
	}

	public void soltarTecla() {
		pulsada = false;
	}

	public boolean isPulsada() {
		return pulsada;
	}

	public long getUltimaPulsacion() {
		return ultimaPulsacion;
	}

}
