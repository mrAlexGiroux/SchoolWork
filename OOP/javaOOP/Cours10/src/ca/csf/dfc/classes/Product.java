package ca.csf.dfc.classes;

public class Product {
	
    public int m_ProductID;
    public String m_ProductName;
    public String m_Category;
    public double m_UnitPrice;
    public int m_UnitsInStock;

	public Product(int p_productID, String p_productName, String p_category, double p_unitPrice, int p_unitsInStock) {
		super();
		this.m_ProductID = p_productID;
		this.m_ProductName = p_productName;
		this.m_Category = p_category;
		this.m_UnitPrice = p_unitPrice;
		this.m_UnitsInStock = p_unitsInStock;
	}

	public int getProductID() {
		return this.m_ProductID;
	}
	public String getProductName() {
		return this.m_ProductName;
	}
	public String getCategory() {
		return this.m_Category;
	}
	public double getUnitPrice() {
		return this.m_UnitPrice;
	}
	public int getUnitsInStock() {
		return this.m_UnitsInStock;
	}

    @Override
    public String toString() {
    	return "Product(ProductID = " + this.m_ProductID 
    		   + ", ProductName = " + this.m_ProductName 
    		   + ", Category = " + this.m_Category 
    		   + ", UnitPrice = " + this.m_UnitPrice 
    		   + ", UnitsInStock = " + this.m_UnitsInStock + ")";
    }
}
