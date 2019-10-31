/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class PanneauGrenouille extends JPanel
{
    private static final long serialVersionUID = 1L;

    /**
     * Position en X
     */
    private int m_X;
    /**
     * Position en Y
     */
    private int m_Y;

    /**
     * Images
     */
    private BufferedImage m_Image;

    /**
     * Constructeur
     */
    public PanneauGrenouille()
    {
        super();

        try
        {
            m_Image = ImageIO.read(getClass().getResource("/res/frog_mario.jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Pour générer le mouvement.
     */
    public void faireMouvement()
    {
        Random rd = new Random();
        m_X = this.getWidth() / 2;
        m_Y = this.getHeight() / 2;

        while (true)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            // if (rd.nextInt(5) >= 4)
            {
                m_X = m_X + 15 * (rd.nextBoolean() ? +1 : -1);
                m_Y = m_Y + 15 * (rd.nextBoolean() ? +1 : -1);
            }
            this.repaint();
        }
    }

    /**
     * Sera appelée pour afficher ce JPanel
     * 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics p_Graphic)
    {
        super.paintComponent(p_Graphic);

        p_Graphic.drawImage(m_Image, m_X, m_Y, 100, 100, null);

    }
}
