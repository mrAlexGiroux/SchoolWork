package ca.csf.dfc.poo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Démonstration d'événements de souris
 */
public class DemoSouris extends JFrame
{
	private static final long serialVersionUID = -555045528817660331L;
	
	JLabel lbl_Msg1 = new JLabel("", JLabel.CENTER);
    JLabel lbl_Msg2 = new JLabel("", JLabel.CENTER);

    // constructeur
    public DemoSouris()
    {
        super("Démo d'événements de souris");

        // Dans le constructeur
        // Création d'une instance de ma classe d'écoute
        GestClickSouris gestClickSouris = new GestClickSouris();
        // Ajout à la liste d'écoute du JFrame
        this.addMouseListener(gestClickSouris);

        Container c = this.getContentPane();
        c.setLayout(new GridLayout(2, 1));
        c.add(lbl_Msg1);
        c.add(lbl_Msg2);

        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * Gestionnaire de clique de souris.
     */
    private class GestClickSouris implements MouseListener
    {
        /**
         * Appelée lorsque le bouton est enfoncé puis relâché.
         */
        public void mouseClicked(MouseEvent e)
        {
            lbl_Msg1.setText("Souris cliqué");
        }// met

        /**
         * Est appelée lorsque le curseur entre dans la zone écoutée.
         */
        public void mouseEntered(MouseEvent e)
        {
            lbl_Msg1.setText("La souris est entré dans la fenêtre");
        }// met

        /**
         * Est appelée lorsque la souris sort de la zone écoutée.
         */
        public void mouseExited(MouseEvent e)
        {
            lbl_Msg1.setText("Souris sortie");
            lbl_Msg2.setText("");
        }// met

        /**
         * Est appelée Lorsqu'on appuie sur le bouton.
         */
        public void mousePressed(MouseEvent e)
        {
            lbl_Msg2.setText("Bouton enfoncé");
        }// met

        /**
         * Est appelé lorsque le bouton est relâché.
         */
        public void mouseReleased(MouseEvent e)
        {
            lbl_Msg2.setText("Bouton relâché");
        }// met
    }// classe interne

}// class
