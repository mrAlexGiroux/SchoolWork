/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauMouvement extends JPanel
{

    /**
     * Position qui se deplace
     */
    private int m_DecallageX;

    private final static int TAILLE_DECALLAGE = 1;

    public PanneauMouvement()
    {
        super();
        m_DecallageX = 0;
    }

    /**
     * Pour induire le mouvement.
     */
    public void faireMouvement()
    {
        for (int i = 0; i < this.getWidth() / TAILLE_DECALLAGE; i++)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            this.m_DecallageX++;
            this.repaint();
        }
    }

    /**
     * Sera appelee pour afficher ce JPanel
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics p_Graphic)
    {
        super.paintComponent(p_Graphic);
        p_Graphic.fillOval(this.m_DecallageX * TAILLE_DECALLAGE, 10, 20, 20);
    }
}
