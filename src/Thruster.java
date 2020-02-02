public class Thruster implements Runnable {	

	private int maxPower;
	private int currentPower; 
	private int neededPower;
	private Rocket currentRocket;
	private int number;

	public Thruster(int maxPower, Rocket currentRocket, int number) {
		super();
		this.maxPower = maxPower;
		this.currentPower = 0;
		this.neededPower = 0;
		this.currentRocket = currentRocket;
		this.number = number;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setNeededPower(int d) {
		this.neededPower = d;
	}

	volatile boolean finished = false;


	@Override
	public void run() {


		while (!finished) {
			//ACCELERATE WHEN GIVEN THE CONDITIONS
			if (currentPower < neededPower && currentPower < maxPower) {

				currentPower ++;
				System.out.println(Thread.currentThread().getName() + " ACCELERANT PROPULSOR " + number + " DEL COET " + currentRocket.getCode() );
				currentRocket.setTotalUsedPower(currentRocket.getTotalUsedPower()+1);


			}
			//DEACCELERATE WHEN GIVEN THE CONDITIONS
			if (currentPower > neededPower && currentPower > 0) {

				currentPower--;
				System.out.println(Thread.currentThread().getName() + " DESACCELERANT PROPULSOR " + number + " DEL COET " + currentRocket.getCode());
				currentRocket.setTotalUsedPower(currentRocket.getTotalUsedPower()-1);


			} 
		}



	}


}

	


