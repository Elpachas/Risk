package Proyecto_Risk;

import java.util.Scanner;

public class Risk {
	/**
	 * DEFINICIÓ DE CONSTANTS
	 */

	/**
	 * Véctor (array) amb els noms dels continents. La posició del continent
	 * dins del vector l'identifica en les diferents matrius o arrays on es
	 * relaciona. Seria la seva clau primària.
	 */
	public static final String[] continents = { "Amèrica Nord", "Amèrica Sud", "Àfrica", "Europa", "Àsia", "Oceania" };

	/**
	 * Vector (array) amb els noms dels territoris. Es relacionen amb el seu
	 * continent ja que el nombre de fila correspon a la posició del array
	 * continents.
	 *
	 * territoris[0] -> Correspondrà als territoris del continent[0] Amèrica del
	 * Nord territoris[1] -> Correspondrà als territoris del continent[1]
	 * Amèrica Sud
	 */
	public static final String[] territoris = { "Alaska", "Territorio del nor-oeste", "Groenlandia", "Alberta",
			"Ontario", "Labrador", "Territorio del oeste", "Territorio del este", "America central", "Venezuela",
			"Perú", "Argentina", "Brasil", "África del norte", "Egipto", "Africa Oriental", "Congo", "África del sur",
			"Magadascar", "Europa Occidental", "Gran Bretaña", "Islandia", "Escandinavia", "Europa del norte",
			"Europa del sur", "Ucrania", "Ural", "Afganistan", "Oriente Medio", "Siberia", "Yakutia", "Chita",
			"Kamchatka", "Mongolia", "Japon", "China", "Siam", "India", "Indonesia", "Nueva Guinea",
			"Australia Occidental", "Australia Oriental" };

	/**
	 * Matriu (array de dues dimensions) que ens permet identificar els païssos
	 * veïns i així poder moure exèrcits entre ells o atacar. Segons moment de
	 * la partida.
	 */
	// public static final String[][] fronteres={{"Alaska,Kamchatka"}};
	public static final String[][] veins = { { "Alaska,Kamchatka" } };

	/**
	 * Véctor (array) amb els objectius del joc. La posició de l'objectiu dins
	 * del vector l'identifica en les diferents matrius o arrays on es
	 * relaciona. Seria la seva clau primària.
	 */
	public static final String[] objectius = { "Amèrica sur i Àfrica", "Amèrica del nord i Oceania", "Àfrica i Àsia" };

	/**
	 * Véctor (array) amb la quantitat d'exèrcits inicials. En la posició 0
	 * correspon a 3 jugadors i la posició 3 a 6 jugadors.
	 */
	public static final int[] exercitsInicials = { 35, 30, 25, 20 };

	/**
	 * Véctor (array) amb la quantitat d'exèrcits que guanyes per continent
	 * conquistat. En la posició 0 correspon a Amèrica del Nord i la 5 a
	 * Oceania.
	 */
	public static final int[] continentsComplets = { 5, 2, 3, 5, 7, 2 };

	/**
	 * Nombre que divideix els païssos conquerits per saber les unitats de
	 * reforç.
	 */
	public static final int divisioTerritori = 3;
	/**
	 * Nombre màxims de jugadors que poden jugar al DamRISK.
	 */
	public static final int maxJugadors = 6;
	/**
	 * Nombre mínim de jugadors que poden jugar al DamRISK.
	 */
	public static final int minJugadors = 3;

