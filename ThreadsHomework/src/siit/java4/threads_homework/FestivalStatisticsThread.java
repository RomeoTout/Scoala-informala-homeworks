package siit.java4.threads_homework;

import java.util.Queue;
/**
 * @author Rome Tout
 * packageQueue=the list to store the ticket-data
 */
public class FestivalStatisticsThread extends Thread {
	// TODO CODE REVIEW: If it's a list for storing ticket-data, why is it called packageQueue?
	private Queue<String> packageQueue;

	// TODO CODE REVIEW: FestivalGate is never used in the class. Remove it.
	public FestivalStatisticsThread(FestivalGate gate, Queue<String> packageQueue) {
		this.packageQueue = packageQueue;
	}
	/**
	 * waits if packageQueue is empty
	 * outputs the statistical data gathered
	 * runs an infinite loop 
	 */
	@Override
	public void run() {
		try {
			while (true) {
				synchronized (packageQueue) {
					if (packageQueue.isEmpty()) {
						packageQueue.wait();
					} else {
						System.out.println("\n"+packageQueue.size() + " people entered");
						System.out.println(FestivalAttendeeThread.fullCounter+" people have full tickets");
						System.out.println(FestivalAttendeeThread.fulVipCounter+" have full VIP passes");
						System.out.println(FestivalAttendeeThread.freePassCounter+" have free passes");
						System.out.println(FestivalAttendeeThread.oneDayCounter+" have one-day passes");
						System.out.println(FestivalAttendeeThread.oneDayVipCounter+" have one-day VIP passes"+"\n");
						packageQueue.notify();
					}
				}
				Thread.sleep(5000);
			}

		} catch (Exception e) {

		}

	}

}
