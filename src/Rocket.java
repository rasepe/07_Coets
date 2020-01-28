import java.util.ArrayList;
import java.util.List;

public class Rocket {
	private String code;
	private List<Thruster> thrusters = new ArrayList<Thruster>();
	private List<Integer> maxPowers = new ArrayList<Integer>();
	private boolean firstTime = true;
	private int totalPotentialPower = 0;
	private int totalDesiredPower;
	private int totalUsedPower = 0;
	private double currentSpeed;
	private double maximumSpeed;



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

	public void setTotalPotentialPower(int totalPotentialPower) {
		this.totalPotentialPower = totalPotentialPower;
	}

	public double getMaximumSpeed() {
		maximumSpeed=this.getCurrentSpeed() + 100*(Math.sqrt(this.getTotalPotentialPower()));
		return maximumSpeed;
	}

	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}


	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(double d) {
		this.currentSpeed = d;
	}

	public int getTotalDesiredPower() {
		return totalDesiredPower;
	}

	public void setTotalDesiredPower(int d) {
		this.totalDesiredPower = d;
	}



	public Rocket(String code, List<Integer> maxPowers) {
		super();
		this.code = code;

		this.maxPowers = maxPowers;
		for (int i = 0; i < maxPowers.size(); i++) {

			Thruster thruster = new Thruster(maxPowers.get(i), this, i+1);

			thrusters.add(thruster);
		}

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Thruster> getThrusters() {
		return thrusters;
	}

	public void setThrusters(List<Thruster> thrusters) {
		this.thrusters = thrusters;
	}

	public List<Integer> getMaxPowers() {
		return maxPowers;
	}

	public void setMaxPowers(List<Integer> maxPowers) {
		this.maxPowers = maxPowers;
	}



	public void accelerate() {
		//Inicia fils si no estan oberts
		if (firstTime == true) {
			for (int i=0; i < thrusters.size(); i ++) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
			}
			Main.sleep(1000);
			firstTime = false;
		}

		for (int i=0; i < thrusters.size(); i ++) {
			thrusters.get(i).setDesiredPower(thrusters.get(i).getCurrentPower()+1);
		}
		Main.sleep(1000);
	}


	public void decelerate() {

		//Inicia fils si no estan oberts
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
				thrusters.get(i).setDesiredPower(thrusters.get(i).getCurrentPower()-1);
			}
		}
		Main.sleep(1000);
	}
	
	public void accelerate(double currentSpeed, double desiredSpeed) {
		setTotalUsedPower(0);
		//Inicia fils si no estan oberts
		if (firstTime == true) {
			for (int i=0; i < thrusters.size(); i ++) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
			}
			Main.sleep(1000);
			firstTime = false;
		}

		
		setTotalDesiredPower((int) Math.pow((desiredSpeed-currentSpeed)/100,2));
		int totalAvailablePower = 0;
		for (int i=0; i < thrusters.size(); i ++) {
			totalAvailablePower+=thrusters.get(i).getMaxPower();
		}
		for (int i=0; i < thrusters.size(); i ++) {
			//Si la potència total desitjada supera la del propulsor, utilitza
			//la potència màxima del propulsor
			if (getTotalDesiredPower() >= thrusters.get(i).getMaxPower()) {
				thrusters.get(i).setDesiredPower(thrusters.get(i).getMaxPower());
				setTotalDesiredPower(getTotalDesiredPower() - thrusters.get(i).getMaxPower());
				setTotalUsedPower(getTotalUsedPower()+thrusters.get(i).getMaxPower());
				if (i==thrusters.size()-1 && getTotalDesiredPower() > 0) {
					System.out.println("S'ha arribat a la potència màxima del coet");
					System.out.println("No s'ha pogut arribar a la velocitat desitjada");
					//showSpeed(this);
				}
			} else {
				//utilitza la potència remanent
				thrusters.get(i).setDesiredPower(getTotalDesiredPower());
				
				setTotalUsedPower(getTotalUsedPower()+getTotalDesiredPower());
				setTotalDesiredPower(0);
				//avisa que ha sobrat potència?
			
				
				//showSpeed(this);
				//surt del bucle
				//break;
			}
			
			
		}
		Main.sleep(1000);
		showSpeed(this);
	}

	private static void showSpeed(Rocket rocket) {

		//recalcula velocitat actual i la mostra
			rocket.setCurrentSpeed(rocket.getCurrentSpeed()+(100*Math.sqrt(rocket.getTotalUsedPower())));
			System.out.println("Velocitat assolida pel coet " + rocket.getCode() + Math.round(rocket.getCurrentSpeed() * 100d) / 100d);

	}

}