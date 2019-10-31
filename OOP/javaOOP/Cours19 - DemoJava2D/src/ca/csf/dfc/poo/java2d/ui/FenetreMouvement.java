/**
 * 
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * @author nrichard
 */
public class FenetreMouvement extends JFrame
{
    private static final long serialVersionUID = 1L;

    PanneauGrenouille pnl_Grenouille = new PanneauGrenouille();

    public FenetreMouvement()
    {
        super("Demo Java2D");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(pnl_Grenouille, BorderLayout.CENTER);

        this.setSize(512, 512);
        this.setLocationRelativeTo(null);
    }

    /**
     * Pour generer le mouvement
     */
    public void faireMouvement()
    {
        pnl_Grenouille.faireMouvement();

    }
}
