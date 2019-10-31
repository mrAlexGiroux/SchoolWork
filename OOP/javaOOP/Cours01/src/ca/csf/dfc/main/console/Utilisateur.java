package ca.csf.dfc.main.console;

public class Utilisateur {
	
	private String m_Prenom;
	private String m_Nom;
	private int m_Age;
	private boolean m_EstActif;
	private Telephone m_Telephone;
	
	public Utilisateur()
	{
		this.m_Nom = "";
		this.m_Age = 0;
		this.m_Telephone = null;
	}
	
	public Utilisateur(String p_Prenom, String p_Nom, int p_Age, boolean p_EstActif, Telephone p_Telephone) {
		this.m_Prenom = p_Prenom;
		this.m_Nom = p_Nom; 
		this.m_Age = p_Age;
		this.m_EstActif = p_EstActif;
		this.m_Telephone = p_Telephone;
	}
	
	public String getPrenom()
	{
		return this.m_Prenom;
	}
	
	public void setPrenom(String p_Prenom)
	{
		this.m_Nom = p_Prenom;
	}
	
	public String getNom()
	{
		return this.m_Nom;
	}
	
	public void setNom(String p_Nom)
	{
		this.m_Nom = p_Nom;
	}
	
	public int getAge()
	{
		return this.m_Age;
	}
	
	public void setAge(int p_Age)
	{
		this.m_Age = p_Age;
	}
	
	public boolean getActif()
	{
		return this.m_EstActif;
	}
	
	public void setActif(boolean p_EstActif)
	{
		this.m_EstActif = p_EstActif;
	}
	
	public Telephone getTelephone() {
		return this.m_Telephone;
	}
	
	public void setTelephone(Telephone p_Telephone) {
		this.m_Telephone = p_Telephone;
	}
	
	public String toString() 
	{
		return this.m_Prenom + " " + this.m_Nom + " " + this.m_Age + " " + this.m_EstActif;
	}

}
