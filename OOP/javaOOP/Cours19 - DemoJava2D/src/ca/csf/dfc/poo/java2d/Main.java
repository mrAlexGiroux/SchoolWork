/**
 *
 */

package ca.csf.dfc.poo.java2d;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import ca.csf.dfc.poo.java2d.ui.*;

/**
 * @author nrichard
 */
public class Main
{

    /**
     * @param args
     */
    public static void main(String[] args)
    { 
        // new DemoJava2D(new PanneauSimple()).setVisible(true);

        // new DemoJava2D(new PanneauPolice()).setVisible(true);

        // new DemoJava2D(new PanneauImage()).setVisible(true);

        // new DemoJava2D(new PanneauDessin()).setVisible(true);

    	// Demo 5a, b
         //PanneauMouvement pan = new PanneauMouvement();
         PanneauGrenouille pan = new PanneauGrenouille();
        
         new DemoJava2D(pan).setVisible(true);
         pan.faireMouvement();

    	// Demo 6
        // FenetreMouvement fenetre = new FenetreMouvement();
        // fenetre.setVisible(true);
        // fenetre.faireMouvement();

    }
}
