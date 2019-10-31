package ca.csf.dfc.classes;

public class Temps {

	/**
	 * Duree minimum pour secondes et minutes
	 */
	public final static int DUREE_MIN = 0;

	/**
	 * Duree maximum pour secondes et minutes
	 */
	public final static int DUREE_MAX = 59;

	/**
     * Un nombre de secondes, compris entre 0 et 59 inclusivement.
     */
    private int m_Secondes;
    /**
     * Un nombre de minutes, compris entre 0 et 59 inclusivement.
     */
    private int m_Minutes;
    /**
     * Un nombre d’heures, plus grand ou égal à zéro.
     */
    private int m_Heures;

	/**
	 * Constructeur par defaut
	 */
    public Temps() {
		setSecondes(0);
		setMinutes(0);
		setHeures(0);
    }
	
	/**
	 * Constructeur avec secondes
	 * @param p_Secondes
	 */
    public Temps(int p_Secondes)
    {
		this(p_Secondes, DUREE_MIN, DUREE_MIN);
	}
	
	/**
	 * Constructeur avec secondes et minutes
	 * @param p_Seconde
	 * 	Le nombre de seconde
	 * @param p_Minutes
	 * 	Le nombre de minutes
	 */
	public Temps(int p_Secondes, int p_Minutes)
    {
		this(p_Secondes, p_Minutes, DUREE_MIN);
	}
	
	/**
	 * Constructeur avec secondes, minutes et heures
	 * @param p_Seconde
	 * @param p_Minutes
	 * @param p_Heures
	 */
	public Temps(int p_Secondes, int p_Minutes, int p_Heures)
    {
        setSecondes(p_Secondes);
        setMinutes(p_Minutes);
        setHeures(p_Heures);
    }
	
	public Temps additionnerTemps(Temps p_Premier, Temps p_Deuxieme)
	{
		
		Temps nouveauTemps = new Temps();

		nouveauTemps.setSecondes(p_Premier.getSecondes() + p_Deuxieme.getSecondes());
		nouveauTemps.setMinutes(nouveauTemps.getMinutes() + p_Premier.getMinutes() + p_Deuxieme.getMinutes());
		nouveauTemps.setHeures(nouveauTemps.getHeures() + p_Premier.getHeures() + p_Deuxieme.getHeures());
		
		return nouveauTemps;
	}
    /**
	 * Retourne le secondes.
	 * @return the secondes
	 */
	public int getSecondes() {
		return this.m_Secondes;
	}

	/**
	 * Pour modifier le secondes.
	 * @param p_secondes the secondes to set
	 */
	public void setSecondes(int p_Secondes) {
		if (p_Secondes > DUREE_MAX) {
			setMinutes(p_Secondes / 60);
		}
		this.m_Secondes = p_Secondes % 60;
	}

	/**
	 * Retourne le minutes.
	 * @return the minutes
	 */
	public int getMinutes() {
		return this.m_Minutes;
	}

	/**
	 * Pour modifier le minutes.
	 * @param p_minutes the minutes to set
	 */
	public void setMinutes(int p_Minutes) {
		if (p_Minutes > DUREE_MAX) {
			setHeures(p_Minutes / 60);
		}
		this.m_Secondes = p_Minutes % 60;
	}

	/**
	 * Retourne le heures.
	 * @return the heures
	 */
	public int getHeures() {
		return this.m_Heures;
	}

	/**
	 * Pour modifier le heures.
	 * @param p_heures the heures to set
	 */
	public void setHeures(int p_Heures) {
		if (p_Heures < DUREE_MIN) {
			throw new IllegalArgumentException("Le nombre d'heure doit etre plus grand ou egal a zero");
		}
		this.m_Heures = p_Heures;
	}

	@Override
	/**
	 * @see java.lang.Override
	 */
	public String toString() {
		StringBuilder builder = new	StringBuilder();

		builder.append(getHeures());
		builder.append(":");
		builder.append(getMinutes());
		builder.append(":");
		builder.append(getSecondes());
		return builder.toString();
	}
}
