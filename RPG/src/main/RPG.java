package main;

import mapa.generacionMapa;

public class RPG {


	public static int POSIBILIDAD_TESORO = 3;
	
	public static int POSIBILIDAD_ENEMIGO = 20;
	
	public static boolean clear = false;

	public static char[][] mapa;
	
	public static int contVictoria = 0;
	
	public static int posJugY = 0;
	public static int posJugX = 0;
	
public static void main(String[] args) {
		
		mapa = generacionMapa.generarMapa();
		
		for (int i = 0; i < 50; ++i) System.out.println();
		
		generacionMapa.mostrarMapa(mapa);
		
		while(!clear) {
			generacionMapa.navegarMapa(mapa);
			for (int i = 0; i < 50; ++i) System.out.println();
			generacionMapa.mostrarMapa(mapa);
			
			if(!generacionMapa.hayMonstruos(mapa) && contVictoria == 0) {				
				
				mapa[mapa.length - 1][mapa[0].length - 1] = 'E';
				
				
				for (int i = 0; i < 50; ++i) System.out.println();
				generacionMapa.mostrarMapa(mapa);
				System.out.println("SE HA ABIERTO LA PUERTA");
				contVictoria ++;
			}
			
			
		}
		
		System.out.println("HAS ESCAPADO DEL DUNGEON");
		
		

	}

}
