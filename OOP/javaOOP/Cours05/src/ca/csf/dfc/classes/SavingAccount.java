package ca.csf.dfc.classes;

public class SavingAccount extends Bank{

	private double m_SavingAccountBalance;
	
	public SavingAccount()
	{
		this(MINIMUM_BALANCE);
	}
	
	public SavingAccount(double p_Amount)
	{
		this.m_SavingAccountBalance = p_Amount;
	}
	
	@Override
	public void Deposit(double p_Amount) {
		this.CheckBalance(p_Amount - TRANSACTION_FEE);
		this.m_SavingAccountBalance += (p_Amount - TRANSACTION_FEE);
	}

	@Override
	public void Withdraw(double p_Amount) {
		this.CheckBalance(p_Amount + TRANSACTION_FEE);
		this.m_SavingAccountBalance -= (p_Amount - TRANSACTION_FEE);
	}

	@Override
	public double GetBalance() {
		return this.m_SavingAccountBalance;
	}
	
	private void CheckBalance(double p_Amount)
	{
		if(this.GetBalance() < (p_Amount))
		{
			throw new IllegalArgumentException("The account's balance cannot be negative");
		}
	}


}
