package ca.csf.dfc.a2018pooexamen01.console;

import ca.csf.dfc.a2018pooexamen01.donneestest.DonneesTestsMediathequeRepository;
import ca.csf.dfc.a2018pooexamen01.mediatheque.Mediatheque;
import ca.csf.dfc.a2018pooexamen01.mediatheque.MediathequeRepository;

public class A2018_POO_Examen01 {
	static public void main(String[] args) {
		MediathequeRepository mediathequeRepository = new DonneesTestsMediathequeRepository();
		
		System.out.println(mediathequeRepository.getMediaById(7).getTitre());
		System.out.println();
		mediathequeRepository.getMedia().stream().map(m -> m.getTitre()).forEach(System.out::println);
		System.out.println();
		mediathequeRepository.trouverMediaParExpression("fourmi").stream().map(m -> m.getTitre()).forEach(System.out::println);
		
		Mediatheque mediatheque = new Mediatheque(mediathequeRepository);
		
		// Votre code ici
		
	}
}
