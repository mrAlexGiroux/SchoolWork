/**
 * 
 */
package ca.csf.dfc.classes;
import ca.csf.dfc.exception.*;

/**
 * @author alexandregiroux
 *
 */
public class Add extends BinaryOperation {

    public Add(Expression p_FirstExpression, Expression p_SecondExpression)
    {
        super(p_FirstExpression, p_SecondExpression);
    }

    public int calculate() throws ExpressionException
    {
        return (super.getFirstExpression().calculate() + super.getSecondExpression().calculate());
    }
}
