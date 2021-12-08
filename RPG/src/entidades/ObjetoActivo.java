package entidades;

public class ObjetoActivo extends Objeto {

	public String[] funciones = new String[] {"cura", "escapada", "danio"};
	
	private String funcion;
	private int cantidad;
	
	public ObjetoActivo(String nombre, String descripcion, String funcion, int cantidad) {
		super(nombre, descripcion);
		this.funcion = funcion;
		this.cantidad = cantidad;
	}

	public String[] getFunciones() {
		return funciones;
	}

	public void setFunciones(String[] funciones) {
		this.funciones = funciones;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
