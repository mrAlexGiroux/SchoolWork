package ca.csf.dfc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.csf.dfc.a2018pooexamen01.mediatheque.*;

class CompactDiskTest {

	@Test
	void testEmprunterMedia() {
		Media cd = new CompactDisk(1,"Titre");
		
		assertEquals(false, cd.estEmprunter());
		
		cd.emprunterMedia();
		
		assertEquals(true, cd.estEmprunter());
	}

	@Test
	void testRendreMedia() {
		Media cd = new CompactDisk(1,"Titre");
		
		cd.emprunterMedia();
		
		assertEquals(true, cd.estEmprunter());
		
		cd.rendreMedia();
		
		assertEquals(false, cd.estEmprunter());
	}

}
