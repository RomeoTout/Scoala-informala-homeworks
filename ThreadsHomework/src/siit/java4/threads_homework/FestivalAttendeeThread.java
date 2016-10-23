package siit.java4.threads_homework;

import java.util.Queue;

/**
 * @author Reo55
 * packageQueue=the list to store the ticket-data
 * ticketType=ticket-data
 * fullCounter=FULL ticket type
 * fulVipCounter=FULL_VIP ticket type
 * freePassCounter=FREE_PASS ticket type
 * oneDayCounter=ONE_DAY ticket type
 * oneDayVipCounter=ONE_DAY_VIP ticket type
 */
public class FestivalAttendeeThread extends Thread {

	private Queue<String> packageQueue;
	private TicketType ticketType;
	private FestivalGate gate;
	static int fullCounter = 0;
	static int fulVipCounter = 0;
	static int freePassCounter = 0;
	static int oneDayCounter = 0;
	static int oneDayVipCounter = 0;

	public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate, Queue<String> packageQueue) {
		this.ticketType = ticketType;
		this.packageQueue = packageQueue;
		this.gate = gate;
	}
	/**
	 * adds ticket type to queue and notifies the next thread
	 */
	@Override
	public void run() {
		try {

			synchronized (packageQueue) {
				System.out.println("entering gate:");
				packageQueue.add(ticketType.toString());

				packageQueue.notify();
			}
			Thread.sleep(3000);

		} catch (Exception e) {

		}
	}
	/**
	 * creates a specific number of atendee threads and counts every type of ticket that entered
	 */
	public void generateAtendeeThreads(int numberOfAttendees) {
		for (int i = 0; i < numberOfAttendees; i++) {
			System.out.println("Person " + i);
			if (ticketType == TicketType.FULL) {
				fullCounter++;
			} else if (ticketType == TicketType.FULL_VIP) {
				fulVipCounter++;
			} else if (ticketType == TicketType.FREE_PASS) {
				freePassCounter++;
			} else if (ticketType == TicketType.ONE_DAY) {
				oneDayCounter++;
			} else if (ticketType == TicketType.ONE_DAY_VIP) {
				oneDayVipCounter++;
			}
			FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(
					ticketType = TicketType.randomTicketType(), gate, packageQueue);
			festivalAttendee.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
