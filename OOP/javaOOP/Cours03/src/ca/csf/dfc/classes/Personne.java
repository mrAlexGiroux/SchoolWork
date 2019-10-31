package ca.csf.dfc.classes;
/**
 * Classe representant une personne, avec son nom et son age.
 * Nous n'acceptons pas de nom a nul. Mettez une chaine vide sur place
 * @author Alexandre Giroux
 */
public class Personne {

    public final static int AGE_DEFAULT = 0; 
    /**
     * L'age de la personne
     */
    private int m_Age;
    /**
     * Le nom de la personne
     */
    private String m_Nom;


    /**
     * Constructeur par default
     */
    public Personne()
    {
        //setAge(0);
        //this.m_Nom = "";
        //Utilisation du constructeur par initialisation
        this(AGE_DEFAULT, "");
    }

    /***
     * Constructeur pour un nouveau nee
     * @param p_Nom
     *      Le nom de la personne
     */
    public Personne(String p_Nom)
    {
        this(AGE_DEFAULT, p_Nom);
    }
    /**
     * Constructeur par initialisation
     * @param p_Age
     *  L'age de la personne
     * @param p_Nom
     *  Le nom de la personne
     */
    public Personne(int p_Age, String p_Nom)
    {
        setAge(p_Age);
        this.m_Nom = p_Nom;
    }
    
    /**
     * 
     * @return 
     */
    public int getAge()
    {
        return this.m_Age;
    }
    /**
     * 
     * @param p_nouvelAge
     */
    public void setAge(int p_nouvelAge)
    {
        if (p_nouvelAge < 0) {
            throw new IllegalArgumentException("p_nouvelAge doit etre >= 0");
        }
        this.m_Age = p_nouvelAge;
    }
    /**
     * 
     * @return 
     */
    public String getNom()
    {
        return this.m_Nom;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @return the m_Age
     */
    public int getM_Age() {
        return m_Age;
    }

    /**
     * @param m_Age the m_Age to set
     */
    public void setM_Age(int m_Age) {
        this.m_Age = m_Age;
    }

    /**
     * @return the m_Nom
     */
    public String getM_Nom() {
        return m_Nom;
    }

    /**
     * @param m_Nom the m_Nom to set
     */
    public void setM_Nom(String m_Nom) {
        this.m_Nom = m_Nom;
    }


}