	public static void main(String[] args) {
		/**
		 * Matriu que representa el tauler de joc. Cada posició té un array on
		 * es guarda la informació següent {Id jugador, Número exercits} Cada
		 * posició és un territori.
		 */
		int[][] tauler = new int[42][2];

		/**
		 * Inicialitzem el tauler sense jugadors, valor -1. Doncs el jugador 0
		 * existeix
		 */
		for (int territori = 0; territori < tauler.length; territori++) {
			tauler[territori][0] = -1;
		}

		/**
		 * Vector per guardar els noms dels jugadors. La posició dins del vector
		 * és l'identificador de jugador.
		 */
		String[] nomsJugadors = null;
		/**
		 * Matriu on guardem la informació del joc per a cada jugador. On
		 * guardem la informació del jugador. Per a cada jugador guardem
		 * nomsJugadors[0] li correspon la infoJugadors {objectiu, cavalleria,
		 * artilleria, cano, comodi }
		 */
		int[][] infoJugadors = null;

		/**
		 * Enter que indicarà el nombre de jugador que li toca tirar.
		 */
		int torn = 0;

		/**
		 * Java.util.Scanner ens permet llegir de consola les dades dels usuaris
		 */
		// TODO Codi per demanar el nombre de jugadors
		Scanner lector = new Scanner(System.in);
		boolean correcto;
		int num_jugadors = 0;
		int CantExer;
		int numeroAleatorio;
		int TerAleatorio;
		do {
			lector = new Scanner(System.in);
			System.out.println("Cuantos jugadores?");
			correcto = lector.hasNextInt();

			// si no es correcto escribira error
			if (!correcto) {
				System.out.println("El valor es erroneo");
			} else {
				num_jugadors = lector.nextInt();
				if (num_jugadors < minJugadors || num_jugadors > maxJugadors) {
					System.out.println("Min 3, Max 6");
				}
			}
		} while ((!correcto) || ((num_jugadors < minJugadors) || (num_jugadors > maxJugadors)));

		// TODO Dimensionar els vectors nomsJugadors i infoJugadors
		nomsJugadors = new String[num_jugadors];
		infoJugadors = new int[num_jugadors][5];

		// TODO Calcular nombre d'exèrcits inicials
	
		CantExer = Exercits(num_jugadors);
		
//		COMPROVACION DE QUE ESTA BIEN ASIGNADA		
//		System.out.println(CantExer);
										
		// TODO Demanar les dades als jugadors i preparar-los per poder iniciar
		// el joc.
		for (int jugador = 0; jugador < num_jugadors; jugador++) {

			// TODO Demanar el nom i guardar-ho en el vector
			System.out.println("Dime tu nombre jugador "+jugador);
			nomsJugadors[jugador] = lector.next();

			// TODO Assignar objetiu
			numeroAleatorio = (int) (Math.random() * objectius.length + 0);
			infoJugadors[jugador][0] = numeroAleatorio;
			System.out.println("tu objetivo es " + objectius[infoJugadors[jugador][0]]);

			// TODO Repartir territorios

			switch (num_jugadors) {
			case 3:
				int ter3 = (territoris.length) / 3;
				for (int territori = 0; territori < ter3; territori++) {
					do{
						TerAleatorio = (int) (Math.random() * territoris.length + 0);					
					}while((tauler[TerAleatorio][0]> -1));
					tauler[TerAleatorio][0] = jugador;
//					para comprobrar que no se repita
//					System.out.println(	territoris[TerAleatorio]);
					}
				break;
			case 6:
				int ter6 = (territoris.length) / 6;
				TerAleatorio = (int) (Math.random() * territoris.length + 0);
				for (int territori = 0; territori < ter6; territori++) {
					do{
						TerAleatorio = (int) (Math.random() * territoris.length + 0);					
					}while((tauler[TerAleatorio][0]> -1));
					tauler[TerAleatorio][0] = jugador;
//					para comprobrar que no se repita
//					System.out.println(	territoris[TerAleatorio]);
					}
				break;
			case 4:
			case 5:
				int ter45 = (territoris.length-2) /num_jugadors;
				
				if(jugador==0 | jugador==1){
				int a=0;
				do{
					
					TerAleatorio = (int) (Math.random() * territoris.length + 0);
						tauler[TerAleatorio][0] = jugador;				
					a++;
//					para comprobrar que no se repita
//					System.out.println(	territoris[TerAleatorio]);
				}while((tauler[TerAleatorio][0]> -1) && a<1);
				}
				
				for (int territori = 0; territori < ter45; territori++) {
					
					do{
						TerAleatorio = (int) (Math.random() * territoris.length + 0);					
					}while((tauler[TerAleatorio][0]> -1));
					tauler[TerAleatorio][0] = jugador;
//					para comprobrar que no se repita
//					System.out.println(	territoris[TerAleatorio]);				
					}
				
				break;
			}

			// TODO Assignar tropes

			System.out.println("Tienes "+ CantExer +" tropas");
			
			int resttropas=0;
			int inicial=1;
			for(int territori=0;territori<tauler.length;territori++){
				if(tauler[territori][0]==jugador){
					
					tauler[territori][1]=inicial;
					resttropas++;
				}
			}
			
			int tropasdisp = CantExer-resttropas;
			boolean correcto2;
			
			for(int territori=0;territori<tauler.length;territori++){
				
				int cantropas=0;
				
				if(tauler[territori][0]==jugador){
				System.out.println("En este territorio "+territoris[territori]+" tienes: "+tauler[territori][1]+" tropas");
					
					do{
						lector = new Scanner(System.in);
						System.out.println("Cuantas tropas quieres asignar?(minimo 0 maximo "+ tropasdisp+" )");	
						correcto2 = lector.hasNextInt();
						
							if (!correcto2) {
								System.out.println("El valor es erroneo");
							
								}else{
									cantropas=lector.nextInt();
									
											if(cantropas>0 && cantropas<=tropasdisp){
												
											tauler[territori][1]=inicial+cantropas;
																						
											}
											
									  }
						} while((correcto2==false)||(cantropas<0||cantropas>tropasdisp));
					tropasdisp=tropasdisp-cantropas;
					if(tropasdisp<=0){
						System.out.println("No te quedan tropas");
						break;
					}
				}
				
			}

			
		}
		// TODO Decidir qui comença a jugar i dir-ho per pantalla
		torn = (int) (Math.random() * num_jugadors + 0);
		System.out.println("Empieza el jugador " + torn + "-" + nomsJugadors[torn]);
		
		/**
		 * Pinta el tauler com ha quedat
		 */
		for (int territori = 0; territori < tauler.length; territori++) {
			System.out.println(
					territoris[territori] + "-" + nomsJugadors[tauler[territori][0]] + "-" + tauler[territori][1]);
		}
	}

	public static int Exercits(int a) {
		switch (a) {
		case 3:
			a = exercitsInicials[0];

			break;
		case 4:
			a = exercitsInicials[1];
			break;
		case 5:
			a = exercitsInicials[2];
			break;
		case 6:
			a = exercitsInicials[3];
			break;
		}
		return a;

	}

}