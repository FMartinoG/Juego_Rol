package principal.control;

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
