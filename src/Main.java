import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	//private static 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		List<Rocket> rockets = new ArrayList<Rocket>();
		boolean firstTime = true;

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

		boolean finish = false;

		Rocket chosenRocket;

		
		int totalDesiredPower;
		
		
		
	
		
		
	while (!finish) {
		

		if (!firstTime) {
		
		try {
			Thread.sleep(1000);
			//Thruster.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

		
	//	System.out.println("Escull un coet");
		
		for (int i=0; i<rockets.size(); i++) {
			System.out.print((i+1)+". ");
			printRocket(rockets.get(i));
			System.out.println("Velocitat actual del coet " + (i+1) + "?");
			rockets.get(i).setCurrentSpeed(sc.nextInt());
			System.out.println("La velocitat actual del coet " + (i+1) + " és " + rockets.get(i).getCurrentSpeed());
		}
		
		
		
	//	int option = sc.nextInt();
	//	chosenRocket = rockets.get(option-1);
		
		
		

		
		// PREGUNTA VELOCITAT
		

		//System.out.println("Velocitat desitjada?");
		//chosenRocket.setObjectiveSpeed(sc.nextInt());
		sc.nextLine();
		System.out.println("prem intro per accelerar tres cops");
		sc.nextLine();
		
			//for (int j=0; j<rockets.size(); j++) {
				
		for (int i=0; i<rockets.size(); i++) {
			for (int j=0; j<3; j++) {
				rockets.get(i).accelerate();
				try {
					Thread.sleep(1000);		
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
			}
		}
		
			
	//	}
		
		try {
			Thread.sleep(2000);		
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		for (int j=0; j<rockets.size(); j++) {
			printRocket(rockets.get(j));
		}

		//sc.next();
		System.out.println("prem intro per mostrar velocitats");
		sc.nextLine();
		
		
		//recalcula velocitat actual i la mostra
		
		for (int i=0; i<rockets.size(); i++) {
			rockets.get(i).setCurrentSpeed(rockets.get(i).getCurrentSpeed()+(100*Math.sqrt(rockets.get(i).getTotalUsedPower())));
			System.out.println((i+1) + ". Coet " + rockets.get(i).getCode() + ", velocitat: " + Math.round(rockets.get(i).getCurrentSpeed() * 100d) / 100d);
		}
		
		// **************FALTEN PUNTS 6 A 9
		
		
		//totalDesiredPower =  (int) Math.pow(((chosenRocket.getObjectiveSpeed()-chosenRocket.getCurrentSpeed())/100),2);
	    
		
		//chosenRocket.setTotalDesiredPower(totalDesiredPower);
		//chosenRocket.accelera(); 
		
		// RECALCULA VELOCITAT ACTUAL
		
		//if (totalDesiredPower < chosenRocket.getTotalPotentialPower()) {
		//	chosenRocket.setCurrentSpeed(chosenRocket.getObjectiveSpeed());
		//} else {
		//	chosenRocket.setCurrentSpeed((int) chosenRocket.getMaximumSpeed());
		//}
		
		
		
			/*
			 * //PREGUNTA POTENCIES OBJECTIU
			 * 
			 * int[] desiredPowers = new int[chosenRocket.getThrusters().size()]; for (int
			 * i=0; i<chosenRocket.getThrusters().size(); i ++) {
			 * 
			 * System.out.println("Potència objectiu del propulsor " + (i+1) + "?");
			 * 
			 * desiredPowers[i]=sc.nextInt();
			 * 
			 * } //GUARDA A ARRAY DE POTENCIES OBJECTIU; for (int i=0;
			 * i<chosenRocket.getThrusters().size(); i++) { for (int j=0;
			 * j<desiredPowers.length; j++) {
			 * chosenRocket.getThrusters().get(i).setDesiredPower(desiredPowers[j]); } }
			 */

			// chosenRocket.accelera(); 
			 
			 
			 
			 
			 
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
				 * // System.out.println("Aquí hauríem de crear fil de nou, però dona error"); }
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
			
		firstTime = false;
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
		
//		for (int i=0; i<r.getThrusters().size(); i++) {
//			r.getThrusters().get(i).pause();
//		}
		
		
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
//		for (int i=0; i<r.getThrusters().size(); i++) {
//			r.getThrusters().get(i).resume();
//		}
		
	}
	
	
	


}

