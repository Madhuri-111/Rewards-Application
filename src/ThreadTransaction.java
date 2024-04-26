
public class ThreadTransaction extends Thread {
	
	User u;
	public ThreadTransaction(User us) {
		u=us;
	}
	
	public void run() {
		try {
			while(!TaskManager.isTaskDone()) {
				System.out.println("Cpoming inside run method");
				Thread.sleep(5000);	
				CommonService.updatePoints(u);
					}
		}catch(Exception e) {
			System.out.println("Some problem.");
		}
	}
}
