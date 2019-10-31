package ca.csf.dfc;

public class Ellipse implements IForme {
	
	private double m_hauteur;
	private double m_largeur;
	
	public Ellipse(double p_hauteur, double p_largeur) {
		this.m_hauteur = p_hauteur;
		this.m_largeur = p_largeur;
	}
	
	public String enregistrer() {
		
		return "Enregistrer" + this.getClass();
	}

	public String afficher() {
		
		return this.getClass().toString() + this.m_hauteur + this.m_largeur;
	}

}
