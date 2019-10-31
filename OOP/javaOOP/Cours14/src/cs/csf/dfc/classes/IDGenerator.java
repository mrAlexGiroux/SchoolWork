package cs.csf.dfc.classes;

public class IDGenerator {

	private int m_UniqueID;
	private static IDGenerator instance;
	
	private IDGenerator()
	{
		this.m_UniqueID = 0;
	}
	
	public static IDGenerator getInstance()
	{
		if (instance == null) {
			instance = new IDGenerator();
		}
		return instance;
	}
	
	public int getNextID()
	{
		return this.m_UniqueID++;
	}
}
