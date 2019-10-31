/**
 * 
 */
package ca.csf.dfc.exception;
import ca.csf.dfc.exception.*;

/**
 * @author alexandregiroux
 *
 */
public class DivideByZeroException extends ExpressionException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -891053760292930920L;

	public DivideByZeroException()
    {
        super("Divide by zero");
    }

    public DivideByZeroException(String p_Message)
    {
        super("Divide by zero : " + p_Message);
    }
}
