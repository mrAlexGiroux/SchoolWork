package ca.csf.dfc.classes;

public class CompteInteret extends CompteBancaire {

    
    public CompteInteret(double p_Solde)
    {
        super(p_Solde);
    }

    @Override
    public void Deposer(double p_Amount)
    {
        if (super.getSolde() < (p_Amount - FRAIS_TRANSACTION)) {
            throw new IllegalArgumentException("Le compte de peut etre negatif");
        }
        super.Deposer(p_Amount - FRAIS_TRANSACTION);
    }

    @Override
    public void Retirer(double p_Amount)
    {
        if (super.getSolde() < (p_Amount + FRAIS_TRANSACTION)) {
            throw new IllegalArgumentException("Le compte de peut etre negatif");
        }
        else
        {
            super.Retirer(p_Amount + FRAIS_TRANSACTION);
        }
    }   

}
