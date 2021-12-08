package mapa;

import java.util.Random;
import java.util.Scanner;

import eventos.encounter;
import main.RPG;

//import recursos.colores;



public class generacionMapa {
	
	
	
	static Scanner sc = new Scanner(System.in);
		
	public static boolean hayMonstruos(char[][] mapa) {
		boolean hayMonstruos = false;
		
		for(int i = 0; i < mapa.length;i++) {			
			for(int j = 0; j <mapa[0].length; j++) {
				if (mapa[i][j] == 'M') {
					hayMonstruos = true;
				}
				
			}
			
		}
		
		
		return hayMonstruos;
	}


	public static void navegarMapa(char[][] mapa) {
		
		
		mapa[RPG.posJugY][RPG.posJugX] = ' ';
		
		boolean direccionValida = false;
				
		while(!direccionValida) {
			System.out.println("Introduzca su movimiento (arriba, abajo, derecha, izquierda)");
			String direccion = sc.nextLine();
			
				switch (direccion.toLowerCase()) {
			case "arriba":
				
					if(RPG.posJugY -1 < 0) {
						System.out.println("No se puede ir mas arriba");
					} else {
						RPG.posJugY --;
						direccionValida = true;
					}
									
				break;
			case "abajo":
				
					if (RPG.posJugY +1 > mapa.length) {
						System.out.println("No se puede ir mas abajo");
					} else {
						RPG.posJugY ++;
						direccionValida = true;
					}
				
				break;
			case "derecha":
					if (RPG.posJugX +1 > mapa[0].length) {
						System.out.println("No se puede ir mas a la derecha");
					} else {
						RPG.posJugX ++;
						direccionValida = true;
					}
				
				break;
			case "izquierda":
					if (RPG.posJugX -1 < 0) {
						System.out.println("No se puede ir mas a la izquierda");
					} else {
						RPG.posJugX --;
						direccionValida = true;
					}
				
				break;			
			default:
				System.out.println("Debe introducir una direccion valida");
				break;
				
			}
		}
		
		//if (mapa[RPG.posJugY][RPG.posJugX] == 'M') {
		//	encounter.decidirAccion();
		//}
		
		mapa[RPG.posJugY][RPG.posJugX] = 'O';
		
		if (!hayMonstruos(mapa) && RPG.posJugY == mapa.length - 1 && RPG.posJugX == mapa[0].length - 1) {
			RPG.clear = true;
		}
		
		
		
		
	}


	public static char[][] generarMapa() {
		Random rd = new Random();
		
		int y = rd.nextInt(10 - 5) + 5;
		int x = rd.nextInt(10 - 5) + 5;
		
		int encounter;
		
		char[][] mapa = new char[x][y];
		
		
		for(int i = 0; i < mapa.length;i++) {
			
			for(int j = 0; j <mapa[0].length; j++) {
				encounter = rd.nextInt(100 - 1) + 1;
							
				
				if (encounter >= 1 && encounter <= RPG.POSIBILIDAD_TESORO) {
					mapa[i][j] = 'T';
				} else if (encounter > RPG.POSIBILIDAD_TESORO && encounter <= RPG.POSIBILIDAD_ENEMIGO) {
					mapa[i][j] = 'M';
				} else {
					mapa[i][j] = ' ';
				}
								
				
			}
			
		}
		
		mapa[RPG.posJugX][RPG.posJugY] = 'O';
		
		return mapa;
	}

	public static void mostrarMapa(char[][] mapa) {
		
		for(int j = 0; j <mapa[0].length; j++) {			
			System.out.print("____");
		}
		System.out.print("_");
		System.out.println("");
		
		
		for(int i = 0; i < mapa.length;i++) {
			System.out.print("| ");
			for(int j = 0; j <mapa[0].length; j++) {			
			System.out.print(mapa[i][j] + " | ");			
			}
			System.out.println("");
			for(int j = 0; j <mapa[0].length; j++) {			
				System.out.print("____");
			}
			System.out.print("_");
			System.out.println("");
			
		}
		
		
		
	}
	
}
