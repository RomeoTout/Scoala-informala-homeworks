package siit.java4.threads_homework;

import java.util.Queue;
/**
 * @author Rome Tout
 * packageQueue=the list to store the ticket-data
 */
public class FestivalStatisticsThread extends Thread {
	private Queue<String> packageQueue;

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
