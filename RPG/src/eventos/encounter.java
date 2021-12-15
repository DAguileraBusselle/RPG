package eventos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entidades.ModeloMonstruo;
import entidades.Monstruo;
import entidades.ObjetoActivo;
import entidades.ObjetoPasivo;
import main.RPG;
import mapa.generacionMapa;

public class encounter {

	Random rd = new Random();
	static Scanner sc = new Scanner(System.in);
	
	public Boolean decidirAccion(Monstruo mons) {
		boolean encounterDerrotado = false;
		boolean opcionValida = false;
		
		while(!opcionValida) {
			System.out.println("¿Que haras?\n\t1 - COMBATE\n\t2 - HUIR");
			String decision = sc.nextLine();
			
				switch (decision.toLowerCase()) {
			case "1":
				
				opcionValida = true;
				combate(mons);
				encounterDerrotado = true;
								
				break;
			case "2":
				
				opcionValida = true;
				
				break;
						
			default:
				System.out.println("Debe introducir una decision valida");
				break;
				
			}
				
				
		}
		
		
		return encounterDerrotado;
		
	}
	
	private void combate(Monstruo mons) {
		
				
		
		while(mons.getVida() > 0) {
			boolean defender = false;
			boolean atacar = false;
			boolean opcionValida = false;
			while(!opcionValida) {
		
			System.out.println("Elige\n\t1 - ATACAR"
					+ "\n\t2 - DEFENDER"
					+ "\n\t3 - OBSERVAR"
					+ "\n\t4 - INVENTARIO");
			String decision = sc.nextLine();
			
				switch (decision.toLowerCase()) {
			case "1":
				mons.setVida(mons.getVida() - RPG.jugador.getDanio());	
				
				opcionValida = true;
				atacar = true;
				break;
			case "2":				
				opcionValida = true;
				defender = true;
				break;
			case "3":				
				opcionValida = true;
				System.out.println(mons.getDescripcion());
				break;
			case "4":		
				System.out.println(RPG.jugador.getInventario().toString());	
				generacionMapa.navegarInventario();
				opcionValida = true;
				break;
						
			default:
				System.out.println("Debe introducir una decision valida");
				break;
				
				}
				
				
			}
			
			
			
			if (defender) {
				System.out.println("DEFIENDES EL DAÑO");
			} else if (mons.getVida() > 0 && atacar){
				System.out.println("______________________________________________");
				
				System.out.println("ATACAS AL " + mons.getClase().toUpperCase());
				
				System.out.println("JUGADOR: " + RPG.jugador.getVida() + "HP");
				System.out.println(mons.getClase() + ": " + mons.getVida() + "HP");	
				
				System.out.println("______________________________________________");
				System.out.println("ATACA EL " + mons.getClase().toUpperCase());
				RPG.jugador.setVida(RPG.jugador.getVida() - mons.getDanio());
			System.out.println("______________________________________________");
			
			System.out.println("JUGADOR: " + RPG.jugador.getVida() + "HP");
			System.out.println(mons.getClase() + ": " + mons.getVida() + "HP");
			} 
			
			if (RPG.jugador.getVida() <= 0) {
				for (int i = 0; i < 35; ++i) System.out.println();
				System.out.println("HAS MUERTO");
				for (int i = 0; i < 24; ++i) System.out.println();
				System.exit(0);
			}
			
			
		}
		
		int expMons = ((mons.getNivel() * 3)/RPG.PISO) + (RPG.PISO *7);
		RPG.EXPERIENCIA += expMons;
		System.out.println("CONSEGUISTE " + expMons + "EXP");
		RPG.CONT_MONSTRUOS_DERROTADOS++;
		sc.nextLine();
		
		if (RPG.EXPERIENCIA >= RPG.jugador.getNivel() * 100) {
			int expExtra = RPG.EXPERIENCIA - RPG.jugador.getNivel() * 100;
			RPG.jugador.setNivel(RPG.jugador.getNivel() + 1);
			RPG.VIDA_MAX += RPG.jugador.getNivel() * 50;
			RPG.jugador.setVida(RPG.VIDA_MAX);
			RPG.jugador.setDanio(RPG.jugador.getDanio() + (RPG.jugador.getNivel() * 5));
			RPG.EXPERIENCIA = 0 + expExtra;
			System.out.println("HAS SUBIDO A NIVEL " + RPG.jugador.getNivel());
			sc.nextLine();
		}
	}

