/**
 * 
 */
package ca.csf.dfc.classes;

/**
 * @author girou
 *
 */
public class MargeCredit extends CompteBancaire {

    /**
     * Operation maximum avant interet
     */
    private final int OPERATION_MAX = 10;
    /**
     * Taut d'interet pour plus de 10 transaction dans un solde negatif
     */
    private final double FRAIS_INTERET = 0.05;
    /**
     * Compteur pour determiner si les frais de d'interet s'applique
     */
    private int compteurOperation;

    /**
     * Constructeur par defaut
     */
    public MargeCredit()
    {
        super();
    }

    /**
     * Constructeur par inialisation avec un solde determiner
     * @param p_Solde
     */
    public MargeCredit(double p_Solde)
    {
        super(p_Solde);
    }

    @Override
    public void Deposer(double p_Solde)
    {
        if (compteurOperation < 10 && super.getSolde() < SOLDE_MINIMUM) {
            super.Deposer(p_Solde - (super.getSolde() * FRAIS_INTERET));
        }
        super.Deposer(p_Solde);
    }

    @Override
    public void Retirer(double p_Solde)
    {

    }

}
