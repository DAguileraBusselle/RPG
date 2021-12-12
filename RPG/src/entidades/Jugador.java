package entidades;

public class Jugador {

	private int velocidad;
	private int vida;
	private int nivel;
	private int danio;
	private Inventario inventario;
	
	public Jugador(int velocidad, int vida, int nivel, int danio, Inventario inventario) {
		this.velocidad = velocidad;
		this.vida = vida;
		this.nivel = nivel;
		this.danio = danio;
		this.inventario = inventario;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getVida() {
		return vida;
	}

	public int getNivel() {
		return nivel;
	}
	
	public int getDanio() {
		return danio;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	
	
}
