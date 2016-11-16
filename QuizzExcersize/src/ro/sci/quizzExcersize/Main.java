package ro.sci.quizzExcersize;

public class Main {

	public static void main(String[] args) {
		OrganizingSystem os = new OrganizingSystem();
		
		Package package1 = new Package(Zone.ZONE1, 7, 15.6, Date.TODAY);
		Package package2 = new Package(Zone.ZONE2, 7, 19.7, Date.TODAY);
		Package package3 = new Package(Zone.ZONE1, 7, 16.9, Date.TOMORROW);
		Package package4 = new Package(Zone.ZONE2, 7, 15.6, Date.TOMORROW);
		Package package5 = new Package(Zone.ZONE1, 7, 18.8, Date.TODAY);
		Package package6 = new Package(Zone.ZONE1, 7, 15.6, Date.TODAY);
		Package package7 = new Package(Zone.ZONE1, 7, 15.6, Date.TODAY);
		
		os.addPack(package1);
		os.addPack(package2);
		os.addPack(package3);
		os.addPack(package4);
		os.addPack(package5);
		os.addPack(package6);
		os.addPack(package7);
		
		os.deliver();
	}

}
