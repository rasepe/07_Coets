import java.util.Scanner;

public class Thruster extends Thread {
	private static Scanner sc = new Scanner(System.in);
	int maxPower;
	int currentPower; // s'inicialitza a 0;
	int desiredPower;
	boolean accelera = false;
	private Rocket currentRocket;

	
	public Thruster(int maxPower, Rocket currentRocket) {
		super();
		this.maxPower = maxPower;
		this.currentPower = 0;
		this.desiredPower = 0;
		this.currentRocket = currentRocket;
	}

	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

	public int getDesiredPower() {
		return desiredPower;
	}

	public void setDesiredPower(int desiredPower) {
		this.desiredPower = desiredPower;
	}

	public boolean isAccelera() {
		return accelera;
	}

	public void setAccelera(boolean accelera) {
		this.accelera = accelera;
	}

	// for (int i=0 ; i<) {

//sc.nextLine();
	// int option = sc.nextInt();
	// accelera
	/*
	 * if (accelera) { if (getCurrentPower()+5 <= maxPower) { //currentPower+=5;
	 * setCurrentPower(currentPower+=5); } else { return; } } else { if
	 * (getCurrentPower()-5 >= 0) { //currentPower-=5;
	 * setCurrentPower(currentPower-=5); } else { return; } }
	 */

	volatile boolean finished = false;

	
	  public void stopMe() { 
		  finished = true;
	  System.out.println("Matat el fil "+Thread.currentThread().getName()); //
	 System.out.println(Thread.currentThread().isAlive()); 
	 }
	 

	public void run() {
		// ACCELERA FINS POTENCIA OBJECTIU I SURT
		//

		//System.out.println("Creat el fil " + Thread.currentThread().getName());

		while (!finished) {
			
			if (currentPower < desiredPower && currentPower < maxPower) {
				currentPower++;
				Main.printRocket(currentRocket);
			}
			if (currentPower > desiredPower && currentPower > 0) {
				currentPower--;
				Main.printRocket(currentRocket);
			}
			
			/*
			 * try { sleep(4500); } catch (InterruptedException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */

				
				//System.out.println("\n");

		//	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
			/*
			 * if (currentPower == maxPower || currentPower == 0 || currentPower ==
			 * desiredPower) { this.stop(); break;
			 * 
			 * try { sleep(10000000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 * 
			 * // try { // wait(); // } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block // e.printStackTrace(); // } // }
			 * 
			 * }
			 */
			// System.out.println("Matat el fil "+Thread.currentThread().getName());

		}

	}
}

// }
