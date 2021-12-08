package entidades;

public class ObjetoPasivo extends Objeto{

	public static String[] FUNCIONES = new String[] {"vida", "velocidad", "danio"};		
	
	private String funcion;
	
	
	public ObjetoPasivo(String nombre, String descripcion, String funcion) {
		super(nombre, descripcion);
		this.funcion = funcion;
	}




	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	
}
