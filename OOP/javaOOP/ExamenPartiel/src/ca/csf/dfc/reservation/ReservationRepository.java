package ca.csf.dfc.reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository {
	List<Ressource> trouverRessourcesParType(String p_type);
	List<Ressource> trouverRessourcesParTypeEtDate(String p_Type, LocalDate p_Date);
	
	boolean estRessourceReserve(int p_identifiantRessource, LocalDate p_date);
	
	void afficherRessourcesDisponibleLe(LocalDate p_date);
}
