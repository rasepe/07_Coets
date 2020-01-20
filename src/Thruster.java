
public class Thruster extends Thread {
int maxPower;
int currentPower; //s'inicialitza a 0;
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


public void run()  
{    

}    

}
