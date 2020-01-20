import java.util.ArrayList;
import java.util.List;

public class Rocket {
String code;
int thrustersAmount;
List<Thruster> thrusters = new ArrayList<Thruster>();
List<Integer> maxPowers = new ArrayList<Integer>();
public Rocket(String code, int thrustersAmount, List<Integer> maxPowers) {
	super();
	this.code = code;
	this.thrustersAmount = thrustersAmount;
	this.maxPowers = maxPowers;
	for (int i = 0; i<thrustersAmount; i++) {
		Thruster thruster = new Thruster(maxPowers.get(i));
		thruster.start();
		thrusters.add(thruster);
	}
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



}
