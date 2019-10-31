/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author alexandregiroux
 *
 */
public class Add extends BinaryOperation {

    public Add(Expression p_FirstExpression, Expression p_SecondExpression)
    {
        super(p_FirstExpression, p_SecondExpression);
    }

    public int calculate()
    {
        return super.getFirstExpression().calculate() + super.getSecondExpression().calculate();
    }
}