	public Monstruo generarMonstruo() {
		ArrayList<ModeloMonstruo> listaMons = new ArrayList<>();
		
		
		
		for (ModeloMonstruo mons: RPG.listaMonstruos) {
			if (RPG.PISO >= mons.getPisoMinimo() && RPG.PISO <= mons.getPisoMaximo() && RPG.PISO % 5 != 0) {
				listaMons.add(mons);
				System.out.println(mons.getClase());
			} else if (mons.getPisoMaximo() == 0 && mons.getPisoMinimo() == 0) {
				listaMons.add(mons);
			}
		}
		ModeloMonstruo modelMons = null;
		
		if (listaMons.size() > 1) {
			int rdEncounter = rd.nextInt((listaMons.size()) - 1) + 1;
			modelMons = listaMons.get(rdEncounter - 1);
		} else {
			modelMons = listaMons.get(0);
		}
		
		
		int nivel = rd.nextInt((RPG.PISO*10) - (RPG.PISO*10 - 9)) + (RPG.PISO*10 - 9);
		int vida = modelMons.getVidaBase() + (nivel*modelMons.getEscaladoVida());
		int danio = modelMons.getDanioBase() + (nivel*modelMons.getEscaladoDanio());
				
		Monstruo monstruo = new Monstruo(modelMons.getClase(), nivel, vida, danio, modelMons.getDescripcion());
				
		return monstruo;
	}

	public static void decidirObjPas() {	
		
		//TODO: valancear de verdad el loot por pisos, esta en modo prueba
		
		Random rd = new Random();
		ObjetoPasivo objPas = null;
		if (RPG.PISO >= 1 && RPG.PISO <= 5) {
			objPas = RPG.listaObjPas.get(rd.nextInt(3 - 0) + 0);
		} else if (RPG.PISO > 5 && RPG.PISO <= 25) {
			objPas = RPG.listaObjPas.get(rd.nextInt(6 - 3) + 3);
		} else if (RPG.PISO > 25) {
			objPas = RPG.listaObjPas.get(rd.nextInt(9 - 6) + 6);
		}
		
		
		Boolean opcionValida = false;
		System.out.println("Te encuentras " + objPas.getNombre());
		while(!opcionValida) { 
			
			System.out.println("Que desea hacer con el objeto?" + 
							"\n\t1_GUARDAR" +
							"\n\t2_OBSERVAR" +
							"\n\t3_TIRAR");
			
			String opcion = sc.nextLine();
			
				switch (opcion.toLowerCase()) {
			case "1":
				if(RPG.jugador.getInventario().getItemPas1() == null)	{
					RPG.jugador.getInventario().setItemPas1(objPas);
				} else if(RPG.jugador.getInventario().getItemPas2() == null)	{
					if (!RPG.jugador.getInventario().getItemPas1().getNombre().equals(objPas.getNombre())) {
						
						RPG.jugador.getInventario().setItemPas2(objPas);
						
					} else {
						System.out.println("No puedes tener mas de ese objeto");
					}
					
				} else if(RPG.jugador.getInventario().getItemPas3() == null)	{
					if (!RPG.jugador.getInventario().getItemPas1().getNombre().equals(objPas.getNombre()) ||
							!RPG.jugador.getInventario().getItemPas2().getNombre().equals(objPas.getNombre())) {
						
						RPG.jugador.getInventario().setItemPas3(objPas);
						
					} else {
						System.out.println("No puedes tener mas de ese objeto");
					}
					
				} else if(RPG.jugador.getInventario().getItemPas4() == null)	{
					if (!RPG.jugador.getInventario().getItemPas1().getNombre().equals(objPas.getNombre()) ||
							!RPG.jugador.getInventario().getItemPas2().getNombre().equals(objPas.getNombre()) ||
							!RPG.jugador.getInventario().getItemPas3().getNombre().equals(objPas.getNombre())) {
						
						RPG.jugador.getInventario().setItemPas4(objPas);
						
					} else {
						System.out.println("No puedes tener mas de ese objeto");
					}
				} else {
					maxObjetosPas(objPas);
				}
				opcionValida = true;							
				break;
			case "2":
				System.out.println(objPas.getDescripcion());
				sc.nextLine();
				break;
			case "3":				
				opcionValida = true;				
				break;
			
			default:
				System.out.println("Debe introducir una opcion valida");
				break;
				
			}
		}
		
		
		
		
	}

