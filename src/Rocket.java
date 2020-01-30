import java.util.ArrayList;
import java.util.List;

public class Rocket {
	private String code;
	private List<Thruster> thrusters = new ArrayList<Thruster>();
	private List<Integer> maxPowers = new ArrayList<Integer>();
	private boolean firstTime = true;
	private int totalPotentialPower = 0;
	private int totalNeededPower;
	private int totalUsedPower = 0;
	private double currentSpeed;
	private double maximumSpeed;
	private int divisio;
	private int resta;
	private int propulsorsPendents;
	private int potenciaRepartida;
	private int totalAvailablePower;
	private List<Integer> neededPowers  = new ArrayList<Integer>();
private int counter = 0;
int potenciaPropulsor = 0;
private Integer antigaPotencia = 0;

	
	public int getCounter() {
	return counter;
}

public void setCounter(int counter) {
	this.counter = counter;
}

	public List<Integer> getNeededPowers() {
		return neededPowers;
	}

	public void setNeededPowers(List<Integer> neededPowers) {
		this.neededPowers = neededPowers;
	}

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

	public int getTotalNeededPower() {
		return totalNeededPower;
	}

	public void setTotalNeededPower(int d) {
		this.totalNeededPower = d;
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
			thrusters.get(i).setNeededPower(thrusters.get(i).getCurrentPower()+1);
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
				thrusters.get(i).setNeededPower(thrusters.get(i).getCurrentPower()-1);
			}
		}
		Main.sleep(1000);
	}
	
	public void accelerate(double currentSpeed, double neededSpeed) {
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

		
		setTotalNeededPower((int) (Math.pow((neededSpeed-currentSpeed)/100,2))); //Math.ceil
		
		System.out.println("Per arribar a " + neededSpeed+ " es necessita una potència de " + getTotalNeededPower());
		
		divisio = getTotalNeededPower()/thrusters.size();
		
	//	System.out.println("Entre " + thrusters.size() + " propulsors surt a repartir una potència de " + repartir + " unitats per cada propulsor");
		
		resta = getTotalNeededPower()%thrusters.size();
				
	//	System.out.println("A mes a mes repartirem " + sobren + " propulsor extra");
		
		propulsorsPendents=0;
		
		potenciaRepartida = 0;
		totalAvailablePower = 0;
		
		//List<Integer> neededPowers = new ArrayList<Integer>();
		
		for (int i=0; i<maxPowers.size(); i ++) {
			totalAvailablePower+=maxPowers.get(i);
		}
		if (totalAvailablePower < getTotalNeededPower()) {
			System.out.println("No es pot accelerar fins a la velocitat indicada per falta de potència");
			System.out.println("La potència màxima d'aquest coet és " + totalAvailablePower);
			//System.out.println("Donada la velocitat inicial " + getCurrentSpeed() + ", la velocitat màxima aproximada que pot assolir aquest coet és de " + ((getCurrentSpeed() + (double)Math.round(100 * Math.sqrt(totalAvailablePower) )  * 100d) / 100d) );   //Math.round
			System.out.println("FI DEL PROGRAMA");
			System.exit(0);
		} else {
			reparteixResta();
		//	while (potenciaRepartida < getTotalNeededPower()) {
			//	if (resta > 0) {
					//reparteixResta();
			//	}
			if (potenciaRepartida < getTotalNeededPower()) {
				reparteix();
				//comprova();
			}
		//	}
			
			
	//		while (getTotalUsedPower() < getTotalNeededPower()) {
			//for (int i=0; i<getTotalNeededPower(); i++) {
	//			accelerate();
				//MILLOR QUE REPARTEIXI getTotalNeededPower() ENTRE ELS PROPULSORS
				//i despres:
				//thrusters.get(i).setNeededPower(thrusters.get(i).getCurrentPower()+1);
			//}
	//		}	
		}
		
		if (neededPowers.size()>0) {
		//int totalNeededPower=0;
		for (int i=0; i<thrusters.size(); i++) {
		thrusters.get(i).setNeededPower(neededPowers.get(i));
		//Main.sleep(1000);
		}
		//setTotalNeededPower(totalNeededPower);
		}
		
//		for (int i=0; i<thrusters.size(); i++) {
//			if (thrusters.get(i).                                      () < repartir) {
//				thrusters.get(i).setNeededPower(thrusters.get(i).getMaxPower());
//				falten += (repartir-thrusters.get(i).getMaxPower());
//			} else {
//				if (sobren > 0) {
//					thrusters.get(i).setNeededPower(repartir+sobren);
//					
//					
//					sobren=0;
//				} else {
//					thrusters.get(i).setNeededPower(repartir);
//					
//				}
//			}
//		}
		

		
		/*
		 * for (int i=0; i<thrusters.size(); i++) {
		 * thrusters.get(i).setNeededPower((int)
		 * (getTotalNeededPower()/thrusters.size()));
		 * setTotalNeededPower(getTotalNeededPower()-thrusters.get(i).getNeededPower(
		 * )); Main.sleep(1000);
		 * 
		 * }
		 */
		Main.sleep(1000);
		showSpeed(this);
		printRocket(this);
		
		/*
		 * int totalAvailablePower = 0; for (int i=0; i < thrusters.size(); i ++) {
		 * totalAvailablePower+=thrusters.get(i).getMaxPower(); } for (int i=0; i <
		 * thrusters.size(); i ++) { //Si la potència total desitjada supera la del
		 * propulsor, utilitza //la potència màxima del propulsor if
		 * (getTotalNeededPower() >= thrusters.get(i).getMaxPower()) {
		 * thrusters.get(i).setNeededPower(thrusters.get(i).getMaxPower());
		 * setTotalNeededPower(getTotalNeededPower() -
		 * thrusters.get(i).getMaxPower());
		 * setTotalUsedPower(getTotalUsedPower()+thrusters.get(i).getMaxPower()); if
		 * (i==thrusters.size()-1 && getTotalNeededPower() > 0) {
		 * System.out.println("S'ha arribat a la potència màxima del coet");
		 * System.out.println("No s'ha pogut arribar a la velocitat desitjada");
		 * //showSpeed(this); } } else { //utilitza la potència remanent
		 * thrusters.get(i).setNeededPower(getTotalNeededPower());
		 * 
		 * setTotalUsedPower(getTotalUsedPower()+getTotalNeededPower());
		 * setTotalNeededPower(0);
		 * 
		 * }
		 * 
		 * 
		 * } Main.sleep(1000); showSpeed(this);
		 */
	}





	private void reparteixResta() {
		// TODO Auto-generated method stub
		for (int i=0; i<thrusters.size(); i++) {
			if (getCounter() == 0) {
				if (resta >0) {
					getNeededPowers().add(1);
					//neededPowers.add(1); /// guardar en una variable provisional!!!
				potenciaRepartida++;
				resta--;
				Main.sleep(1000);
				} else {
					getNeededPowers().add(0);
				}
			} else {
				
				if (resta > 0) {
				
					if (getNeededPowers().get(i) < thrusters.get(i).getMaxPower()) {
						getNeededPowers().set(i,(getNeededPowers().get(i))+1);
						potenciaRepartida++;
						resta--;
					}
					
					
				}
			}

			
			
		}
	}

	private void reparteix() {
		
	
		
		
		// TODO Auto-generated method stub
		for (int i=0; i<thrusters.size(); i++) {
			
	
			potenciaPropulsor = getNeededPowers().get(i); //thrusters.get(i).getNeededPower();
			/*
			 * if (potenciaPropulsor > 0) { divisio += potenciaPropulsor; }
			 */
			
			
			
			//EXECUTA NOMES SI PROPULSOR NO ESTA PLE
			
		//	if (potenciaPropulsor < thrusters.get(i).getMaxPower()) {
			
			
				//antigaPotencia = getNeededPowers().get(i);
				//divisio += antigaPotencia;
				
				
			if (thrusters.get(i).getMaxPower() >= divisio) {
				
				getNeededPowers().set(i,divisio);
				potenciaRepartida+=divisio;
			} else {
				int potenciaInicial = potenciaPropulsor;
				getNeededPowers().set(i,thrusters.get(i).getMaxPower());
				potenciaRepartida+=(thrusters.get(i).getMaxPower()-potenciaInicial);
				resta += divisio - thrusters.get(i).getMaxPower() + potenciaInicial;
				
			}
				/*
				 * if (potenciaPropulsor > 0) { divisio -= potenciaPropulsor; }
				 */
		
		

		//	}
			
		
	}
	
			comprova(getNeededPowers());			
	
	}
	
	
	private void reparteix2() {
		//System.out.println("Metode en construcció");
		
		for (int i=0; i<thrusters.size(); i++) {
			
			
			potenciaPropulsor = getNeededPowers().get(i); 
			//NOMES CAL REPARTIR ENTRE ELS QUE NO HAN ASSOLIT POTENCIA MAXIMA
			if (potenciaPropulsor < thrusters.get(i).getMaxPower()) {
				
				
				getNeededPowers().set(i,potenciaPropulsor+divisio);
				
				
			}
			
			
		}
		
		
	}
	
	private void comprova(List<Integer> list) {

		setCounter(getCounter()+1);
		for (int i=0; i<thrusters.size(); i++) {
			if (list.get(i) < thrusters.get(i).getMaxPower()) {
				propulsorsPendents++;
			}
		}
		divisio = resta / propulsorsPendents;
		resta = resta  % propulsorsPendents;
		
		if (resta > 0) {
			reparteixResta();
		}
		
		if (divisio > 0) {
			reparteix2();
		}
		
	}

	private static void showSpeed(Rocket rocket) {

		//recalcula velocitat actual i la mostra
			rocket.setCurrentSpeed(rocket.getCurrentSpeed()+(100*Math.sqrt(rocket.getTotalUsedPower())));
			System.out.println("Velocitat assolida pel coet " + rocket.getCode() + ": " + Math.round(rocket.getCurrentSpeed() * 100d) / 100d);

	}
	
	private static void printRocket(Rocket rocket) {

		System.out.print("Coet: " + rocket.getCode()+". Potències: ");

		for (int j=0; j<rocket.getThrusters().size(); j++) {

			System.out.print(rocket.getThrusters().get(j).getCurrentPower()+"/");

			if (j<rocket.getThrusters().size()-1) {
				System.out.print(rocket.getThrusters().get(j).getMaxPower()+","); } else {
					System.out.print(rocket.getThrusters().get(j).getMaxPower()); }
		}
		System.out.print("\n");

	}

}