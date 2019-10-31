package ca.csf.dfc;

public class Cercle implements IForme {

	private double m_hauteur;
	
	public Cercle(double p_hauteur)
	{
		this.m_hauteur = p_hauteur;
	}
	
	public String enregistrer() {
		
		return "Enregistrer" + this.getClass();
	}

	public String afficher() {
		
		return this.getClass().toString() + this.m_hauteur;
	}

}
