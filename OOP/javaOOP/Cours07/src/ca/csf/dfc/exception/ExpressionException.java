package ca.csf.dfc.exception;
import ca.csf.dfc.exception.*;

public class ExpressionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1944408741140005652L;

	public ExpressionException()
	{
		super("Arithmetic Error");
	}
	
	public ExpressionException(String p_Message)
	{
		super("Arithmetic Error : " + p_Message);
	}
}
