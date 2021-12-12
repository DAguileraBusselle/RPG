package entidades;

public class ObjetoPasivo extends Objeto{

	
	public static String[] FUNCIONES = new String[] {"vida", "velocidad", "danio"};		
	
	private String funcion;
	private int parametroFuncion;
	private boolean equipado;
	
	public ObjetoPasivo(String nombre, String descripcion, String funcion, int parametroFuncion, boolean equipado) {
		super(nombre, descripcion);
		this.funcion = funcion;
		this.parametroFuncion = parametroFuncion;
		this.equipado = equipado;
	}




	public boolean isEquipado() {
		return equipado;
	}




	public void setEquipado(boolean equipado) {
		this.equipado = equipado;
	}




	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}




	public int getParametroFuncion() {
		return parametroFuncion;
	}




	public void setParametroFuncion(int parametroFuncion) {
		this.parametroFuncion = parametroFuncion;
	}
	
	
}
