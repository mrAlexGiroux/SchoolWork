/**
 * 
 */
package ca.csf.dfc.classes;

import java.util.ArrayList;

/**
 * @author AlexandreGiroux
 *
 */
public class TrainMarchandises extends VehiculeFerroviaire {

	/**
	 * Vitesse maximum du train de marchandises
	 */
	private final int VITESSE_MAX_MARCHANDISES = 110;

	/**
	 * Represente le nombre de remorque du train
	 */
	private int m_NombreDeRemorque;

	/**
	 * Constructeur par initialisation du train de marchandise
	 * @param p_Modele
	 * @param p_Reference
	 */
	public TrainMarchandises(String p_Modele , String p_Reference) {
		super(p_Modele, p_Reference);
		if (p_Modele.isEmpty() && p_Reference.isEmpty()) {
			throw new IllegalArgumentException("CTR | TrainMarchandises");
		}
		this.m_NombreDeRemorque = 0;
	}

	/**
	 * Retourne le nombre de remorque attacher au train
	 * @return m_NombreDeRemorque
	 */
	public int getNombreAttacherTrain() {
		return this.m_NombreDeRemorque;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#accelerer()
	 */
	@Override
	public void accelerer() {
		if (super.getVitesse() == VITESSE_MAX_MARCHANDISES) {
			throw new IllegalArgumentException("accelerer | TrainMarchandises");
		}
		super.m_Vitesse += CHANGEMENT_DE_VITESSE;
	}

	/* (non-Javadoc)
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#ralentir()
	 */
	@Override
	public void ralentir() {
		if (super.getVitesse() == VITESSE_MIN) {
			throw new IllegalArgumentException("ralentir | TrainMarchandises");
		}
		super.m_Vitesse -= CHANGEMENT_DE_VITESSE;
	}

	/**
	 * @see ca.csf.dfc.classes.VehiculeFerroviaire#getClassTrain()
	 */
	@Override
	public String getClassTrain() {
		return "TrainMarchandises";
	}

	/**
	 * Attacher un remorque au train
	 * si la le train n'est pas en mouvement
	 */
	public void attacherRemorque()
	{
		if (super.m_Vitesse > VITESSE_MIN) {
			throw new IllegalArgumentException("attacherRemorque | TrainMarchandises");
		}
		this.m_NombreDeRemorque++;
	}

	/**
	 * Detache une remorque du train
	 * si le train n'est pas en movement
	 */
	public void detacherRemorque()
	{
		if (super.m_Vitesse > VITESSE_MIN && this.m_NombreDeRemorque == 0) {
			throw new IllegalArgumentException("detacherRemorque | TrainMarchandises");
		}
		this.m_NombreDeRemorque--;
	}

	@Override
	public String toString() {
		return  this.getClassTrain() + " : " + super.getModele() + " " + super.getReference() + " " + this.getNombreAttacherTrain();
	}

}
