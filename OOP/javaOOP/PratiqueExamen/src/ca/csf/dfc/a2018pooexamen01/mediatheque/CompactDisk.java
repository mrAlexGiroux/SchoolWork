package ca.csf.dfc.a2018pooexamen01.mediatheque;

public class CompactDisk implements Media {

	private int m_Id;
	private String m_Titre;
	private boolean m_estEmprunter;
	
	public CompactDisk(int p_Id, String p_Titre)
	{
		this.m_Id = p_Id;
		this.m_Titre = p_Titre;
		this.m_estEmprunter = false;
	}
	
	@Override
	public int getIdentifiant() {
		return m_Id;
	}

	@Override
	public String getTitre() {
		return this.m_Titre;
	}

	@Override
	public String getType() {
		return "CompactDisk";
	}
	
	@Override
	public void emprunterMedia() {
		if (this.estEmprunter()) {
			throw new IllegalArgumentException();
		}
		this.m_estEmprunter = true;
	}

	@Override
	public void rendreMedia() {
		if (!this.estEmprunter()) {
			throw new IllegalArgumentException();
		}
		this.m_estEmprunter = false;
	}
	
	public boolean estEmprunter()
	{
		return this.m_estEmprunter;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ");
		sb.append(this.m_Id);
		sb.append(" Titre : ");
		if (this.m_estEmprunter) {
			sb.append(" Media libre");
		}
		else {
			sb.append(" Media emprunté");
		}
		return sb.toString();
	}


}
