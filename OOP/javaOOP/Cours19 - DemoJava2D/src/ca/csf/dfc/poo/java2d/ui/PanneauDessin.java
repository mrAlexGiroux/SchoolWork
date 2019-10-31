/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauDessin extends JPanel
{
    private static final long serialVersionUID = 1L;

    private ArrayList<Point> m_Points;

    public PanneauDessin()
    {
        super();

        this.m_Points = new ArrayList<Point>();

        this.addMouseMotionListener(new GestSouris());
    }

    /**
     * Redéfinition.
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics p_Graphic)
    {
        super.paintComponent(p_Graphic);

        for (Point p : this.m_Points)
        {
            p_Graphic.fillOval((int) p.getX(), (int) p.getY(), 5, 5);
        }
    }

    private class GestSouris implements MouseMotionListener
    {

        @Override
        public void mouseDragged(MouseEvent p_Event)
        {
            m_Points.add(p_Event.getPoint());
            PanneauDessin.this.repaint();

        }

        @Override
        public void mouseMoved(MouseEvent p_Event)
        {}

    }
}
