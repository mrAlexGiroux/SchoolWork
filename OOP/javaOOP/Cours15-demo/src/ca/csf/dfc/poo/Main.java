/**
 * 
 */
package ca.csf.dfc.poo;

import javax.swing.JOptionPane;

/**
 * @author nrichard
 */
public class Main
{

    /**
     * Demontre l'utilisation du JOptionPane
     */
    private static void demoJOptionPane()
    {
        JOptionPane.showMessageDialog(null, "Bonjour !");

        String nb1 = JOptionPane.showInputDialog("Entrez un nombre");
        String nb2 = JOptionPane.showInputDialog("Entrez un nombre");

        if ((nb1 != null) && (nb2 != null))
        {
            // L'usage n'a pas clique sur "Cancel"
            double somme = Double.parseDouble(nb1) + Double.parseDouble(nb2);

            JOptionPane.showMessageDialog(null, // Fenetre parent (aucune ici)
                    "Voici la somme : " + somme, // Texte
                    "La somme", // Titre
                    JOptionPane.ERROR_MESSAGE); // Type

            int resultat = JOptionPane
                    .showConfirmDialog(null, "Satisfait ?", "Une question", JOptionPane.YES_NO_OPTION); // Boutons

            if (resultat == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Good !", "Réponse", JOptionPane.PLAIN_MESSAGE); // Type

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Dommage ...", "Réponse", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Demonstration des fenetres avec Swing.
     */
    private static void demoFenetre()
    {
        // Instanciation
        Fenetre fenetre = new Fenetre();

        // Pour montrer que la methode setVisible() n'est
        // pas bloquante.
        System.out.println("Avant le setVisible(true)");
        fenetre.setVisible(true);
        System.out.println("Apres le setVisible(true)");
    }

    /**
     * Demonstration des possibilites Swing
     */
    private static void demoSwing()
    {
        DemoSwing fenetre = new DemoSwing();
        fenetre.setVisible(true);

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    	
        //demoJOptionPane();

        demoFenetre();

        //demoSwing();

        //new DemoSouris().setVisible(true);
        
        //new Joke().setVisible(true);
    }
}
