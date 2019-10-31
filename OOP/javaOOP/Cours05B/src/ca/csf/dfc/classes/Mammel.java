/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author alexandregiroux
 *
 */
public class Mammel extends Animal {

	private int m_TagNumber;
	
	public Mammel()
	{
		this.m_TagNumber = super.rand.nextInt(1000);
	}
	
	@Override
	public String Breathe() {
		return "The fish " + this.GetTagNumber() ;
	}

	@Override
	public String Move() {
		return "";
	}

	@Override
	public int GetTagNumber() {
		return this.m_TagNumber;
	}

	
}
