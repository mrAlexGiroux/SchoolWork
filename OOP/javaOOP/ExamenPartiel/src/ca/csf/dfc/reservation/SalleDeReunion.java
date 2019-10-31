/**
 * 
 */
package ca.csf.dfc.reservation;

/**
 * @author alexandregiroux
 *
 */
public class SalleDeReunion extends Ressource {

	private int m_Etage;
	private int m_CapacitePersonne;
	
	public SalleDeReunion(int p_identifiant, int p_Etage, int p_CapacitePersonne) {
		super(p_identifiant);
		this.m_Etage = p_Etage;
		this.m_CapacitePersonne = p_CapacitePersonne;
	}
	
	@Override
	public String toString() {
		return "SalleDeReunion ( Id : " 
				+ super.getIdentifiant()
				+ " Etage : "
				+ this.m_Etage
				+ " CapacitePersonne : "
				+ this.m_CapacitePersonne;
	}

}
