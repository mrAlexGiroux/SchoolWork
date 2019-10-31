/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauPolice extends JPanel
{
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    public PanneauPolice()
    {
        super();
    }

    /**
     * Sera appelée pour afficher ce JPanel
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics p_Graphic)
    {
        // Pour améliorer l'affichage :
        Graphics2D g2d = (Graphics2D) p_Graphic;
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON));

        p_Graphic.setFont(new Font("Serif", Font.BOLD, 12));
        p_Graphic.drawString("Serif 12 point bold.", 20, 50);

        p_Graphic.setFont(new Font("Monospaced", Font.ITALIC, 24));
        p_Graphic.drawString("Monospaced 24 point italic.", 20, 70);

        p_Graphic.setFont(new Font("SansSerif", Font.PLAIN, 14));
        p_Graphic.drawString("SansSerif 14 point plain.", 20, 90);

        p_Graphic.setColor(Color.RED);
        p_Graphic.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
        p_Graphic.drawString(p_Graphic.getFont().getName() + " " + p_Graphic.getFont().getSize()
                + " point bold italic.", 20, 110);

    }
}
