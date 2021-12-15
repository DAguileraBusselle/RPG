package entidades;

import java.util.ArrayList;

public class ListaModelosMonstruos {

	public ArrayList<ModeloMonstruo> listaMonstruos = new ArrayList<>();

	public ListaModelosMonstruos() {
		listaMonstruos.add(new ModeloMonstruo("Esqueleto", "Un enemigo fragil pero con una punteria excelente", 45, 2, 20, 5, 1, 7));
		listaMonstruos.add(new ModeloMonstruo("Zombie", "Puedes observar como trozos de su cuerpo cuelgan"
				+ "\ny se caen, sea lo que sea ya no esta vivo, o quizas si", 75, 3, 15, 3, 1, 10));
		listaMonstruos.add(new ModeloMonstruo("Slime", "No puedes distinguir muy bien de que esta hecho, pero parece"
				+ "\npegajoso y elastico, no parece demasiado agresivo", 125, 5, 5, 2, 1, 5));
		listaMonstruos.add(new ModeloMonstruo("Goblin", "Puto enano verde, asco", 50, 3, 40, 2, 3, 9));
		listaMonstruos.add(new ModeloMonstruo("Orco", "Antes tus se presenta un ser tan aberrantemente feo, que te quedas "
				+ "\ncongelado unos segundos, tambien sujeta un tronco, con el que supones que te va a pegar", 150, 5, 80, 3, 8, 20));
		listaMonstruos.add(new ModeloMonstruo("Grifo", "Te quedas embobado con la majestuosa bestia que se te aproxima a 500km/h", 65, 2, 145, 3, 5, 8));
		listaMonstruos.add(new ModeloMonstruo("Sucubo", "No lo pienso describir", 35, 3, 105, 5, 4, 9));
		listaMonstruos.add(new ModeloMonstruo("Demonio", "Cada vez que tus mirada cruza con la suya, te mareas un poco, no sabes que es"
				+ "\n, solo sabes que debes matarlo", 550, 8, 250, 5, 0, 0));
		//listaMonstruos.add(new ModeloMonstruo("Bruja", null, 0, 0, 0, 0, 0, 0));
		//listaMonstruos.add(new ModeloMonstruo("Ratas mutante", null, 0, 0, 0, 0, 0, 0));
		//listaMonstruos.add(new ModeloMonstruo("Angel caido", null, 0, 0, 0, 0, 0, 0));
		//listaMonstruos.add(new ModeloMonstruo("Basilisco", null, 0, 0, 0, 0, 0, 0));
		//listaMonstruos.add(new ModeloMonstruo("Tarantula gigante", null, 0, 0, 0, 0, 0, 0));
		
		
	}

	public ArrayList<ModeloMonstruo> getListaMonstruos() {
		return listaMonstruos;
	}
	
	

			
}