package entidades;



public class Monstruo {

	
	
	private String clase;
	private int nivel;
	private int vida;
	private int danio;
	private String descripcion;

	public Monstruo(String clase, int nivel, int vida, int danio, String descripcion) {
		this.clase = clase;
		this.nivel = nivel;
		this.vida = vida;
		this.danio = danio;
		this.descripcion = descripcion;
	}
	
	

	@Override
	public String toString() {
		return "Te encuentras con un " + clase + " de nivel " + nivel + " [vida: " + vida + " || da?o: " + danio + "]";
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getClase() {
		return clase;
	}



	public void setClase(String clase) {
		this.clase = clase;
	}



	public int getNivel() {
		return nivel;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	public int getVida() {
		return vida;
	}



	public void setVida(int vida) {
		this.vida = vida;
	}



	public int getDanio() {
		return danio;
	}



	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	
	
}
