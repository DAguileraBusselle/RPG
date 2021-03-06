package mapa;

import java.util.Random;
import java.util.Scanner;


import entidades.Monstruo;
import entidades.ObjetoActivo;
import entidades.ObjetoPasivo;
import eventos.encounter;
import main.RPG;

//import recursos.colores;


public class generacionMapa {
	private static encounter enc = new encounter();	
	
	static Scanner sc = new Scanner(System.in);
		
	
	public static int contMonstruos(char[][] mapa) {
		int contMons = 0;
		
		for(int i = 0; i < mapa.length;i++) {			
			for(int j = 0; j <mapa[0].length; j++) {
				if (mapa[i][j] == 'M') {
					contMons ++;
				}
				
			}
			
		}
		
		
		return contMons;
	}

	public static void navegarMapa(char[][] mapa) {		
		Random rd = new Random();
		int posJugYinicial = RPG.posJugY;
		int posJugXinicial = RPG.posJugX;
		int casillas = RPG.jugador.getVelocidad();
				
		boolean direccionValida = false;
		StringBuffer sbExp;
		String exp = "EXP: [";
		String expp = "";
		for (int i = 0; i < RPG.EXPERIENCIA; i+=(RPG.jugador.getNivel()*10))	{
			expp += "o";
		}
		sbExp = new StringBuffer(expp);
		sbExp.setLength(10);
		
		
		exp += sbExp.toString() + "]";
			
		System.out.println("HP: " + RPG.jugador.getVida() + " | " + RPG.VIDA_MAX +
							"\nDMG: " + RPG.jugador.getDanio()+
							"\nSPEED: " + RPG.jugador.getVelocidad() +
							"\nLVL: " + RPG.jugador.getNivel() +							  
							"\n" + exp + " " + RPG.EXPERIENCIA + " | " + RPG.jugador.getNivel()*100);
		
		while(!direccionValida) {
			
			System.out.println("Introduzca su movimiento arriba(w), abajo(s), derecha(d), izquierda(a) o inventario(i)");
			String direccion = sc.nextLine();
			
			if ((direccion.equals("a") || direccion.equals("w") || direccion.equals("s") || direccion.equals("d")) && RPG.jugador.getVelocidad() > 1) {
								
				boolean valido = true;
				do {
					try {
						System.out.println("Cuantas casillas quieres avanzar?");
						casillas = Integer.parseInt(sc.nextLine());								
						valido = true;	
						
						if (casillas > RPG.jugador.getVelocidad()) {
							System.out.println("No puedes avanzar tanto");
							valido = false;
						} else if (casillas <= 0) {
							System.out.println("Debe ser una cantidad mayor que 0");
							valido = false;
						}
					} catch (NumberFormatException e) {
						System.out.println("Debes introducir un numero");
						valido = false;
					}						
					
				} while (!valido);		
				
				
			}
						
				switch (direccion.toLowerCase()) {
			case /*"arriba",*/ "w":
				
					if(RPG.posJugY - casillas < 0) {
						System.out.println("No se puede ir mas arriba");
					} else {
						RPG.posJugY -= casillas;
						direccionValida = true;
					}
									
				break;
			case /*"abajo",*/ "s":
				
					if (RPG.posJugY + casillas == mapa.length) {
						System.out.println("No se puede ir mas abajo");
					} else {
						RPG.posJugY += casillas;
						direccionValida = true;
					}
				
				break;
			case /*"derecha",*/ "d":
					if (RPG.posJugX + casillas == mapa[0].length) {
						System.out.println("No se puede ir mas a la derecha");
					} else {
						RPG.posJugX += casillas;
						direccionValida = true;
					}
				
				break;
			case /*"izquierda",*/ "a":
					if (RPG.posJugX - casillas < 0) {
						System.out.println("No se puede ir mas a la izquierda");
					} else {
						RPG.posJugX -= casillas;
						direccionValida = true;
					}
				
				break;	
			case /*"inventario",*/ "i":
				System.out.println(RPG.jugador.getInventario().toString());	
				navegarInventario();
				break;
			default:
				System.out.println("Debe introducir una direccion valida");
				break;
				
			}
		}
		
		if (mapa[RPG.posJugY][RPG.posJugX] == 'M') {
			
			Monstruo mons = enc.generarMonstruo();
			
			System.out.println(mons.toString());		
			
			if (enc.decidirAccion(mons)) {
				mapa[RPG.posJugY][RPG.posJugX] = 'O';
				mapa[posJugYinicial][posJugXinicial] = ' ';
				
			} else {
				RPG.posJugY = posJugYinicial;
				RPG.posJugX = posJugXinicial;
			}
			
		} else if (mapa[RPG.posJugY][RPG.posJugX] == 'T') {
			int tipoObj = rd.nextInt(100 - 1) + 1;
			
			
			if (tipoObj >= 0 && tipoObj <= RPG.POSIBILIDAD_OBJ_PAS) {
				encounter.decidirObjPas();
			} else {
				encounter.decidirObjAct();
			}
			
			mapa[RPG.posJugY][RPG.posJugX] = 'O';
			mapa[posJugYinicial][posJugXinicial] = ' ';
		
		} else {	
			mapa[RPG.posJugY][RPG.posJugX] = 'O';
			mapa[posJugYinicial][posJugXinicial] = ' ';
		}
		
		
		if(RPG.TOTAL_MONSTRUOS >= RPG.PISO*5) {
			if (RPG.CONT_MONSTRUOS_DERROTADOS >= RPG.PISO*5 && RPG.posJugY == mapa.length - 1 && RPG.posJugX == mapa[0].length - 1) {
				RPG.clear = true;
			}
		} else if (RPG.CONT_MONSTRUOS_DERROTADOS == RPG.TOTAL_MONSTRUOS && RPG.posJugY == mapa.length - 1 && RPG.posJugX == mapa[0].length - 1) {
			RPG.clear = true;
		}		
		
		
	}


