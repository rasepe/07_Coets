public class Thruster implements Runnable {	
	private volatile boolean running = true;
	private volatile boolean paused = false;
	private final Object pauseLock = new Object();
	private int maxPower;
	private int currentPower; 
	private double desiredPower;
	private Rocket currentRocket;
	private int number;
	private int counter;

	public Thruster(int maxPower, Rocket currentRocket, int number) {
		super();
		this.maxPower = maxPower;
		this.currentPower = 0;
		this.desiredPower = 0;
		this.currentRocket = currentRocket;
		this.number = number;
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

	public double getDesiredPower() {
		return desiredPower;
	}

	public void setDesiredPower(double d) {
		this.desiredPower = d;
	}


	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	volatile boolean finished = false;



	@Override
	public void run() {
		while (running) {
			synchronized (pauseLock) {
				if (!running) { // may have changed while waiting to
					// synchronize on pauseLock
					break;
				}
				if (paused) {
					try {
						synchronized (pauseLock) {
							pauseLock.wait(); // will cause this Thread to block until 
							// another thread calls pauseLock.notifyAll()
							// Note that calling wait() will 
							// relinquish the synchronized lock that this 
							// thread holds on pauseLock so another thread
							// can acquire the lock to call notifyAll()
							// (link with explanation below this code)
						}
					} catch (InterruptedException ex) {
						break;
					}
					if (!running) { // running might have changed since we paused
						break;
					}
				}
			}



			while (!finished) {
				//ACCELERA SI ES DONEN LES CONDICIONS
				if (currentPower < desiredPower && currentPower < maxPower) {

					currentPower += 1;

					System.out.println(Thread.currentThread().getName() + " ACCELERANT PROPULSOR " + number + " DEL COET " + currentRocket.getCode() );
					currentRocket.setTotalUsedPower(currentRocket.getTotalUsedPower()+1);


				}
				//FRENA SI ES DONEN LES CONDICIONS
				if (currentPower > desiredPower && currentPower > 0) {

					currentPower -= 1;



					System.out.println(Thread.currentThread().getName() + " DESACCELERANT PROPULSOR " + number + " DEL COET " + currentRocket.getCode());
					currentRocket.setTotalUsedPower(currentRocket.getTotalUsedPower()-1);


				} 
			}

		}

	}


	public void stop() {
		running = false;
		// you might also want to interrupt() the Thread that is 
		// running this Runnable, too, or perhaps call:
		resume();
		// to unblock
	}

	public void pause() {
		// you may want to throw an IllegalStateException if !running
		paused = true;
	}

	public void resume() {
		synchronized (pauseLock) {
			paused = false;
			pauseLock.notifyAll(); // Unblocks thread
		}
	}
};
	
	


