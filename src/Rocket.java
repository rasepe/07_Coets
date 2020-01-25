import java.util.ArrayList;
import java.util.List;

public class Rocket {
	String code;
//int thrustersAmount;
	List<Thruster> thrusters = new ArrayList<Thruster>();
	List<Integer> maxPowers = new ArrayList<Integer>();
	int comptador = 0;
    //int currentSpeed = 0;
  //  int desiredSpeed;
	int totalPotentialPower = 0;
   int totalDesiredPower;
   int missingPower = 0;
   int totalUsedPower = 0;
   int surplusPower;
int objectiveSpeed;
double currentSpeed;
double maximumSpeed;





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
	//(int) Math.pow(this.getTotalPotentialPower(), 1/2);
	return maximumSpeed;
}

public void setMaximumSpeed(int maximumSpeed) {
	this.maximumSpeed = maximumSpeed;
}

	public int getObjectiveSpeed() {
	return objectiveSpeed;
}

public void setObjectiveSpeed(int objectiveSpeed) {
	this.objectiveSpeed = objectiveSpeed;
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
		
		surplusPower = 0;
		//missingPower = 0;
		//totalPotentialPower = 0;
		//PUJA POTENCIA TOTAL
		/*
		 * while (totalDesiredPower != missingPower) { if (totalDesiredPower >
		 * missingPower) { missingPower++; } else { // totalDesiredPower <
		 * missingPower missingPower--; }
		 * 
		 * }
		 */
		missingPower = totalDesiredPower;
		//REPARTEIX POTENCIA ENTRE PROPULSORS:
		//int[] desiredPowers = new int[this.getThrusters().size()];
		 for (int i=0; i<thrusters.size(); i ++) {
			
			 
			// System.out.println("Potència objectiu del propulsor " + (i+1) + "?"); 
			 if (missingPower >=  maxPowers.get(i)) {
				 this.getThrusters().get(i).setDesiredPower(maxPowers.get(i));
				// totalUsedPower = missingPower - maxPowers.get(i);
				 missingPower -= maxPowers.get(i);
				 
				 if (i==thrusters.size()-1) {
					 if (missingPower > 0) {
						
						 System.out.println("No s'ha pogut accelerar fins la velocitat indicada per falta de potència");

						 System.out.println("Ha faltat potència: " + missingPower);

						 System.out.println("Velocitat màxima aconseguida: " + (double)Math.round(getMaximumSpeed() * 100d) / 100d);
					 }
				 }
				 
				
			 } else {
				 this.getThrusters().get(i).setDesiredPower(missingPower);
				// surplusPower = missingPower;
				surplusPower += (maxPowers.get(i)-missingPower);
				missingPower = 0;
			 }
			 
			 
			 
			 
			 
		//	 desiredPowers[i]=sc.nextInt();
				
		 }
		
		 if (surplusPower > 0) {

			 //System.out.println("No s'ha pogut accelerar fins la velocitat indicada per falta de potència");
			 System.out.println("Ha sobrat potència: " + surplusPower);
		 }
		 
		 //si comptador = 0, inicialitza fils
		 if (comptador == 0) {
		 for (int i=0; i<thrusters.size(); i ++) {
		
				Thread t = new Thread(thrusters.get(i));
				t.start();
			
		 }
		 }
		comptador++;
	}
	
	
	public void accelerate() {
		//Inicia fils si no estan oberts
		 if (comptador == 0) {
		for (int i=0; i < thrusters.size(); i ++) {
			Thread t = new Thread(thrusters.get(i));
			t.start();
		}
		 }
		 comptador++;
		 for (int i=0; i < thrusters.size(); i ++) {
			 thrusters.get(i).setDesiredPower(thrusters.get(i).getCurrentPower()+5);
			 totalUsedPower+=5;
		 }
		
		 
	}
	
	
	public void frenar() {
		//Inicia fils si no estan oberts
		 if (comptador == 0) {
		for (int i=0; i < thrusters.size(); i ++) {
			Thread t = new Thread(thrusters.get(i));
			t.start();
		}
		 }
		 comptador++;
		 for (int i=0; i < thrusters.size(); i ++) {
			 thrusters.get(i).setDesiredPower(thrusters.get(i).getCurrentPower()-5);
			 totalUsedPower-=5;
		 }
		
	}

	/*
	 * NO NECESSARI public void desaccelera(List<Thruster> thrusters) { for (int
	 * i=0; i<thrusters.size(); i++) { if (thrusters.get(i).getCurrentPower() > 0) {
	 * thrusters.get(i).setCurrentPower(thrusters.get(i).getCurrentPower()-5); } } }
	 */

}
