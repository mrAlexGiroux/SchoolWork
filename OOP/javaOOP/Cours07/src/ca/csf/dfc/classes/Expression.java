package ca.csf.dfc.classes;
import ca.csf.dfc.exception.*;

public interface Expression {

    public int calculate() throws ExpressionException;
}
