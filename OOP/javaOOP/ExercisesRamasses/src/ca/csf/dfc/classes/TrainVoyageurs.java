/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author girou
 *
 */
public class TrainVoyageurs extends VehiculeFerroviaire {

	/**
	 * Vitesse maximum du train voyageurs
	 */
	private final int VITESSE_MAX_VOYAGEURS = 130;

	/**
	 * Constructeur par initalisation du train voyageur
	 * @param p_Modele
	 * @param p_Reference
	 */
	public TrainVoyageurs(String p_Modele, String p_Reference)
	{
		super(p_Modele, p_Reference);
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#accelerer()
	 */
	@Override
	public void accelerer() {
		if (super.getVitesse() >= VITESSE_MAX_VOYAGEURS) {
			throw new IllegalArgumentException("accelerer | TrainVoyageurs");
		}
		super.m_Vitesse += CHANGEMENT_DE_VITESSE;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#ralentir()
	 */
	@Override
	public void ralentir() {
		if (super.getVitesse() == VITESSE_MIN) {
			throw new IllegalArgumentException("ralentir | TrainVoyageurs");
		}
		super.m_Vitesse -= CHANGEMENT_DE_VITESSE;
	}

	/**
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#getClassTrain()
	 */
	@Override
	public String getClassTrain() {
		return "TrainVoyageurs";
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.getClassTrain() + " : " + super.getModele() + " " + super.getReference();
	}

}
