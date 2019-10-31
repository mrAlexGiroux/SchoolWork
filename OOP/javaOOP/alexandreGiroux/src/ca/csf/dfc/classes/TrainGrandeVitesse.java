/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author girou
 *
 */
public class TrainGrandeVitesse extends TrainVoyageurs {

	/**
	 * Vitesse maximum du train grande vitesse
	 */
	private final int VITESSE_MAX_TGV = 350;

	/**
	 * Boolean pour verifier le WIFI
	 */
	private boolean wifiActif;

	/**
	 * constructeur du train grande vitesse
	 * @param p_Modele
	 * @param p_Reference
	 */
	public TrainGrandeVitesse(String p_Modele, String p_Reference)
	{
		super(p_Modele, p_Reference);
		if (p_Modele.isEmpty() && p_Reference.isEmpty()) {
			throw new IllegalArgumentException("CTR | TrainTGV");
		}
		wifiActif = false;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#accelerer()
	 */
	@Override
	public void accelerer() {
		if (super.getVitesse() == VITESSE_MAX_TGV) {
			throw new IllegalArgumentException("accelerer | TrainTGV");
		}
		super.m_Vitesse += CHANGEMENT_DE_VITESSE;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#ralentir()
	 * desactivation du wifi
	 */
	@Override
	public void ralentir() {
		if (super.getVitesse() == VITESSE_MAX_TGV) {
			throw new IllegalArgumentException("ralentir | TrainTGV");
		}
		super.m_Vitesse -= CHANGEMENT_DE_VITESSE;
		desactiverWifi();
	}
	
	/**
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#getClassTrain()
	 */
	@Override
	public String getClassTrain() {
		return "TrainGrandeVitesse";
	}

	/**
	 * activation du wifi 
	 * si la vitesse est plus grand que 200km/h
	 */
	public void activerWifi()
	{
		if (super.getVitesse() < 200) {
			throw new IllegalArgumentException("activerWifi | TrainTGV");
		}
		wifiActif = true;
	}

	/**
	 * desactivation automatique tu wifi
	 * si la vitesse est plus petite que 200km/h
	 */
	private void desactiverWifi()
	{
		if (super.getVitesse() < 200) {
			wifiActif = false;
		}
	}

	@Override
	public String toString() {
		return  this.getClassTrain() + " : " + super.getModele() + " " + super.getReference();
	}

}
