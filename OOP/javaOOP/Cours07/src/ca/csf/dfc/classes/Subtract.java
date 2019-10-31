package ca.csf.dfc.classes;
import ca.csf.dfc.exception.*;

public class Subtract extends BinaryOperation {

	public Subtract(Expression p_FirstExpression, Expression p_SecondExpression) {
		super(p_FirstExpression, p_SecondExpression);
	}

	@Override
	public int calculate() throws ExpressionException {
		return super.getFirstExpression().calculate() - super.getSecondExpression().calculate();
	}

}
