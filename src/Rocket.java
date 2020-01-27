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

	public void setTotalDesiredPower(int totalDesiredPower) {
		this.totalDesiredPower = totalDesiredPower;
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


}