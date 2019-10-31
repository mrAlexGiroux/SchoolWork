/**
 * 
 */
package ca.csf.dfc.classes.test;
import ca.csf.dfc.exception.*;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.csf.dfc.classes.*;
/**
 * @author Alexandre Giroux
 *
 */
public class AddTest {

	/**
	 * Test method for {@link ca.csf.dfc.classes.Add#calculate()}.
	 */
	@Test
	public void testCalculer() throws ExpressionException{

		for (int i = 0; i < 10; i++) {
			Expression test = new Add(new NewInteger(i), new NewInteger(i));
			
			assertEquals(test.calculate(), i * 2);
		}
		
		
		
	}
}
