package ca.csf.dfc.classes;

public class ClasseGen<Pile> {

	/**
	 * 
	 */
	private Pile m_donnee;
	
	/**
	 * 
	 */
	public ClasseGen()
	{
		this(null);
	}
	
	/**
	 * 
	 * @param p_donne
	 */
	public ClasseGen(Pile p_donne)
	{
		this.setDonnee(p_donne);
	}
	
	/**
	 * Retourne le donne.
	 * @return the donne
	 */
	public Pile getDonnee() {
		return this.m_donnee;
	}

	/**
	 * Pour modifier le donne.
	 * @param p_donne the donne to set
	 */
	public void setDonnee(Pile p_donnee) {
		this.m_donnee = p_donnee;
	}
}
