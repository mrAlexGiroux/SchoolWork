package cs.csf.dfc.classes;

import java.util.List;

public class Automobile implements IAutomobile {

	private int m_Annee;
	private String m_Modele;
	private int m_UniqueID;
	
	private List<Personne> m_Proprietaire;
	
	public Automobile(String p_Modele, int p_Annee)
	{
		
	}
	
	@Override
	public String getAutomobile() {
		return this.m_Modele + this.m_Annee;
	}

}
