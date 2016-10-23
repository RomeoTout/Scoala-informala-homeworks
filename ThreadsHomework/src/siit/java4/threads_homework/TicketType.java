package siit.java4.threads_homework;

import java.util.Random;

public enum TicketType {
	
	FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;
	/**
	 * @returns a random ticket type
	 */
	public static TicketType randomTicketType(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
		
	}
}
