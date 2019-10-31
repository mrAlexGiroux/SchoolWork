/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author AlexandreGirouz *
 */
public abstract class VehiculeFerroviaire {

	/**
	 * Vitesse minimum de tous les train et accesible seulement par heritage.
	 */
	protected final int VITESSE_MIN = 0;

	protected final int CHANGEMENT_DE_VITESSE = 10;

	/**
	 * Represente la vitesse du train
	 */
	protected int m_Vitesse;

	/**
	 * Represente le modele du train
	 */
	private String m_Modele;

	/**
	 * represente le no. de reference du train
	 */
	private String m_Reference;

	public VehiculeFerroviaire(String p_Modele, String p_Reference)
	{
		this.m_Modele = p_Modele;
		this.m_Reference = p_Reference;
		this.m_Vitesse = 0;
	}

	/**
	 * Retourne la vitesse du train
	 * @return this.m_Vitesse
	 */
	protected int getVitesse()
	{
		return this.m_Vitesse;
	}


	/**
	 * Retourne le modele du train
	 * @return the m_modele
	 */
	protected String getModele() {
		return this.m_Modele;
	}

	/**
	 * Retourne la reference du train
	 * @return the m_Reference
	 */
	protected String getReference() {
		return this.m_Reference;
	}
	
	/**
	 * Permet d'accelerer le train de 10km
	 */
	protected abstract void accelerer();

	/**
	 * Permet de ralentire le train de 10km
	 */
	protected abstract void ralentir();

	/**
	 * Permet d'avoir la classe du train
	 * @return la classe du train
	 */
	public abstract String getClassTrain();
	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.getModele() + " " + this.getReference();
	}
	
	


	
}
