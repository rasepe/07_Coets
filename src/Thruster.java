import java.util.Scanner;

//public class Thruster extends Thread {
public class Thruster implements Runnable {	
    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();
	private static Scanner sc = new Scanner(System.in);
	int maxPower;
	int currentPower; // s'inicialitza a 0;
	int desiredPower;
	boolean accelera = false;
	private Rocket currentRocket;
	private int number;

	
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	volatile boolean finished = false;

	
	/*
	 * public void stopMe() { finished = true;
	 * System.out.println("Matat el fil "+Thread.currentThread().getName()); //
	 * System.out.println(Thread.currentThread().isAlive()); }
	 */
	 


	
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
            
        // ACCELERA FINS POTENCIA OBJECTIU I SURT

    		while (!finished) {
    			//ACCELERA SI ES DONEN LES CONDICIONS
    			if (currentPower < desiredPower && currentPower < maxPower) {
    				//resume();
    				currentPower++;
    				System.out.println("ACCELERANT PROPULSOR " + number);
    				Main.printRocket(currentRocket);
    				//pause();
    				
    			}
    			//FRENA SI ES DONEN LES CONDICIONS
    			if (currentPower > desiredPower && currentPower > 0) {
    				//resume();
    				currentPower--;
    				System.out.println("DESACCELERANT PROPULSOR " + number);
    				Main.printRocket(currentRocket);
    				//pause();
    				
    			}
    			
    			//pause();
    			
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
	
	


// }
