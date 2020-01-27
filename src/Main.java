import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);

		//1. Creem dos coets amb els codis “32WESSDS” I “LDSFJA32”. 
		//El primer coet tindrà tres propulsors (potència màxima: 10,30,80) 
		//i el segon sis propulsors (potència màxima: 30,40,50,50,30,10).
		List<Rocket> rockets = new ArrayList<Rocket>();

		Rocket r1;
		Rocket r2;

		List<Integer> thrusters1 = new ArrayList<Integer>();
		List<Integer> thrusters2 = new ArrayList<Integer>();

		thrusters1.add(10);
		thrusters1.add(30);
		thrusters1.add(80);
		thrusters2.add(30);
		thrusters2.add(40);
		thrusters2.add(50);
		thrusters2.add(50);
		thrusters2.add(30);
		thrusters2.add(10);


		r1 = new Rocket ("32WESSDS", thrusters1);
		rockets.add(r1);
		r2 = new Rocket ("LDSFJA32", thrusters2);
		rockets.add(r2);

		//2. Mostrar a pantalla el codi dels coets, 
		//el número de propulsors que té i la potència màxima de cada propulsor.

		printRockets(rockets);

		//3. Mostrar a pantalla la velocitat actual dels coets (HEM AFEGIT PAS PREVI,
		//PREGUTAR VELOCITATS INICIALS
		for (int i=0; i<rockets.size(); i++) {
			System.out.println("Velocitat inicial del coet " + (i+1) + "?");
			rockets.get(i).setCurrentSpeed(sc.nextInt());

			System.out.println("La velocitat inicial del coet " + (i+1) + " és " +
					rockets.get(i).getCurrentSpeed()); }

		sc.nextLine();
		System.out.println("prem intro per mostrar velocitats actuals");
		sc.nextLine(); 
		showSpeed(rockets);

		//4.Accelerar amb els coets tres cops

		System.out.println("prem intro per accelerar tres cops"); sc.nextLine();

		for (int i=0; i<rockets.size(); i++) {
			sleep(2000);
			for (int j=0; j<3; j++) {
				rockets.get(i).accelerate(); 
				//	rockets.get(i).accelerate();
				//	rockets.get(i).accelerate();
			}
		}

		sleep(2000);

		printRockets(rockets);

		//5.Mostrar a pantalla la velocitat actual

		System.out.println("prem intro per mostrar velocitats"); sc.nextLine();

		showSpeed(rockets);

		//6.Frenar cinc cops amb el primer coet (“32WESSDS”) i accelerar set amb el segon coet.

		System.out.println("prem intro per frenar cinc cops amb el primer coet "
				+ "(“32WESSDS”) i accelerar set amb el segon coet"); 
		sc.nextLine();


		for (int j=0; j<5; j++) { 
			rockets.get(0).decelerate();
		} 

		for (int j=0; j<7; j++) { 
			rockets.get(1).accelerate();
		} 

		sleep(2000);

		printRockets(rockets);

		//7.Mostrar a pantalla la velocitat actual

		System.out.println("prem intro per mostrar velocitats"); sc.nextLine();
		showSpeed(rockets);

		//8.Accelerar 15 cops amb els dos coets.

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

		//9. Mostrar a pantalla la velocitat actual

		System.out.println("prem intro per mostrar velocitats");
		sc.nextLine();
		showSpeed(rockets);

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



	static void printRockets(List<Rocket> rockets) {


		for (int i=0; i<rockets.size(); i++) {

			System.out.print((i+1)+". ");

			System.out.print("Coet: " + rockets.get(i).getCode()+". Potències: ");

			for (int j=0; j<rockets.get(i).getThrusters().size(); j++) {

				System.out.print(rockets.get(i).getThrusters().get(j).getCurrentPower()+"/");

				if (j<rockets.get(i).getThrusters().size()-1) {
					System.out.print(rockets.get(i).getThrusters().get(j).getMaxPower()+","); } else {
						System.out.print(rockets.get(i).getThrusters().get(j).getMaxPower()); }
			}
			System.out.print("\n");

		}

	}


}

