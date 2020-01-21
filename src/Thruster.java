import java.util.Scanner;

public class Thruster extends Thread {
	private static Scanner sc = new Scanner(System.in);
	int maxPower;
	int currentPower; //s'inicialitza a 0;
	boolean accelera = false;
	public Thruster(int maxPower) {
		super();
		this.maxPower = maxPower;
		this.currentPower = 0;
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





	public boolean isAccelera() {
		return accelera;
	}





	public void setAccelera(boolean accelera) {
		this.accelera = accelera;
	}





	public void run()  
	{    
		//	for (int i=0 ; i<) {

	
//sc.nextLine();
		//int option = sc.nextInt();
		//accelera
		/*
		 * if (accelera) { if (getCurrentPower()+5 <= maxPower) { //currentPower+=5;
		 * setCurrentPower(currentPower+=5); } else { return; } } else { if
		 * (getCurrentPower()-5 >= 0) { //currentPower-=5;
		 * setCurrentPower(currentPower-=5); } else { return; } }
		 */

	}

	//}    

}