	public static void navegarInventario() {
		boolean opcionValida = false;
		
		
		while(!opcionValida) { 
			System.out.println("Introduce su opcion (1 - 9) o cancelar (c)");
			String opcion = sc.nextLine();
		
				switch (opcion.toLowerCase()) {
			case "1":
				if(RPG.jugador.getInventario().getItemPas1() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoPas(RPG.jugador.getInventario().getItemPas1());
				}
				opcionValida = true;								
				break;
			case "2":
				
				if(RPG.jugador.getInventario().getItemPas2() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoPas(RPG.jugador.getInventario().getItemPas2());
				}
				opcionValida = true;
				break;
			case "3":
				if(RPG.jugador.getInventario().getItemPas3() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoPas(RPG.jugador.getInventario().getItemPas3());
				}
				opcionValida = true;								
				break;
			case "4":
				
				if(RPG.jugador.getInventario().getItemPas4() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoPas(RPG.jugador.getInventario().getItemPas4());
				}
				opcionValida = true;
				break;				
			case "5":
					
				if(RPG.jugador.getInventario().getItem1() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoAct(RPG.jugador.getInventario().getItem1());
				}
				opcionValida = true;
				break;
			case "6":
				if(RPG.jugador.getInventario().getItem2() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoAct(RPG.jugador.getInventario().getItem2());
				}					
				opcionValida = true;
				break;	
			case "7":
				if(RPG.jugador.getInventario().getItem3() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoAct(RPG.jugador.getInventario().getItem3());
				}
				opcionValida = true;
				break;
			case "8":
				if(RPG.jugador.getInventario().getItem4() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoAct(RPG.jugador.getInventario().getItem4());
				}
				opcionValida = true;
				break;
			case "9":
				if(RPG.jugador.getInventario().getItem5() == null) {
					System.out.println("No hay un objeto ahi");
				} else {
					interactuarObjetoAct(RPG.jugador.getInventario().getItem5());
				}
				opcionValida = true;
				break;
			case /*"cancelar",*/ "c":				
				opcionValida = true;
				
				break;
			default:
				System.out.println("Debes introducir una opcion valida");
				break;
				
			}
		}
		
	}


