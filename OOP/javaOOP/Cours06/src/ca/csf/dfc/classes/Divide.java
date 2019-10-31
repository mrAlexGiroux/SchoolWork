package ca.csf.dfc.classes;

public class Divide extends BinaryOperation {

	private final int CANNOT_DIVIDE_BY_ZERO_BITCH = 0;

	public Divide(Expression p_FirstExpression, Expression p_SecondExpression) {
		super(p_FirstExpression, p_SecondExpression);
	}

	private void checkSecondExpressionForZero(Expression p_Expression)
	{
		if (p_Expression.calculate() == CANNOT_DIVIDE_BY_ZERO_BITCH) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
	}

	@Override
	public int calculate() {
		checkSecondExpressionForZero(super.getSecondExpression());
		return super.getFirstExpression().calculate() / super.getSecondExpression().calculate();
	}

}
