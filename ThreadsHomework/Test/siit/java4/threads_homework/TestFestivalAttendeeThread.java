package siit.java4.threads_homework;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TestFestivalAttendeeThread {
	//Given
	LinkedList<String> queue = new LinkedList<>();
	FestivalGate gate = new FestivalGate();

	TicketType ticketType;

	FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType = TicketType.randomTicketType(),
			gate, queue);

	@Test
	public void testAttendeeRun() {

	//When
		festivalAttendee.start();
		LinkedList<String> expected =new LinkedList<>();
		int actual = queue.size();
	//Then
		assertEquals(expected.size(), actual);
	}
	
	@Test
	public void testGenerateAttendeeThreads() {
		
	//When
		festivalAttendee.generateAtendeeThreads(4);
		int expected=4;
		int actual=queue.size();
	//Then
		assertEquals(expected, actual);

	}
	
	@Test
	public void testRandomticketType() {
		
	//When
		int expected=1;
		int actual=0;
		if(ticketType==TicketType.FULL||ticketType==TicketType.FULL_VIP||ticketType==TicketType.FREE_PASS
				||ticketType==TicketType.ONE_DAY||ticketType==TicketType.ONE_DAY_VIP){
			actual=1;
		} else {
			
			
			
			
			actual=0;
		}
		
	//Then
		assertEquals(expected, actual);
	
	}

}
