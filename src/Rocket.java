import java.util.ArrayList;
import java.util.List;

public class Rocket {
	String code;
//int thrustersAmount;
	List<Thruster> thrusters = new ArrayList<Thruster>();
	List<Integer> maxPowers = new ArrayList<Integer>();
	int comptador = 0;

	public Rocket(String code, List<Integer> maxPowers) {
		super();
		this.code = code;
//	this.thrustersAmount = thrustersAmount;
		this.maxPowers = maxPowers;
		for (int i = 0; i < maxPowers.size(); i++) {
			// (new Thruster(maxPowers.get(i))).start();
			Thruster thruster = new Thruster(maxPowers.get(i), this, i+1);
			// thruster.start();
			thrusters.add(thruster);
		}
		// comptador++;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/*
	 * public int getThrustersAmount() { return thrustersAmount; } public void
	 * setThrustersAmount(int thrustersAmount) { this.thrustersAmount =
	 * thrustersAmount;
	 * 
	 * }
	 */
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

	/*
	 * public void accelera(List<Thruster> thrusters, List<Integer>
	 * potenciesObjectiu) {
	 * 
	 * for (int i=0; i<thrusters.size(); i++) {
	 * 
	 * if (thrusters.get(i).getCurrentPower() != thrusters.get(i).getMaxPower()) {
	 * 
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()+5); } }
	 * 
	 * //
	 * 
	 * for (int i=0; i<thrusters.size(); i++) {
	 * 
	 * //obre el fil si és el primer cop que accelerem el coet if (comptador == 0) {
	 * //Multi3 m1=new Multi3(); Thread t =new Thread(thrusters.get(i)); t.start();
	 * 
	 * //thrusters.get(i).start(); } for (int j=thrusters.get(i).getCurrentPower() ;
	 * j<potenciesObjectiu.get(i); j++) { try { //thrusters.get(i);
	 * Thread.sleep(500); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()+1);
	 * Main.printRocket(this); }
	 * 
	 * } comptador++;
	 * 
	 * }
	 */

	/* public void accelera(List<Integer> potenciesObjectiu) { */
	/*
	 * for (int i=0; i<thrusters.size(); i++) {
	 * 
	 * if (thrusters.get(i).getCurrentPower() != thrusters.get(i).getMaxPower()) {
	 * 
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()+5); } }
	 */
//

	/*
	 * for (int i=0; i<thrusters.size(); i++) { //obre el fil si és el primer cop
	 * que accelerem el coet if (comptador == 0) { thrusters.get(i).start(); } for
	 * (int j=thrusters.get(i).getCurrentPower() ; j<potenciesObjectiu.get(i); j++)
	 * { try { //thrusters.get(i); Thruster.sleep(500); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()+1);
	 * Main.printRocket(this); }
	 * 
	 * } comptador++;
	 * 
	 * }
	 */

	public void accelera() {

		for (int i = 0; i < thrusters.size(); i++) {
			if (comptador == 0) {
				Thread t = new Thread(thrusters.get(i));
				t.start();
				// thrusters.get(i).start();
			}
			try {
				Thread.sleep(1000);
				//Thruster.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// thrusters.get(i).interrupt();

		}
		comptador++;
		// Main.printRocket(this);
	}

	/*
	 * NO NECESSARI public void desaccelera(List<Thruster> thrusters) { for (int
	 * i=0; i<thrusters.size(); i++) { if (thrusters.get(i).getCurrentPower() > 0) {
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()-5); } } }
	 */

}
