package ca.csf.dfc.bl;

public class Contact {

	private String m_nom;
	private String m_prenom;
	private String m_adresse;
	private String m_ville;
	private String m_telephone;
	private String m_cellulaire;

	public Contact()
	{
		this.m_nom = "";
		this.m_prenom = "";
		this.m_adresse = "";
		this.m_ville = "";
		this.m_telephone = "";
		this.m_cellulaire = "";
	}

	public Contact(String p_nom, String p_prenom, String p_adresse, String p_ville, String p_telephone, String p_cellulaire)
	{
		this.m_nom = p_nom;
		this.m_prenom = p_prenom;
		this.m_adresse = p_adresse;
		this.m_ville = p_ville;
		this.m_telephone = p_telephone;
		this.m_cellulaire = p_cellulaire;
	}

}
