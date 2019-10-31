package ca.csf.dfc.a2018pooexamen01.mediatheque;

public class LivrePoche extends Livre {

	public LivrePoche(int p_Id, String p_Titre)
	{
		super(p_Id, p_Titre);
	}
	
	@Override
	public String getType() {
		return "LivrePoche";
	}
}
