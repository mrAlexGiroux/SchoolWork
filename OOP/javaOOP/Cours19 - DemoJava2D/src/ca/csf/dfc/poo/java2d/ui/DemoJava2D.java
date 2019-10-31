/**
 *
 */
package ca.csf.dfc.poo.java2d.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author nrichard
 */
public class DemoJava2D extends JFrame
{
    private static final long serialVersionUID = 1L;

    public DemoJava2D(JPanel p_PanneauPrincipal)
    {
        super("Demo Java2D");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(p_PanneauPrincipal, BorderLayout.CENTER);

        this.setSize(512, 512);
        this.setLocationRelativeTo(null);
    }
}
