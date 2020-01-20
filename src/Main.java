import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) { 

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
		r2 = new Rocket ("LDSFJA32", 6, integers2);
		r3 = new Rocket ("XXXXXXXX", 1, integers3);
		//public Rocket(String code, int thrustersAmount, List<Integer> maxPowers)

		/*
		 * Mostrar a pantalla el codi dels coets, el número de propulsors que té i la
		 * potència màxima de cada propulsor.
		 */
		printRocket(r1);
		printRocket(r2);
		printRocket(r3);

		
		for (int i=0; i<r1.thrusters.size(); i++) {
	
		System.out.println(r1.thrusters.get(i));
		
		System.out.println(r1.thrusters.get(i).getMaxPower());
		
		System.out.println(r1.thrusters.get(i).getCurrentPower());
		}
		System.out.println("**********************************");
		for (int i=0; i<r2.thrusters.size(); i++) {
			
		System.out.println(r2.thrusters.get(i));
		
		System.out.println(r2.thrusters.get(i).getMaxPower());
		
		System.out.println(r2.thrusters.get(i).getCurrentPower());
		}
		System.out.println("**********************************");
		for (int i=0; i<r3.thrusters.size(); i++) {
			
		System.out.println(r3.thrusters.get(i));
		
		System.out.println(r3.thrusters.get(i).getMaxPower());
		
		System.out.println(r3.thrusters.get(i).getCurrentPower());
		}


	}

	private static void printRocket(Rocket r) {
		System.out.print(r.getCode()+": ");

		for (int i=0; i<r.getMaxPowers().size(); i++) {

			if (i<r.getMaxPowers().size()-1) {
				System.out.print(r.getMaxPowers().get(i)+",");
			} else {
				System.out.print(r.getMaxPowers().get(i));
			}
			
		}
		System.out.print("\n");
	}


}

