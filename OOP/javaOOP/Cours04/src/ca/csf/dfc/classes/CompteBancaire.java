package ca.csf.dfc.classes;

public class CompteBancaire {

    private double m_Solde;

    public final static double SOLDE_MINIMUM = 0;
    public final static double FRAIS_TRANSACTION = 0.25;

    public CompteBancaire()
    {
        this(SOLDE_MINIMUM);
    }

    public CompteBancaire(double p_Solde)
    {
        this.m_Solde = p_Solde;
    }

    /**
     * Deposit the amount
     * @param p_Amount
     */
    public void Deposer(double p_Amount)
    {
        this.m_Solde += p_Amount;
    }

    /**
     * Withdraw the amount
     * @param p_Amount
     */
    public void Retirer(double p_Amount)
    {
        this.m_Solde -= p_Amount;
    }

    /**
     * @return the m_Solde
     */
    public double getSolde() {
        return m_Solde;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
