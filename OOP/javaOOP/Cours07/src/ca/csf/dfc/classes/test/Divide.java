package ca.csf.dfc.classes.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.csf.dfc.classes.Add;
import ca.csf.dfc.classes.Expression;
import ca.csf.dfc.classes.NewInteger;
import ca.csf.dfc.exception.ExpressionException;

/**
 * 
 * @author Alexandre Giroux
 *
 */
public class Divide{

	@Test
	public void testCalculate()  throws ExpressionException {
		for (int i = 0; i < 10; i++) {
			Expression test = new Add(new NewInteger(i), new NewInteger(i));
			
			assertEquals(test.calculate(), i / i);
		}
		
	}
}
