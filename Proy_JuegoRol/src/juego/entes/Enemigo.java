package juego.entes;

public class Enemigo {
	
	private Estadisticas estadisticas;
	private String imagen;
	
	public Enemigo(String imagen, Estadisticas estadisticas) {
		this.imagen = imagen;
		this.estadisticas = estadisticas;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

}
