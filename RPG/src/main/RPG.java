package main;


import java.util.ArrayList;


import entidades.Inventario;
import entidades.Jugador;
import entidades.ListaObjetosPasivos;
import entidades.ModeloMonstruo;
import entidades.ObjetoActivo;
import entidades.ObjetoPasivo;
import entidades.ListaModelosMonstruos;
import mapa.generacionMapa;

public class RPG {

	public static String TEXTO_PANTALLA = "";
	
	public static int ULTIMO_PISO = 100;
	
	public static int PISO = 5;
	
	public static int POSIBILIDAD_TESORO = 5;
	public static int POSIBILIDAD_OBJ_PAS = 20;
	public static int POSIBILIDAD_OBJ_ACT = 80;
	
	public static int POSIBILIDAD_ENEMIGO = 20;
	
	public static boolean clear = false;

	public static char[][] mapa;
	
	public static int contVictoria = 0;
	
	public static int EXPERIENCIA = 0;
	
	public static int posJugY = 0;
	public static int posJugX = 0;
	
	public static String monstruoAnterior = "";
	
	public static int TOTAL_MONSTRUOS;
	
	public static int VIDA_MAX = 350;
	
	public static int ITEM_EQUIPADOS = 0;
	
	public static int CONT_MONSTRUOS_DERROTADOS = 0;
	
	public static ArrayList<ModeloMonstruo> listaMonstruos;
	
	public static ArrayList<ObjetoPasivo> listaObjPas;
	
	public static ArrayList<ObjetoPasivo> listaObjEquipados;
	
	public static Jugador jugador = new Jugador(1, VIDA_MAX, 1, 45, new Inventario(null, null, null, null, new ObjetoActivo("pocion simple", "cura 50 puntos de vida", "cura", 50 , 15), null, null, null, null));
	
	public static void main(String[] args) {
	
		ListaModelosMonstruos listaModelosMonstruos = new ListaModelosMonstruos();
		listaMonstruos = listaModelosMonstruos.getListaMonstruos();
		
		ListaObjetosPasivos listaObjetosPasivos = new ListaObjetosPasivos();
		listaObjPas = listaObjetosPasivos.getListaPasivos();
		listaObjEquipados = new ArrayList<ObjetoPasivo>();
		while (PISO <= ULTIMO_PISO) {
			
			mapa = generacionMapa.generarMapa();
			
			TOTAL_MONSTRUOS = generacionMapa.contMonstruos(mapa);
			
			for (int i = 0; i < 50; ++i) System.out.println();
			
			System.out.println("PISO: " + PISO);
			generacionMapa.mostrarMapa(mapa);
			
			while(!clear) {
				generacionMapa.navegarMapa(mapa);
				for (int i = 0; i < 50; ++i) System.out.println();
				System.out.println("PISO: " + PISO);
				generacionMapa.mostrarMapa(mapa);
				
				if(TOTAL_MONSTRUOS >= PISO*5) {
					if(CONT_MONSTRUOS_DERROTADOS == PISO*5 && contVictoria == 0) {				
						
						mapa[mapa.length - 1][mapa[0].length - 1] = 'E';
						
						
						for (int i = 0; i < 50; ++i) System.out.println();
						generacionMapa.mostrarMapa(mapa);
						TEXTO_PANTALLA += "\nSE HA ABIERTO LA PUERTA";
						System.out.println("SE HA ABIERTO LA PUERTA");
						contVictoria ++;
					}
				} else {
					if(CONT_MONSTRUOS_DERROTADOS == TOTAL_MONSTRUOS && contVictoria == 0) {				
						
						mapa[mapa.length - 1][mapa[0].length - 1] = 'E';
						
						
						for (int i = 0; i < 50; ++i) System.out.println();
						generacionMapa.mostrarMapa(mapa);
						TEXTO_PANTALLA += "\nSE HA ABIERTO LA PUERTA";
						System.out.println("SE HA ABIERTO LA PUERTA");
						contVictoria ++;
					}
				}
				
				
				
				
			}
			
			PISO ++;
			
			jugador.getInventario().getItem1().setCantidad(jugador.getInventario().getItem1().getCantidad() + (PISO * 7));
			posJugY = 0;
			posJugX = 0;
			
			clear = false;
			contVictoria = 0;
			CONT_MONSTRUOS_DERROTADOS = 0;
		}
		
		TEXTO_PANTALLA += "\nHAS ESCAPADO DEL DUNGEON";
		System.out.println("HAS ESCAPADO DEL DUNGEON");
		
		

	}

}
