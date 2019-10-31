package ca.csf.dfc.classes;

public class Multiply extends BinaryOperation {

	public Multiply(Expression p_FirstExpression, Expression p_SecondExpression) {
		super(p_FirstExpression, p_SecondExpression);
	}

	@Override
	public int calculate() {
		return super.getFirstExpression().calculate() * super.getSecondExpression().calculate();
	}

}
