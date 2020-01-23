import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	//private static 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		List<Rocket> rockets = new ArrayList<Rocket>();
		int counter = 0;
		/*
		 * Realitza els seg�ents passos:
		 * 
		 * Creem dos coets amb els codis �x� I �LDSFJA32�. El primer coet tindr� tres
		 * propulsors i el segon sis propulsors.
		 * 
		 * Mostrar a pantalla el codi dels coets i el n�mero de propulsors que t�.
		 */



		/*
		 * Creem dos coets amb els codis �32WESSDS� I �LDSFJA32�. El primer coet tindr�
		 * tres propulsors (pot�ncia: 10,30,80) i el segon sis propulsors (pot�ncia:
		 * 30,40,50,50,30,10)
		 */
		Rocket r1;
		Rocket r2;
		Rocket r3;
		List<Integer> integers1 = new ArrayList<Integer>();
		List<Integer> integers2 = new ArrayList<Integer>();
		List<Integer> integers3 = new ArrayList<Integer>();
		integers1.add(10);
		integers1.add(30);
		integers1.add(80);
		integers2.add(30);
		integers2.add(40);
		integers2.add(50);
		integers2.add(50);
		integers2.add(30);
		integers2.add(10);
		integers3.add(40);
		r1 = new Rocket ("32WESSDS", integers1);
		rockets.add(r1);
		r2 = new Rocket ("LDSFJA32", integers2);
		rockets.add(r2);
		r3 = new Rocket ("XXXXXXXX", integers3);
		rockets.add(r3);
		//public Rocket(String code, int thrustersAmount, List<Integer> maxPowers)

		/*
		 * Mostrar a pantalla el codi dels coets, el n�mero de propulsors que t� i la
		 * pot�ncia m�xima de cada propulsor.
		 */
		boolean finish = false;
		//boolean firstTime = true;
		Rocket chosenRocket;
		int[] vegades = new int[rockets.size()];
		
		//List<Integer> desiredPowers = new ArrayList<Integer>();
		
		
		
		//prova
		
	//	r1.accelera(List<Thruster> thrusters, List<Integer> potenciesObjectiu);
		
		
		
	while (!finish) {
		

		//PAUSA TOTS ELS PROPULSORS
		
			/*
			 * for (int i=0; i<rockets.size(); i++) { for (int j=0;
			 * j<rockets.get(i).getThrusters().size(); j++ ) {
			 * rockets.get(i).getThrusters().get(j).pause(); }
			 * 
			 * 
			 * }
			 */
		
		
		System.out.println("Escull un coet");
		
		for (int i=0; i<rockets.size(); i++) {
			System.out.print((i+1)+". ");
			printRocket(rockets.get(i));
			
		}
		
		
		
		int option = sc.nextInt();
		chosenRocket = rockets.get(option-1);
		
		
		
		
		//SI �S LA PRIMERA VEGADA QUE ES TRIA L'OPCI�, EXECUTA START
		
			/*
			 * vegades[option-1]++; if (vegades[option-1]==1) { for (int i=0;
			 * i<chosenRocket.getThrusters().size(); i++) {
			 * chosenRocket.getThrusters().get(i).start(); }
			 * 
			 * }
			 */
		sc.nextLine();
		
		// REACTIVA TOTS ELS PROPULSORS
			/*
			 * for (int i=0; i<rockets.size(); i++) { for (int j=0;
			 * j<rockets.get(i).getThrusters().size(); j++ ) {
			 * rockets.get(i).getThrusters().get(j).resume(); }
			 * 
			 * 
			 * }
			 */
		
		System.out.println("Prem intro per accelerar-desaccelerar");
	//	System.out.println("1. Accelera");
		//System.out.println("2. Desaccelera");
		
		
		
		sc.nextLine();
		
		
		

			 
			  
			  
			 
		// if (accelerar == 1) {

				 
				/*
				 * chosenRocket.accelera(chosenRocket.getThrusters()); //SI �S LA PRIMERA VEGADA
				 * QUE S'ACCELERA EL COET, EXECUTA START
				 * 
				 * vegades[option-1]++;
				 * 
				 * for (int i=0; i<chosenRocket.getThrusters().size(); i++) { if
				 * (vegades[option-1]==1) { chosenRocket.getThrusters().get(i).start();
				 * System.out.println(chosenRocket.getThrusters().get(i).isAlive()); } }
				 */
						
						
						// ****TAMBE QUAN HEM DEIXAT A 0 I TORNEM A REACCELERAR
						
					
			 
			 
			 
			 //PREGUNTA POTENCIES OBJECTIU
			 
			/*
			 * for (int j=0; j<chosenRocket.getThrusters().size(); j ++) {
			 * chosenRocket.getThrusters().get(j).pause(); }
			 */
		//char arrayCaracteres[];
		int[] desiredPowers = new int[chosenRocket.getThrusters().size()];
			 for (int i=0; i<chosenRocket.getThrusters().size(); i ++) {
					/*
					 * int potenciaObjectiu; System.out.println("Pot�ncia objectiu del propulsor" +
					 * (i+1) + "?"); potenciaObjectiu = sc.nextInt(); if (vegades[option-1] == 0) {
					 * potenciesObjectiu.add(potenciaObjectiu); } else { potenciesObjectiu.set(i,
					 * potenciaObjectiu); }
					 */
				 int desiredPower; 
				
		
			//	 }
			
				 try {
 					Thread.sleep(1000);
 					//Thruster.sleep(1000);
 				} catch (InterruptedException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
				 
				 System.out.println("Pot�ncia objectiu del propulsor " + (i+1) + "?"); 
				 
				 desiredPower = sc.nextInt(); 
					
				//GUARDA A ARRAY DE POTENCIES OBJECTIU;
				 
				 //desiredPowers.add(desiredPower);
				// desiredPowers[i]=desiredPower;
				 
				 
		
				 
				 
				 
				 chosenRocket.getThrusters().get(i).setDesiredPower(desiredPower);
				 
			
			
			 }
			 //System.out.println(desiredPowers);
			 //llegeix ARRAY I EXECUTA SETDESIREDPOWER
			 
			
			/*
			 * for (int i=0; i<chosenRocket.getThrusters().size(); i++) {
			 * chosenRocket.getThrusters().get(i).setDesiredPower(desiredPowers[i]);
			 * 
			 * 
			 * }
			 */
			 
			 
			 
			/*
			 * for (int j=0; j<chosenRocket.getThrusters().size(); j ++) {
			 * chosenRocket.getThrusters().get(j).resume(); }
			 */
			 
			// vegades[option-1]++;
			 
			 // CRIDA AL M�TODE ACCELERAR
			// chosenRocket.accelera(chosenRocket.getThrusters(),potenciesObjectiu); 
			 chosenRocket.accelera(); 
			 
			 
			 
			 
			 
			 /*	} 
				 * else { //DESACCELERAR
				 * 
				 * //SI HEM ARRIBAT AL TOPE DEL PROPULSOR I BAIXEM, CREA NOU FIL for (int i=0;
				 * i<chosenRocket.getThrusters().size(); i++) { if
				 * (chosenRocket.getThrusters().get(i).getCurrentPower() ==
				 * chosenRocket.getThrusters().get(i).getMaxPower()) {
				 * 
				 * System.out.println(chosenRocket.getThrusters().get(i).isAlive());
				 * System.out.println(chosenRocket.getThrusters().get(i).getName());
				 * 
				 * // System.out.println("Aqu� haur�em de crear fil de nou, per� dona error"); }
				 * else { System.out.println(chosenRocket.getThrusters().get(i).isAlive());
				 * 
				 * 
				 * } }
				 * 
				 * //crida al metode desaccelerar
				 * chosenRocket.desaccelera(chosenRocket.getThrusters());
				 * 
				 * }
				 */
			

		
	}
		

		
		
		/*
		 * for (int i=0; i<r1.thrusters.size(); i++) {
		 * 
		 * System.out.println(r1.thrusters.get(i));
		 * 
		 * System.out.println(r1.thrusters.get(i).getMaxPower());
		 * 
		 * System.out.println(r1.thrusters.get(i).getCurrentPower()); }
		 * System.out.println("**********************************"); for (int i=0;
		 * i<r2.thrusters.size(); i++) {
		 * 
		 * System.out.println(r2.thrusters.get(i));
		 * 
		 * System.out.println(r2.thrusters.get(i).getMaxPower());
		 * 
		 * System.out.println(r2.thrusters.get(i).getCurrentPower()); }
		 * System.out.println("**********************************"); for (int i=0;
		 * i<r3.thrusters.size(); i++) {
		 * 
		 * System.out.println(r3.thrusters.get(i));
		 * 
		 * System.out.println(r3.thrusters.get(i).getMaxPower());
		 * 
		 * System.out.println(r3.thrusters.get(i).getCurrentPower()); }
		 * 
		 * System.out.println("holi");
		 */
	}

	static void printRocket(Rocket r) {
		//System.out.print(r.getComptador()+". ");
		System.out.print(r.getCode()+": ");

		for (int i=0; i<r.getThrusters().size(); i++) {

			
			
			 
			
			//if (i<r.getMaxPowers().size()-1) {
				System.out.print(r.getThrusters().get(i).getCurrentPower()+"/");
			//} else {
			//	System.out.print(r.getThrusters().get(i).getCurrentPower());
			//}
				  if (i<r.getThrusters().size()-1) {
					  System.out.print(r.getThrusters().get(i).getMaxPower()+","); } else {
					  System.out.print(r.getThrusters().get(i).getMaxPower()); }
		}
		System.out.print("\n");
	}
	
	
	


}

