package cs.csf.dfc.classes;

import java.util.List;

public class Personne implements IPersonne {

	private int m_Age;
	private String m_Nom;
	private int m_UniqueID;
	private List<Automobile> m_Automobiles;
	
	public Personne(int p_age, String p_Nom) {
		
		this.m_UniqueID = IDGenerator.getInstance().getNextID();
	}

	@Override
	public void getPersonne(int p_age, String p_Nom) {
		
		
	}

}
