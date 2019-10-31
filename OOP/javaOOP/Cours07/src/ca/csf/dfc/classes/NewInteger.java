/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author alexandregiroux
 *
 */
public class NewInteger implements Expression {

   private int m_Value;

   public NewInteger(int p_IntNumber)
   {
        this.m_Value = p_IntNumber;
   }

   public int calculate()
   {
       return this.m_Value;
   }
}
