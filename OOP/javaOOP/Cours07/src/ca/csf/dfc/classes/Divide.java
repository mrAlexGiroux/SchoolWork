package ca.csf.dfc.classes;
import ca.csf.dfc.exception.*;

public class Divide extends BinaryOperation {

	private final int CANNOT_DIVIDE_BY_ZERO = 0;

	public Divide(Expression p_FirstExpression, Expression p_SecondExpression) {
		super(p_FirstExpression, p_SecondExpression);
	}

	@Override
	public int calculate() throws ExpressionException {
		Expression secondExpression = super.getSecondExpression();
		
		if (secondExpression.calculate() == CANNOT_DIVIDE_BY_ZERO) {
			
			throw new DivideByZeroException();
		}
		
		return super.getFirstExpression().calculate() / secondExpression.calculate();
	}

}
