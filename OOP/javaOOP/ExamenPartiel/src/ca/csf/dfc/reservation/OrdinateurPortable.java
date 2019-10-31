/**
 * 
 */
package ca.csf.dfc.reservation;

/**
 * @author alexandregiroux
 *
 */
public class OrdinateurPortable extends RessourceMaterielle{

	private String m_SystemeExploitation;
	
	public OrdinateurPortable(int p_identifiant, String p_SystemeExploitation) {
		super(p_identifiant);
		this.m_SystemeExploitation = p_SystemeExploitation;
	}
	
	@Override
	public String toString() {
		return " Ordinateur Portable : "
				+ super.getIdentifiant()
				+ " OS :" 
				+ this.m_SystemeExploitation;
	}
	
}
