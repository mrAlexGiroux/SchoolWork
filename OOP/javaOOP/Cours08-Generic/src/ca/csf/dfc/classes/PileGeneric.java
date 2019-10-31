package ca.csf.dfc.classes;

import java.util.*;

import ca.csf.dfc.classes.exception.*;

public class PileGeneric<TypeElement> {

	private final int TAILLE_MINIMUM = 0;
	
	private List<TypeElement> m_donnee;
	private int m_tailleTableau;
	private int m_tailleMaximum;
	
	/**
	 * 
	 * @param p_Taille
	 */
	public PileGeneric(int p_Taille)
	{
		if (p_Taille < TAILLE_MINIMUM ) {
			throw new IllegalArgumentException("initialisation | < 0");
		}
		this.m_donnee = new ArrayList<TypeElement>(p_Taille);
		this.m_tailleMaximum = p_Taille;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean estVide()
	{
		return this.m_donnee.isEmpty();
	}
	
	/**
	 * 
	 * @param p_element
	 */
	public void empiler(TypeElement p_Element) throws PileException
	{
		if (this.m_tailleTableau == this.m_tailleMaximum) {
			throw new PilePleineException();
		}
		this.m_donnee.add(p_Element);
	}
	
	/**
	 * 
	 * @param p_element
	 */
	public void depiler(TypeElement p_element) throws PileException
	{
		if (this.m_tailleTableau == TAILLE_MINIMUM) {
			throw new PileVideException();
		}
		this.m_donnee.remove(this.m_tailleTableau - 1);
	}
	
	/**
	 * 
	 * @param p_element
	 */
	public void sommet(TypeElement p_element)
	{
		this.m_donnee.get(m_tailleTableau - 1); 
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