	private static void maxObjetosPas(ObjetoPasivo objPas) {
		Boolean opcionValida = false;
		
		while(!opcionValida) { 
			System.out.println("No puedes llevar mas objetos equipables");
			System.out.println("Que desea hacer con el objeto?" + 
							"\n\t1_Sustituir " + RPG.jugador.getInventario().getItemPas1().getNombre() +
							"\n\t2_Sustituir " + RPG.jugador.getInventario().getItemPas2().getNombre() +
							"\n\t3_Sustituir " + RPG.jugador.getInventario().getItemPas3().getNombre() +
							"\n\t4_Sustituir " + RPG.jugador.getInventario().getItemPas4().getNombre() +
							"\n\t5_TIRAR");
			
			String opcion = sc.nextLine();
			
				switch (opcion.toLowerCase()) {
			case "1":
				RPG.jugador.getInventario().setItemPas1(objPas);
				opcionValida = true;							
				break;
			case "2":
				RPG.jugador.getInventario().setItemPas2(objPas);
				opcionValida = true;
				break;
			case "3":
				RPG.jugador.getInventario().setItemPas3(objPas);	
				opcionValida = true;				
				break;
			case "4":
				RPG.jugador.getInventario().setItemPas4(objPas);
				opcionValida = true;
				break;
			case "5":
				opcionValida = true;
				break;
			default:
				System.out.println("Debe introducir una opcion valida");
				break;
				
			}
		}
		
	}

	public static void decidirObjAct() {		
		ObjetoActivo objAct = generarPocion();		
		
				
		Boolean opcionValida = false;
		System.out.println("Te encuentras (" + objAct.getNombre() + "[" + objAct.getCantidad() + "])");
		while(!opcionValida) { 			
			System.out.println("Que desea hacer con el objeto?" + 
							"\n\t1_GUARDAR" +
							"\n\t2_OBSERVAR" +
							"\n\t3_TIRAR");
			
			String opcion = sc.nextLine();
			
				switch (opcion.toLowerCase()) {
			case "1":
					if (RPG.jugador.getInventario().getItem1() != null && RPG.jugador.getInventario().getItem1().getNombre().equals(objAct.getNombre())) {												
						RPG.jugador.getInventario().getItem1().setCantidad(RPG.jugador.getInventario().getItem1().getCantidad() + objAct.getCantidad());						
					} else if (RPG.jugador.getInventario().getItem2() != null && RPG.jugador.getInventario().getItem2().getNombre().equals(objAct.getNombre())) {						
						RPG.jugador.getInventario().getItem2().setCantidad(RPG.jugador.getInventario().getItem2().getCantidad() + objAct.getCantidad());						
					} else if (RPG.jugador.getInventario().getItem3() != null && RPG.jugador.getInventario().getItem3().getNombre().equals(objAct.getNombre())) {						
						RPG.jugador.getInventario().getItem3().setCantidad(RPG.jugador.getInventario().getItem3().getCantidad() + objAct.getCantidad());						
					} else if (RPG.jugador.getInventario().getItem4() != null && RPG.jugador.getInventario().getItem4().getNombre().equals(objAct.getNombre())) {						
						RPG.jugador.getInventario().getItem4().setCantidad(RPG.jugador.getInventario().getItem4().getCantidad() + objAct.getCantidad());						
					} else if (RPG.jugador.getInventario().getItem5() != null && RPG.jugador.getInventario().getItem5().getNombre().equals(objAct.getNombre())) {						
						RPG.jugador.getInventario().getItem5().setCantidad(RPG.jugador.getInventario().getItem5().getCantidad() + objAct.getCantidad());						
					} else if (RPG.jugador.getInventario().getItem1() == null) {
						RPG.jugador.getInventario().setItem1(objAct);
					} else if (RPG.jugador.getInventario().getItem2() == null) {
						RPG.jugador.getInventario().setItem2(objAct);
					} else if (RPG.jugador.getInventario().getItem3() == null) {
						RPG.jugador.getInventario().setItem3(objAct);
					} else if (RPG.jugador.getInventario().getItem4() == null) {
						RPG.jugador.getInventario().setItem4(objAct);
					} else if (RPG.jugador.getInventario().getItem5() == null) {
						RPG.jugador.getInventario().setItem5(objAct);
					}  else {
						maxObjetosAct(objAct);
					}
				
		
				
				opcionValida = true;							
				break;
			case "2":
				System.out.println(objAct.getDescripcion());
				sc.nextLine();
				break;
			case "3":				
				opcionValida = true;				
				break;
			
			default:
				System.out.println("Debe introducir una opcion valida");
				break;
				
			}
		}
		
	}

