package ca.csf.dfc.a2018pooexamen01.mediatheque;

import java.util.*;

public class Mediatheque {
	private MediathequeRepository m_MediathequeRepository;
	
	public Mediatheque(MediathequeRepository p_MediathequeRepository) {
		this.m_MediathequeRepository = p_MediathequeRepository;
	}
	
	public void afficherMediaCorrespondantALaRecherche(String p_Expression, String p_Media)
	{
		List<Media> medias = this.m_MediathequeRepository
		.trouverMediaParExpressionEtType(p_Expression, p_Media);
		
		medias.forEach(System.out::println);
	}
	
	public void emprunterMedia(int p_Id)
	{
		Media m = this.m_MediathequeRepository.getMediaById(p_Id);
		
		if (m == null) {
			throw new IllegalArgumentException("Le m�dia n'existe pas !");
		}

		if (m.estEmprunter()) {
			throw new IllegalArgumentException("Le m�dia est d�j� emprunt� !");
		}
		
		m.emprunterMedia();
	}
	public void rendre(int p_Id) {
		Media m = this.m_MediathequeRepository.getMediaById(p_Id);
		
		if (m == null) {
			throw new IllegalArgumentException("Le m�dia n'existe pas !");
		}

		if (!m.estEmprunter()) {
			throw new IllegalArgumentException("Le m�dia est d�j� pr�sent !");
		}
		
		m.rendreMedia();
	}
	
	
}