	private static void interactuarObjetoAct(ObjetoActivo item) {
		boolean opcionValida = false;
		
		
		while(!opcionValida) { 
			System.out.println("Que deseas hacer con el item {" + item.getNombre() + "}" + 
							"\n\t1_USAR" +
							"\n\t2_TIRAR" +
							"\n\t3_CANCELAR");
			
			String opcion = sc.nextLine();
			
				switch (opcion.toLowerCase()) {
			case "1":
				if (item.getCantidad() == 0) {
					System.out.println("No te quedan de esos");
				} else {
					usarObjetoAct(item);
				}				
				opcionValida = true;							
				break;
			case "2":
				item.setCantidad(0);
				opcionValida = true;
				break;
			case "3":
					
				opcionValida = true;
				
				break;
			
			default:
				System.out.println("Debes introducir una opcion valida");
				break;
				
			}
		}
		
	}


	private static void usarObjetoAct(ObjetoActivo item) {
		int cantidad = solicitarCant(item);
		switch (item.getFuncion()) {
		case "cura":
			for(int i = 0; i < cantidad; i ++) {
				RPG.jugador.setVida(RPG.jugador.getVida() + item.getIntensidad());
			}
			
			if (RPG.jugador.getVida() > RPG.VIDA_MAX) {
				RPG.jugador.setVida(RPG.VIDA_MAX);
			}
			System.out.println("TE HAS CURADO, AHORA TU VIDA ES: " + RPG.jugador.getVida());
			break;

		case "escapada":
			//TODO: IMPLEMENTAR POSIBILIDAD DE ESCAPAR ENCOUNTER
			break;
		case "danio":
			RPG.jugador.setDanio(RPG.jugador.getDanio() + item.getIntensidad());
			break;
		}
		
		item.setCantidad(item.getCantidad() - cantidad);
		
		if (item.getCantidad() == 0) {
			item = null;
		}
		
	}

