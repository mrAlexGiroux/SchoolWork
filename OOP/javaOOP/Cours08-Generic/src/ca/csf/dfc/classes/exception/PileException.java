package ca.csf.dfc.classes.exception;

public class PileException extends Exception {
	
	public PileException()
	{
		super("Exception Pile");
	}
	public PileException(String p_string)
	{
		super("Exception Pile " + p_string);
	}

}
