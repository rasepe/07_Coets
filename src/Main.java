import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) { 
		List<Rocket> rockets = new ArrayList<Rocket>();
		/*
		 * Realitza els següents passos:
		 * 
		 * Creem dos coets amb els codis “x” I “LDSFJA32”. El primer coet tindrà tres
		 * propulsors i el segon sis propulsors.
		 * 
		 * Mostrar a pantalla el codi dels coets i el número de propulsors que té.
		 */



		/*
		 * Creem dos coets amb els codis “32WESSDS” I “LDSFJA32”. El primer coet tindrà
		 * tres propulsors (potència: 10,30,80) i el segon sis propulsors (potència:
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
		r1 = new Rocket ("32WESSDS", 3, integers1);
		rockets.add(r1);
		r2 = new Rocket ("LDSFJA32", 6, integers2);
		rockets.add(r2);
		r3 = new Rocket ("XXXXXXXX", 1, integers3);
		rockets.add(r3);
		//public Rocket(String code, int thrustersAmount, List<Integer> maxPowers)

		/*
		 * Mostrar a pantalla el codi dels coets, el número de propulsors que té i la
		 * potència màxima de cada propulsor.
		 */
		boolean finish = false;
		//boolean firstTime = true;
		Rocket chosenRocket;
		int[] vegades = new int[rockets.size()];
	while (!finish) {
		
		for (int i=0; i<rockets.size(); i++) {
			System.out.print((i+1)+". ");
			printRocket(rockets.get(i));
			
		}
		
		System.out.println("Escull un coet");
		
		int option = sc.nextInt();
		chosenRocket = rockets.get(option-1);
		//SI ÉS LA PRIMERA VEGADA QUE ES TRIA L'OPCIÓ, EXECUTA START
		
			/*
			 * vegades[option-1]++; if (vegades[option-1]==1) { for (int i=0;
			 * i<chosenRocket.getThrusters().size(); i++) {
			 * chosenRocket.getThrusters().get(i).start(); }
			 * 
			 * }
			 */
		
		System.out.println("Escull una opció");
		System.out.println("1. Accelera");
		System.out.println("2. Desaccelera");
		
		
		
		int accelerar = sc.nextInt();
		
		
		

			 
			  
			  
			 
			 if (accelerar == 1) {
				 chosenRocket.accelera(chosenRocket.getThrusters());
				//SI ÉS LA PRIMERA VEGADA QUE S'ACCELERA EL COET, EXECUTA START
					
					vegades[option-1]++;
					   
						for (int i=0; i<chosenRocket.getThrusters().size(); i++) {
							if (vegades[option-1]==1) {
							chosenRocket.getThrusters().get(i).start();
							System.out.println(chosenRocket.getThrusters().get(i).isAlive());
							}
						}
						
						
						// ****TAMBE QUAN HEM DEIXAT A 0 I TORNEM A REACCELERAR
						
					
			  
			  
			  } else { 
				  //DESACCELERAR
				  
				  //SI HEM ARRIBAT AL TOPE DEL PROPULSOR I BAIXEM, CREA NOU FIL
				 for (int i=0; i<chosenRocket.getThrusters().size(); i++) {
						if (chosenRocket.getThrusters().get(i).getCurrentPower() == chosenRocket.getThrusters().get(i).getMaxPower()) {
						
						System.out.println(chosenRocket.getThrusters().get(i).isAlive());
						System.out.println(chosenRocket.getThrusters().get(i).getName());
		
						//	System.out.println("Aquí hauríem de crear fil de nou, però dona error");
						} else {
							System.out.println(chosenRocket.getThrusters().get(i).isAlive());
							
						
						}
				}
				  
				  //crida al metode desaccelerar
				  chosenRocket.desaccelera(chosenRocket.getThrusters()); 
		
			  }
			

		
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

	private static void printRocket(Rocket r) {
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

