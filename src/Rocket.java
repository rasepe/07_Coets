import java.util.ArrayList;
import java.util.List;

public class Rocket {
String code;
int thrustersAmount;
List<Thruster> thrusters = new ArrayList<Thruster>();
List<Integer> maxPowers = new ArrayList<Integer>();
//int comptador = 0;
public Rocket(String code, int thrustersAmount, List<Integer> maxPowers) {
	super();
	this.code = code;
	this.thrustersAmount = thrustersAmount;
	this.maxPowers = maxPowers;
	for (int i = 0; i<thrustersAmount; i++) {
		//(new Thruster(maxPowers.get(i))).start();
		Thruster thruster = new Thruster(maxPowers.get(i));
		//thruster.start();
		thrusters.add(thruster);
	}
	//comptador++;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public int getThrustersAmount() {
	return thrustersAmount;
}
public void setThrustersAmount(int thrustersAmount) {
	this.thrustersAmount = thrustersAmount;
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

public void accelera(List<Thruster> thrusters) {
	for (int i=0; i<thrusters.size(); i++) {
			
			if (thrusters.get(i).getCurrentPower() != thrusters.get(i).getMaxPower()) {
		
		thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()+5);
		} 
	}
}

public void desaccelera(List<Thruster> thrusters) {
	for (int i=0; i<thrusters.size(); i++) {
		if (thrusters.get(i).getCurrentPower() > 0) {
		thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()-5);
		}
	}
}

}
