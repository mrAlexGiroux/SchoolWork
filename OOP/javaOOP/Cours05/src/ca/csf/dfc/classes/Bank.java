package ca.csf.dfc.classes;

public abstract class Bank {
	
	public final static double MINIMUM_BALANCE = 0;
    public final static double TRANSACTION_FEE = 0.25;
	
	public abstract void Deposit(double p_Amount);

	public abstract void Withdraw(double p_Amount);

	public abstract double GetBalance();
}