	private static void maxObjetosAct(ObjetoActivo objAct) {
		Boolean opcionValida = false;
		
		while(!opcionValida) { 
			System.out.println("No puedes llevar mas objetos consumibles");
			System.out.println("Que desea hacer con el objeto?" +
							"\n\t1_Sustituir " + RPG.jugador.getInventario().getItem1().getNombre() +
							"\n\t2_Sustituir " + RPG.jugador.getInventario().getItem2().getNombre() +
							"\n\t3_Sustituir " + RPG.jugador.getInventario().getItem3().getNombre() +
							"\n\t4_Sustituir " + RPG.jugador.getInventario().getItem4().getNombre() +
							"\n\t5_Sustituir " + RPG.jugador.getInventario().getItem5().getNombre() +
							"\n\t6_TIRAR");
			
			String opcion = sc.nextLine();
			
				switch (opcion.toLowerCase()) {
			case "1":
				RPG.jugador.getInventario().setItem1(objAct);
				opcionValida = true;							
				break;
			case "2":
				RPG.jugador.getInventario().setItem2(objAct);
				opcionValida = true;
				break;
			case "3":
				RPG.jugador.getInventario().setItem3(objAct);	
				opcionValida = true;				
				break;
			case "4":
				RPG.jugador.getInventario().setItem4(objAct);
				opcionValida = true;
				break;
			case "5":
				RPG.jugador.getInventario().setItem5(objAct);
				opcionValida = true;
				break;
			case "6":
				opcionValida = true;
				break;
			default:
				System.out.println("Debe introducir una opcion valida");
				break;
				
			}
		}
		
	}

	private static ObjetoActivo generarPocion() {		
		Random rd = new Random();
		
		
		int tipoPocion = rd.nextInt(250 - 0) + 0;
		String nombre  = "pocion ";
		
		if (tipoPocion > 150 && tipoPocion <= 200 && RPG.PISO > 5) {
			nombre += "media";
		} else if (tipoPocion > 200 && RPG.PISO > 15){
			nombre += "concentrada";
		} else {
			nombre += "simple";
		}
		
		
		
		int intensidad = 0;
		if (nombre.equals("pocion simple")) {
			intensidad = 50;
		} else if (nombre.equals("pocion media")) {
			intensidad = 150;
		} else {
			intensidad = 300;
		}
		
		String descripcion = "cura " + intensidad + " puntos de vida";
		int posCantMedia = 0;
		
		int cantidad = 0;
		if (nombre.equals("pocion simple")) {
			cantidad = rd.nextInt((RPG.jugador.getNivel()*10-RPG.PISO) - 1) + 1;
			if (cantidad > 80) {
				cantidad = 80;
			}
		} else if (nombre.equals("pocion media")) {
			cantidad = rd.nextInt((RPG.PISO) - RPG.PISO) + RPG.PISO;
			if (cantidad > 45) {
				cantidad = 45;
			}
		} else {
			posCantMedia = rd.nextInt(100 - 1) + 1;
			if (posCantMedia <=75) {
				cantidad = 1;
			} else if (posCantMedia > 75 && posCantMedia <= 90) {
				cantidad = 3;
			} else {
				cantidad = 5;
			}
			
		}
		
		
		
		ObjetoActivo objAct = new ObjetoActivo(nombre, descripcion, "cura", intensidad, cantidad);	
		
		return objAct;
	}
}