	private static int solicitarCant(ObjetoActivo item) {		
		int num = 0;
		boolean valido = true;
		do {
			try {
				System.out.println("Cuantos quieres usar?");
				num = Integer.parseInt(sc.nextLine());								
				valido = true;	
				
				if (num > item.getCantidad()) {
					System.out.println("No puedes consumir tantos");
					valido = false;
				} else if (num <= 0) {
					System.out.println("Debe ser una cantidad mayor que 0");
					valido = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Debes introducir un numero");
				valido = false;
			}						
			
		} while (!valido);		
		
		return num;
	}

	private static void interactuarObjetoPas(ObjetoPasivo itemPas) {
		if (!itemPas.isEquipado()) {
			boolean opcionValida = false;
			
			
			while(!opcionValida) { 
				System.out.println("Que deseas hacer con el item {" + itemPas.getNombre() + "}" + 
								"\n\t1_EQUIPAR" +
								"\n\t2_CANCELAR");
				
				String opcion = sc.nextLine();
				
					switch (opcion.toLowerCase()) {
				case "1":
					if (RPG.ITEM_EQUIPADOS == 2) {
						System.out.println("NO PUEDES EQUIPAR MAS OBJETOS");
					} else if (RPG.listaObjEquipados != null && RPG.listaObjEquipados.contains(itemPas)) {
						System.out.println("NO PUEDES EQUIPAR MAS DE ESTE OBJETO");
					} else {
						itemPas.setEquipado(true);
						if (itemPas.getFuncion().equals("vida")) {
							RPG.VIDA_MAX += itemPas.getParametroFuncion();
						} else if (itemPas.getFuncion().equals("danio")) {
							RPG.jugador.setDanio(RPG.jugador.getDanio() + itemPas.getParametroFuncion());
						} else if (itemPas.getFuncion().equals("velocidad")) {
							RPG.jugador.setVelocidad(itemPas.getParametroFuncion());
						}
						RPG.ITEM_EQUIPADOS++;
						RPG.listaObjEquipados.add(itemPas);
					}				
					opcionValida = true;							
					break;
				case "2":
					
					opcionValida = true;
					break;
				
				default:
					System.out.println("Debe introducir una opcion valida");
					break;
					
				}
			}
		} else if (itemPas.isEquipado()) {
			boolean opcionValida = false;
			
			
			while(!opcionValida) { 
				System.out.println("Que deseas hacer con el item {" + itemPas.getNombre() + "}" + 
								"\n\t1_DESEQUIPAR" +
								"\n\t2_CANCELAR");
				
				String opcion = sc.nextLine();
				
					switch (opcion.toLowerCase()) {
				case "1":					
						itemPas.setEquipado(false);
						
						if (itemPas.getFuncion().equals("vida")) {
							RPG.VIDA_MAX -= itemPas.getParametroFuncion();
						} else if (itemPas.getFuncion().equals("danio")) {
							RPG.jugador.setDanio(RPG.jugador.getDanio() - itemPas.getParametroFuncion());
						} else if (itemPas.getFuncion().equals("velocidad")) {
							RPG.jugador.setVelocidad(1);
						}
						RPG.ITEM_EQUIPADOS--;
						int posObjEquipado = 0;
						if (RPG.listaObjEquipados.get(1).getNombre().equals(itemPas.getNombre())) {
							posObjEquipado = 1;
						}
						
						RPG.listaObjEquipados.remove(posObjEquipado);
					opcionValida = true;							
					break;
				case "2":
					
					opcionValida = true;
					break;
				
				default:
					System.out.println("Debe introducir una opcion valida");
					break;
					
				}
			}
		
		}
		
	}


	public static char[][] generarMapa() {
		Random rd = new Random();
		
		
		int y = rd.nextInt((7+RPG.PISO) - (RPG.PISO+4)) + (RPG.PISO+4);
		int x = rd.nextInt((7+RPG.PISO) - (RPG.PISO+4)) + (RPG.PISO+4);
		
		int encounter;
		
		char[][] mapa = new char[x][y];
			
		if (RPG.PISO % 5 == 0) {
			for(int i = 0; i < mapa.length;i++) {
				
				for(int j = 0; j <mapa[0].length; j++) {
					
					mapa[i][j] = ' ';
				}
				
			}
			
			mapa[mapa.length/2][mapa[0].length/2] = 'M';
		} else {
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
				
		}
		
		mapa[RPG.posJugX][RPG.posJugY] = 'O';
		
		return mapa;
	}

	public static void mostrarMapa(char[][] mapa) {
		
		for(int j = 0; j <mapa[0].length; j++) {			
			RPG.TEXTO_PANTALLA += "____";
			System.out.print("____");
		}
		RPG.TEXTO_PANTALLA += "_";
		System.out.print("_");
		RPG.TEXTO_PANTALLA += "\n";
		System.out.println("");
		
		
		for(int i = 0; i < mapa.length;i++) {
			RPG.TEXTO_PANTALLA += "| ";
			System.out.print("| ");
			for(int j = 0; j <mapa[0].length; j++) {			
				RPG.TEXTO_PANTALLA += mapa[i][j] + " | ";
				System.out.print(mapa[i][j] + " | ");			
			}
			RPG.TEXTO_PANTALLA += "\n";
			System.out.println("");
			for(int j = 0; j <mapa[0].length; j++) {			
				RPG.TEXTO_PANTALLA += "____";
				System.out.print("____");
			}
			RPG.TEXTO_PANTALLA += "_";
			System.out.print("_");
			RPG.TEXTO_PANTALLA += "\n";
			System.out.println("");
			
		}
		
		
		
	}
	
}
