package ca.csf.dfc.classes.exception;

public class PilePleineException extends PileException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8707044892090886530L;

	public PilePleineException()
	{
		super("Pile Pleine");
	}
	
	public PilePleineException(String p_String)
	{
		super("Pile Pleine | " + p_String);
	}
}
