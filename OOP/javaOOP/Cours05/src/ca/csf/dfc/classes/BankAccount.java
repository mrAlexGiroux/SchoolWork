package ca.csf.dfc.classes;

public class BankAccount extends Bank{
	

	
	private double m_AccountBalance;
	
	public BankAccount()
	{
		this.m_AccountBalance = MINIMUM_BALANCE;
	}
	
    public BankAccount(double p_Balance)
    {
    	this.m_AccountBalance = p_Balance;
    }
    
	@Override
	public void Deposit(double p_Amount) {
		if(p_Amount < MINIMUM_BALANCE)
		{
			throw new IllegalArgumentException("Cannot be negative");
		}
		this.m_AccountBalance += p_Amount;
	}

	@Override
	public void Withdraw(double p_Amount) {
		this.m_AccountBalance -= p_Amount;
	}

	@Override
	public double GetBalance() {
		return m_AccountBalance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account Balance : " + this.GetBalance();
	}
	
	


}
