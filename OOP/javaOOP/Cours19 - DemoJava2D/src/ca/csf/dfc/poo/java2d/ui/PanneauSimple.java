/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauSimple extends JPanel
{
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur
     */
    public PanneauSimple()
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
        Graphics2D g2 = (Graphics2D) p_Graphic;

        g2.setStroke(new BasicStroke(8));

        p_Graphic.drawRect(10, 10, 35, 50);

        p_Graphic.setColor(Color.BLUE);
        p_Graphic.fillRect(10, 75, 20, 20);
        p_Graphic.fillOval(50, 10, 45, 20);

        p_Graphic.setColor(new Color(200, 125, 40));
        p_Graphic.fillRoundRect(10, 115, 100, 75, 20, 20);
    }
}
