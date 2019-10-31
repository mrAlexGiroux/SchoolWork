package ca.csf.dfc.classes;
import ca.csf.dfc.exception.*;

public abstract class BinaryOperation implements Expression {

    private Expression m_ExpressionTwo;
    private Expression m_ExpressionOne;

    public BinaryOperation(Expression p_FirstExpression, Expression p_SecondExpression)
    {
        this.m_ExpressionOne = p_FirstExpression;
        this.m_ExpressionTwo = p_SecondExpression;
    }

    protected  Expression getFirstExpression()
    {
        return this.m_ExpressionOne;
    }

    protected Expression getSecondExpression()
    {
        return this.m_ExpressionTwo;
    }

    public abstract int calculate() throws ExpressionException;
}
