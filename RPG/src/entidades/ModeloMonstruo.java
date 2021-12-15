package entidades;

public class ModeloMonstruo {

	private String clase;
	private String descripcion;
	private int vidaBase;
	private int escaladoVida;
	private int danioBase;	
	private int escaladoDanio;
	private int pisoMinimo;
	private int pisoMaximo;
			
	public ModeloMonstruo(String clase, String descripcion, int vidaBase, int escaladoVida, int danioBase,
			int escaladoDanio, int pisoMinimo, int pisoMaximo) {
		this.clase = clase;
		this.descripcion = descripcion;
		this.vidaBase = vidaBase;
		this.escaladoVida = escaladoVida;
		this.danioBase = danioBase;
		this.escaladoDanio = escaladoDanio;
		this.pisoMinimo = pisoMinimo;
		this.pisoMaximo = pisoMaximo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getVidaBase() {
		return vidaBase;
	}

	public void setVidaBase(int vidaBase) {
		this.vidaBase = vidaBase;
	}

	public int getEscaladoVida() {
		return escaladoVida;
	}

	public void setEscaladoVida(int escaladoVida) {
		this.escaladoVida = escaladoVida;
	}

	public int getDanioBase() {
		return danioBase;
	}

	public void setDanioBase(int danioBase) {
		this.danioBase = danioBase;
	}

	public int getEscaladoDanio() {
		return escaladoDanio;
	}

	public void setEscaladoDanio(int escaladoDanio) {
		this.escaladoDanio = escaladoDanio;
	}

	public int getPisoMinimo() {
		return pisoMinimo;
	}

	public void setPisoMinimo(int pisoMinimo) {
		this.pisoMinimo = pisoMinimo;
	}

	public int getPisoMaximo() {
		return pisoMaximo;
	}

	public void setPisoMaximo(int pisoMaximo) {
		this.pisoMaximo = pisoMaximo;
	}
	
	
	
}
