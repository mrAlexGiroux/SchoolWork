package ca.csf.dfc.reservation;

import java.time.LocalDate;

public class Reservation {
	private int m_identifiantRessource;
	private LocalDate m_date;
	
	public Reservation(int p_identifiantRessource, LocalDate p_date) {
		this.m_identifiantRessource = p_identifiantRessource;
		this.m_date = p_date;
	}

	public int getIdentifiantRessource() {
		return m_identifiantRessource;
	}

	public LocalDate getDate() {
		return m_date;
	}
}
