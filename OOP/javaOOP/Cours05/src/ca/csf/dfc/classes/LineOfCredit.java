package ca.csf.dfc.classes;

/**
 * @author alexandregiroux
 *
 */

public class LineOfCredit extends Bank {

	private final int MAX_TRANSACTION = 10;
	private final double INTEREST_FEE = 0.05;
	
	private int operationCount;
	private double m_lineCreditBalance;
	

	public LineOfCredit()
	{
		this(MINIMUM_BALANCE);
		this.CheckBalanceAndIncreaseCount();
	}
	
	public LineOfCredit(double p_Amount)
	{
		this.m_lineCreditBalance = p_Amount;
		this.CheckBalanceAndIncreaseCount();	
	}
	
	@Override
	public void Deposit(double p_Amount) {
		this.CheckBalanceAndIncreaseCount();
		this.m_lineCreditBalance += (p_Amount - this.CalculateTransactionFee() - TRANSACTION_FEE);
	}

	@Override
	public void Withdraw(double p_Amount) {
		this.CheckBalanceAndIncreaseCount();
		this.m_lineCreditBalance += (p_Amount - this.CalculateTransactionFee() - TRANSACTION_FEE);
	}

	@Override
	public double GetBalance() {
		return this.m_lineCreditBalance;
	}
	
	private double CalculateTransactionFee()
	{
		double transactionFee = 0.0;
		
		if(operationCount > MAX_TRANSACTION && this.GetBalance() < MINIMUM_BALANCE)
		{
			transactionFee = this.GetBalance() * INTEREST_FEE;
		}
		
		return transactionFee;
	}
	
	private void CheckBalanceAndIncreaseCount() 
	{
		if(this.GetBalance() < MINIMUM_BALANCE)
		{
			this.operationCount++;
		}
		else
		{
			this.operationCount = 0;
		}
	}
}
