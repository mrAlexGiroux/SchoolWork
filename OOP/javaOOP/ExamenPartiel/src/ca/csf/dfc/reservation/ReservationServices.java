package ca.csf.dfc.reservation;

import java.time.LocalDate;

public class ReservationServices {
	private ReservationRepository m_reservationRepository;
	
	public ReservationServices(ReservationRepository p_reservationRepository) {
		this.m_reservationRepository = p_reservationRepository;
	}
	
	public void reserverRessource(int p_identifiantRessource, LocalDate p_date) {
		
		//this.m_reservationRepository = new Reservation(p_identifiantRessource, p_date);
		
	}
}
