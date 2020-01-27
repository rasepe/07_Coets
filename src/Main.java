import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		List<Rocket> rockets = new ArrayList<Rocket>();

		Rocket r1;
		Rocket r2;

		List<Integer> integers1 = new ArrayList<Integer>();
		List<Integer> integers2 = new ArrayList<Integer>();

		integers1.add(10);
		integers1.add(30);
		integers1.add(80);
		integers2.add(30);
		integers2.add(40);
		integers2.add(50);
		integers2.add(50);
		integers2.add(30);
		integers2.add(10);

		r1 = new Rocket ("32WESSDS", integers1);
		rockets.add(r1);
		r2 = new Rocket ("LDSFJA32", integers2);
		rockets.add(r2);

	
		
		

		


		


		
		  printRockets(rockets);
		  
		  for (int i=0; i<rockets.size(); i++) {
		  System.out.println("Velocitat inicial del coet " + (i+1) + "?");
		  rockets.get(i).setCurrentSpeed(sc.nextInt());
		  
		  System.out.println("La velocitat inicial del coet " + (i+1) + " és " +
		  rockets.get(i).getCurrentSpeed()); }
		  
		  sc.nextLine();
		  System.out.println("prem intro per mostrar velocitats actuals");
		  
		  sc.nextLine(); showSpeed(rockets);
		  
		  
		  
		  System.out.println("prem intro per accelerar tres cops"); sc.nextLine();
		  
		  
		  for (int i=0; i<rockets.size(); i++) {
		  
		  sleep(2000); rockets.get(i).accelerate(); rockets.get(i).accelerate();
		  rockets.get(i).accelerate();
		  
		  }
		  
		  
		  
		  sleep(2000);
		  
		  printRockets(rockets);
		  
		  
		  System.out.println("prem intro per mostrar velocitats"); sc.nextLine();
		  showSpeed(rockets);
		  
		  
		  
		  System.out.
		  println("prem intro per frenar cinc cops amb el primer coet (“32WESSDS”) i accelerar set amb el segon coet"
		  ); sc.nextLine();
		  
		  
		  for (int j=0; j<5; j++) { rockets.get(0).deaccelerate();
		  
		  } for (int j=0; j<7; j++) { rockets.get(1).accelerate();
		  
		  } sleep(2000);
		  
		  printRockets(rockets);
		  
		  System.out.println("prem intro per mostrar velocitats"); sc.nextLine();
		  showSpeed(rockets);
		 
			

			System.out.println("prem intro per accelerar 15 cops amb els dos coets");
			sc.nextLine();
			
			for (int i=0; i<rockets.size(); i++) {
				for (int j=0; j<15; j++) {
					rockets.get(i).accelerate();
					//sleep(1000);
				}
			}
			
sleep(2000);
			
			printRockets(rockets);
			System.out.println("prem intro per mostrar velocitats");
			sc.nextLine();
			showSpeed(rockets);

			//para els fils
		/*
		 * for (int i=0; i<rockets.size(); i++) { for (int j=0;
		 * j<rockets.get(i).getThrusters().size(); j++) {
		 * rockets.get(i).getThrusters().get(j).stop(); }
		 * 
		 * }
		 */
	      
	      System.out.println("FI DEL PROGRAMA");
	      
	      sc.close();
			System.exit(0);
	}

	static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	private static void showSpeed(List<Rocket> rockets) {
	
		
		
		
		
		//recalcula velocitat actual i la mostra
		
		for (int i=0; i<rockets.size(); i++) {
			rockets.get(i).setCurrentSpeed(rockets.get(i).getCurrentSpeed()+(100*Math.sqrt(rockets.get(i).getTotalUsedPower())));
			System.out.println((i+1) + ". Coet " + rockets.get(i).getCode() + ", velocitat actual: " + Math.round(rockets.get(i).getCurrentSpeed() * 100d) / 100d);
		}
		
	}

	
	static void printRocket(Rocket rocket) {
		System.out.print(rocket.getCode()+": ");
		for (int j=0; j<rocket.getThrusters().size(); j++) {
			
			System.out.print(rocket.getThrusters().get(j).getCurrentPower()+"/");
			System.out.print(rocket.getThrusters().get(j).getMaxPower()+" ");
			if (j==rocket.getThrusters().size()-1) {
				System.out.print("\n");
			}
		}
	}
	
	
	static void printRockets(List<Rocket> rockets) {
		//System.out.print(r.getComptador()+". ");
		
//		for (int i=0; i<r.getThrusters().size(); i++) {
//			r.getThrusters().get(i).pause();
//		}
		
		
		for (int i=0; i<rockets.size(); i++) {
			
			System.out.print((i+1)+". ");
		
		System.out.print("Coet: " + rockets.get(i).getCode()+". Potències: ");

		for (int j=0; j<rockets.get(i).getThrusters().size(); j++) {

			
			
			 
			//sleep(1000);
			//if (i<r.getMaxPowers().size()-1) {
				System.out.print(rockets.get(i).getThrusters().get(j).getCurrentPower()+"/");
			//} else {
			//	System.out.print(r.getThrusters().get(i).getCurrentPower());
			//}
				  if (j<rockets.get(i).getThrusters().size()-1) {
					  System.out.print(rockets.get(i).getThrusters().get(j).getMaxPower()+","); } else {
					  System.out.print(rockets.get(i).getThrusters().get(j).getMaxPower()); }
		}
		System.out.print("\n");
//		for (int i=0; i<r.getThrusters().size(); i++) {
//			r.getThrusters().get(i).resume();
//		}
		}
		
	}
	
	


	
	
	


}

