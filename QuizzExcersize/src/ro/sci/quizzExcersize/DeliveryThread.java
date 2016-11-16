package ro.sci.quizzExcersize;

import java.util.ArrayList;
import java.util.List;

public class DeliveryThread extends Thread{
	
	OrganizingSystem os = new OrganizingSystem();
	List<Package> list = new ArrayList<>();


	public DeliveryThread(List<Package> list) {
		this.list = list;
		this.start();
	}

	@Override
	public void run() {
		System.out.println("Delivering packages in "+ list.get(0).location + " " + list.get(0).deliveryDate);
		System.out.println("The value of the bunch is " + os.calculateValue(list)+" and the profit is "+ os.calculateProfit(list));
		try {
			Thread.sleep(list.get(0).distance * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
