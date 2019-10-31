package ca.csf.dfc.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DonneesTestReservationRepository implements ReservationRepository {
	/**
	 * Liste des ressources
	 */
	private List<Ressource> m_ressources;
	
	/**
	 * Liste des r�servations
	 */
	private List<Reservation> m_reservations;

	@Override
	public List<Ressource> trouverRessourcesParType(String p_type) {
		return this.m_ressources.stream().filter(r -> r.estDuType(p_type)).collect(Collectors.toList());
	}
	
	@Override
	public List<Ressource> trouverRessourcesParTypeEtDate(String p_Type, LocalDate p_Date) {
		
		if (p_Date == null) {
			throw new IllegalArgumentException();
		}
		
		
		List<Ressource> ressource = this.m_ressources.stream()
										.filter(r -> r.estDuType(p_Type)
												&& r.equals(p_Date))
										.collect(Collectors.toList());
	
		return ressource;
	}

	@Override
	public boolean estRessourceReserve(int p_identifiantRessource, LocalDate p_date) {
		return this.m_reservations.stream().filter(
				rsv -> rsv.getIdentifiantRessource() == p_identifiantRessource && rsv.getDate().compareTo(p_date) == 0)
				.count() != 0;
	}
	
	@Override
	public void afficherRessourcesDisponibleLe(LocalDate p_date) {

			
	}

	public DonneesTestReservationRepository() {
		this.m_reservations = new ArrayList<Reservation>();
		
		this.m_ressources = Arrays.asList(new Laboratoire(1, "P-308"), new Laboratoire(2, "P-309"),
				new Laboratoire(3, "P-409"), new Laboratoire(4, "P-418"),

				new Projecteur(10), new Projecteur(11), new Projecteur(12));
	}




}
