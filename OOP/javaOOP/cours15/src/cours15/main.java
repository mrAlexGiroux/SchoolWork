package cours15;

public class main {
	
	private static void FenetreSouris()
	{
		EcouteurDeSouris mouseListener = new EcouteurDeSouris();
		
		mouseListener.setVisible(true);
		
	}
	
	private static void FenetreCalculer()
	{
		Calculer fenetreCalculer = new Calculer();
		fenetreCalculer.setVisible(true);
	}
	
	public static void main(String[] args) {
		 
		FenetreSouris();

	}

}
