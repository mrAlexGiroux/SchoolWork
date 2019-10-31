/**
 * 
 */
package ca.csf.dfc.poo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe pour demontrer l'utilisation minimale d'une fenetre.
 * 
 * @author nrichard
 */
public class Fenetre extends JFrame
{
	private static final long serialVersionUID = -3648379874268975528L;
	
    JLabel lbl_Question = new JLabel();
    JTextField txt_Nom = new JTextField(5);
    JButton btn_Ok = new JButton("OK");

    public Fenetre()
    {
        super("Demo fenetre");

        // Initialiser les composants :
        lbl_Question.setText("Bonjour. Entrez votre nom :");

        // Ajout a la fenetre
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(this.lbl_Question);
        c.add(this.txt_Nom);
        c.add(this.btn_Ok);
        this.btn_Ok.addActionListener(new GestActionsBtnOk());

        // Ajustement de la taille
        this.pack();
        // Centree au milieu de l'ecran
        this.setLocationRelativeTo(null);
        // Pour fermer l'application si on clique sur le X
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // ctor

    /**
     * Gestionnaire d'actions pour le bouton OK.
     * 
     * @author nrichard
     */
    private class GestActionsBtnOk implements ActionListener
    {

        /**
         * Appelee lorsqu'on clique sur le bouton.
         */
        @Override
        public void actionPerformed(ActionEvent p_event)
        {
            String nom = Fenetre.this.txt_Nom.getText();
            JOptionPane.showMessageDialog(Fenetre.this, "Salutations a " + nom);
        }// met
    }// class
}// class
