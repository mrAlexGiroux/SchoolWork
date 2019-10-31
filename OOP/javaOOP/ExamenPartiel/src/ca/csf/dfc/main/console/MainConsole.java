package ca.csf.dfc.main.console;

import ca.csf.dfc.reservation.*;

public class MainConsole {

	public static void main(String[] args) {
		ReservationRepository rr = new DonneesTestReservationRepository();
		ReservationServices rs = new ReservationServices(rr);
		
		// rs.reserverRessource(p_identifiantRessource, p_date);
		System.out.println(new Laboratoire(123, "P-109").estDuType("Laboratoire"));
		System.out.println(new Laboratoire(123, "P-109").estDuType("laboratoire"));
		System.out.println(new Laboratoire(123, "P-109").estDuType("salle"));
		
		System.out.println();
		
		System.out.println(rr.trouverRessourcesParType("Laboratoire"));
		System.out.println(rr.trouverRessourcesParType("Projecteur"));
		System.out.println(rr.trouverRessourcesParType("autre"));
	}

}
