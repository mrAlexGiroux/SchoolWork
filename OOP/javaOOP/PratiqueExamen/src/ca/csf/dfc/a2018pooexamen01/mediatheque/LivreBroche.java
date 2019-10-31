package ca.csf.dfc.a2018pooexamen01.mediatheque;

public class LivreBroche extends Livre {

	public LivreBroche(int p_Id, String p_Titre)
	{
		super(p_Id, p_Titre);
	}
	
	@Override
	public String getType() {
		return "LivreBroche";
	}




}
