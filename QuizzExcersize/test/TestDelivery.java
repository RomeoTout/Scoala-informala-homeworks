import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ro.sci.quizzExcersize.Date;
import ro.sci.quizzExcersize.OrganizingSystem;
import ro.sci.quizzExcersize.Package;
import ro.sci.quizzExcersize.Zone;

public class TestDelivery {
//nu stiu daca am inteles pe deplkn ce trebuia sa faca testul. Printeaza merchandise total value and profit indiferent
//de zona, se uita doar la date. Sper ca e ok

	@Test
	public void mainMethod() {
		//Given
		Date targetDate = Date.TODAY;
		OrganizingSystem os = new OrganizingSystem();
		List<Package> list = new ArrayList<>();

		Package package1 = new Package(Zone.ZONE1, 7, 18.8, Date.TODAY);
		Package package2 = new Package(Zone.ZONE1, 7, 15.6, Date.TODAY);
		Package package3 = new Package(Zone.ZONE2, 7, 15.6, Date.TOMORROW);
		os.addPack(package1);
		os.addPack(package2);
		os.addPack(package3);
		list.add(package1);
		list.add(package2);
		list.add(package3);
		
		//When
		os.testDeliver(list, targetDate);
		
		//Then

	}

}
