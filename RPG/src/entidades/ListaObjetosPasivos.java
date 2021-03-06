package entidades;

import java.util.ArrayList;

public class ListaObjetosPasivos {

	ArrayList<ObjetoPasivo> listaPasivos = new ArrayList<>();

	public ListaObjetosPasivos() {
		
		//organizados por rareza para su distribucion por el mapa
		listaPasivos.add(new ObjetoPasivo("Botas escurridizas", "Parece que la suela esta compuesta por alguna clase de moco", "velocidad", 2, false));
		listaPasivos.add(new ObjetoPasivo("Amuleto desgastado", "Emana un ligero brillo del amuleto", "vida", 150, false));
		listaPasivos.add(new ObjetoPasivo("Espada de madera", "Una espada de practica, con suerte la usas como un bate", "danio", 15, false));
		listaPasivos.add(new ObjetoPasivo("Botas de pluma", "A penas notas su peso en tus manos, sabes que te llevaran lejos", "velocidad", 3, false));
		listaPasivos.add(new ObjetoPasivo("Amuleto semiusado", "Notas una cierta energia procediente de este amuleto", "vida", 250, false));
		listaPasivos.add(new ObjetoPasivo("Espada oxidada", "En su momento seria un arma despiadada, ahora, un recordatorio de lo que fue", "danio", 35, false));
		listaPasivos.add(new ObjetoPasivo("Botas de viento", "El peso de tu cuerpo desaparece al sujetarlas", "velocidad", 3, false));
		listaPasivos.add(new ObjetoPasivo("Amuleto deslumbrante", "La energia del amuleto te llena de vida y determinacion", "vida", 400, false));
		listaPasivos.add(new ObjetoPasivo("Espada de caballera", "Se te ponen los pelos de punta al sujetar semejante arma", "danio", 85, false));		
			
	}

	public ArrayList<ObjetoPasivo> getListaPasivos() {
		return listaPasivos;
	}
}
