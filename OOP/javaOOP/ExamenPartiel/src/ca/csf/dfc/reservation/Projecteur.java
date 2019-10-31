package ca.csf.dfc.reservation;

public class Projecteur extends RessourceMaterielle {
	public Projecteur(int p_identifiant) {
		super(p_identifiant);
	}
	
	@Override
	public String toString() {
		return " Projecteur : "
				+ super.getIdentifiant();
	}
}
