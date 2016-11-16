package ro.sci.quizzExcersize;

import java.util.ArrayList;
import java.util.List;

public class OrganizingSystem {
	double totalValue;
	double profit;
	double valuePerKm = 1.67;
	List<Package> importanceHigh = new ArrayList<>();
	List<Package> importanceMedium = new ArrayList<>();
	List<Package> importanceLow = new ArrayList<>();
	List<Package> importanceLowest = new ArrayList<>();
	
	/**
	 * automatically adds the package into the coresponding list
	 */
	public void addPack(Package pckg){
		if(pckg.location==Zone.ZONE1&&pckg.deliveryDate==Date.TODAY){
			importanceHigh.add(pckg);
		} else if(pckg.location==Zone.ZONE2&&pckg.deliveryDate==Date.TODAY){
			importanceMedium.add(pckg);
		} else if(pckg.location==Zone.ZONE1&&pckg.deliveryDate==Date.TOMORROW){
			importanceLow.add(pckg);
		} else{
			importanceLowest.add(pckg);
		}
	}

	
	public double calculateValue(List<Package> list){
		for(int i=0;i<list.size();i++){
			totalValue += list.get(i).value;
		}
		return totalValue;
	}
	
	public double calculateProfit(List<Package> list){
		for (int i = 0; i < list.size(); i++) {
			profit +=list.get(i).distance * valuePerKm;
		}
		return profit;
	}
	/**
	 * creates a separate thread for each list that is not empty
	 */
	public void deliver(){
		if(!importanceHigh.isEmpty()){
		DeliveryThread upsGuy1 = new DeliveryThread(importanceHigh);
		}
		if(!importanceMedium.isEmpty()){
		DeliveryThread upsGuy2 = new DeliveryThread(importanceMedium);
		}
		if(!importanceLow.isEmpty()){
		DeliveryThread upsGuy3 = new DeliveryThread(importanceLow);
		}
		if(!importanceLowest.isEmpty()){
		DeliveryThread upsGuy4 = new DeliveryThread(importanceLowest);
		}
	}
	/**
	 * made for the unit test
	 * @param targetDate = the date for wich to calculate the package bunches profit and value
	 */
	public void testDeliver(List<Package> list, Date targetDate){
		for(int i=0;i<list.size();i++)
		if(list.get(i).deliveryDate!=Date.TODAY){
			list.remove(list.get(i));
			System.out.println(calculateValue(list)+ " and " + calculateProfit(list));
		}
	}
}
