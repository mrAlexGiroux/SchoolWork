/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauImage extends JPanel
{
    private static final long serialVersionUID = 1L;

    private Icon m_Image;

    /**
     * Constructeur
     */
    public PanneauImage()
    {
        super();

        // Chargement de l'image
        m_Image = new ImageIcon(getClass().getResource("/res/DukeWithHelmet.png"));
    }

    /**
     * Sera appelée pour afficher ce JPanel
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics p_Graphic)
    {
        m_Image.paintIcon(this, p_Graphic, 0, 0);
    }
}
