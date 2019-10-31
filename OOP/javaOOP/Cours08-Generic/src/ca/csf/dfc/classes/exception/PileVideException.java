package ca.csf.dfc.classes.exception;

public class PileVideException extends PileException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5818412043680096536L;

	public PileVideException()
	{
		super("Pile Vide");
	}
	
	public PileVideException(String p_String)
	{
		super("Pile Vide | " + p_String);
	}
}
