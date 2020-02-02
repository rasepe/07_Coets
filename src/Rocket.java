import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rocket {
	private String code;
	private List<Thruster> thrusters = new ArrayList<Thruster>();
	private List<Integer> maxPowers = new ArrayList<Integer>();
	private boolean firstTime = true;
	private int totalPotentialPower = 0;
	private int totalNeededPower;
	private int totalUsedPower = 0;
	private double currentSpeed;
	private int division;
	private int remainder;
	private int availableThrusters;
	private int distributedPower;
	private int totalAvailablePower;
	private List<Integer> neededPowers  = new ArrayList<Integer>();
	private int counter = 0;
	int thrusterPower = 0;
	Scanner sc = new Scanner(System.in);

	//CONSTRUCTOR:
	public Rocket(String code, List<Integer> maxPowers) {
		super();
		this.code = code;

		this.maxPowers = maxPowers;
		for (int i = 0; i < maxPowers.size(); i++) {

			Thruster thruster = new Thruster(maxPowers.get(i), this, i+1);

			thrusters.add(thruster);
		}

	}

	//GETTERS & SETTERS:
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<Integer> getNeededPowers() {
		return neededPowers;
	}

	public int getTotalUsedPower() {
		return totalUsedPower;
	}

	public void setTotalUsedPower(int totalUsedPower) {
		this.totalUsedPower = totalUsedPower;
	}

	public int getTotalPotentialPower() {
		totalPotentialPower=0;
		for (int i=0; i<thrusters.size(); i++) {
			totalPotentialPower += thrusters.get(i).getMaxPower();
		}
		return totalPotentialPower;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double d) {
		this.currentSpeed = d;
	}

	public int getTotalNeededPower() {
		return totalNeededPower;
	}

	public void setTotalNeededPower(int d) {
		this.totalNeededPower = d;
	}

	public String getCode() {
		return code;
	}

	public List<Thruster> getThrusters() {
		return thrusters;
	}



	//SEE ALSO: accelerate(double currentSpeed, double neededSpeed)
	public void accelerate() {
		//Initialize threads if they were not open before
		if (firstTime == true) {
			for (int i=0; i < thrusters.size(); i ++) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
			}
			Main.sleep(1000);
			firstTime = false;
		}

		for (int i=0; i < thrusters.size(); i ++) {
			thrusters.get(i).setNeededPower(thrusters.get(i).getCurrentPower()+1);
		}
		Main.sleep(1000);
	}



	//SEE ALSO: accelerate(double currentSpeed, double neededSpeed)
	public void decelerate() {

		//Initialize threads if they were not open before
		if (firstTime == true) {
			for (int i=0; i < thrusters.size(); i ++) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
			}
			Main.sleep(1000);
			firstTime = false;
		}


		for (int i=0; i < thrusters.size(); i ++) {
			if (thrusters.get(i).getCurrentPower()>0) {
				thrusters.get(i).setNeededPower(thrusters.get(i).getCurrentPower()-1);
			}
		}
		Main.sleep(1000);
	}



	//SEE ALSO: accelerate() & decelerate()
	public void accelerate(double currentSpeed, double neededSpeed) {
		setTotalUsedPower(0);
		//Initialize threads if they were not open before
		if (firstTime == true) {
			for (int i=0; i < thrusters.size(); i ++) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
			}
			Main.sleep(1000);
			firstTime = false;
		}

		setTotalNeededPower((int) (Math.pow((neededSpeed-currentSpeed)/100,2))); //Consider possibility of rounding as Math.ceil

		System.out.println("Per arribar a una velocitat de " + neededSpeed+ " partint d'una velocitat de " + currentSpeed +  " es necessita una potència de " + getTotalNeededPower());
		System.out.println("prem intro per repartir potències i accelerar");
		sc.nextLine();
		division = getTotalNeededPower()/thrusters.size();

		remainder = getTotalNeededPower()%thrusters.size();

		availableThrusters=0;

		distributedPower = 0;
		totalAvailablePower = 0;

		for (int i=0; i<maxPowers.size(); i ++) {
			totalAvailablePower+=maxPowers.get(i);
		}
		if (totalAvailablePower < getTotalNeededPower()) {
			System.out.println("No es pot accelerar fins a la velocitat indicada per falta de potència");
			System.out.println("La potència màxima d'aquest coet és " + totalAvailablePower);
			System.out.println("Vols accelerar fins a " +  + totalAvailablePower + "?");
			System.out.println("1. SI");
			System.out.println("2. NO");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				setTotalNeededPower(totalAvailablePower);
				division = getTotalNeededPower()/thrusters.size();
				remainder = getTotalNeededPower()%thrusters.size();
				execute();
			default:
				System.out.println("FI DEL PROGRAMA");
				System.exit(0);
			}

		} else {
			execute();
		}
	}



	public void execute() {
		distributeRemainder();

		if (distributedPower < getTotalNeededPower()) {
			distribute();

		}
		if (neededPowers.size()>0) {
			for (int i=0; i<thrusters.size(); i++) {
				thrusters.get(i).setNeededPower(neededPowers.get(i));
			}
		}

		Main.sleep(1000);
		showSpeed(this);
		printRocket(this);

	}




	private void distributeRemainder() {

		for (int i=0; i<thrusters.size(); i++) {
			if (getCounter() == 0) {
				if (remainder >0) {
					getNeededPowers().add(1);
					distributedPower++;
					remainder--;
					Main.sleep(1000);
				} else {
					getNeededPowers().add(0);
				}
			} else {

				if (remainder > 0) {

					if (getNeededPowers().get(i) < thrusters.get(i).getMaxPower()) {
						getNeededPowers().set(i,(getNeededPowers().get(i))+1);
						distributedPower++;
						remainder--;
					}


				}
			}

		}
	}



	private void distribute() {

		for (int i=0; i<thrusters.size(); i++) {

			thrusterPower = getNeededPowers().get(i); 

			if (thrusters.get(i).getMaxPower() >= division) {

				getNeededPowers().set(i,division);
				distributedPower+=division;
			} else {
				int initialPower = thrusterPower;
				getNeededPowers().set(i,thrusters.get(i).getMaxPower());
				distributedPower+=(thrusters.get(i).getMaxPower()-initialPower);
				remainder += division - thrusters.get(i).getMaxPower() + initialPower;

			}

		}

		check(getNeededPowers());			

	}



	private void distribute2() {

		for (int i=0; i<thrusters.size(); i++) {
			thrusterPower = getNeededPowers().get(i); 
			if (thrusterPower < thrusters.get(i).getMaxPower()) {
				getNeededPowers().set(i,thrusterPower+division);
			}
		}
	}



	private void check(List<Integer> list) {

		setCounter(getCounter()+1);
		for (int i=0; i<thrusters.size(); i++) {
			if (list.get(i) < thrusters.get(i).getMaxPower()) {
				availableThrusters++;
			}
		}
		division = remainder / availableThrusters;
		remainder = remainder  % availableThrusters;

		if (remainder > 0) {
			distributeRemainder();
		}

		if (division > 0) {
			distribute2();
		}

	}



	private static void showSpeed(Rocket rocket) {

		//recalculates current speed and shows it on screen
		rocket.setCurrentSpeed(rocket.getCurrentSpeed()+(100*Math.sqrt(rocket.getTotalUsedPower())));
		System.out.println("Velocitat assolida pel coet " + rocket.getCode() + ": " + Math.round(rocket.getCurrentSpeed() * 100d) / 100d);
	}



	private static void printRocket(Rocket rocket) {

		System.out.print("Coet: " + rocket.getCode()+". Potències: ");

		for (int j=0; j<rocket.getThrusters().size(); j++) {

			System.out.print(rocket.getThrusters().get(j).getCurrentPower()+"/");

			if (j<rocket.getThrusters().size()-1) {
				System.out.print(rocket.getThrusters().get(j).getMaxPower()+","); } else {
					System.out.print(rocket.getThrusters().get(j).getMaxPower()); }
		}
		System.out.print("\n");
	}
}