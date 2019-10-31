package ca.csf.dfc.poo;

import javax.swing.*;
import java.awt.*;

public class DemoSwing extends JFrame
{
	private static final long serialVersionUID = 4801017091793795869L;
	
	JLabel lbl_Jongleur = new JLabel();
    JPasswordField txt_MotDePasse = new JPasswordField(10);
    JButton btn_Demo = new JButton("Cliquez ici");

    JLabel lbl_Label1 = new JLabel("SansSerif, gras, taille 14 ");
    JLabel lbl_Label2 = new JLabel("Serif, gras, taille 14 ");
    JLabel lbl_Label3 = new JLabel("Monospaced, gras, taille 14 ");

    public DemoSwing()
    {
        super("Demo Swing");

        // Demo d'un JLabel avec une ico_Image
        Icon ico_Jongleur = new ImageIcon(getClass().getResource("/img/dukejongleur.gif"));

        lbl_Jongleur.setIcon(ico_Jongleur);
        lbl_Jongleur.setText("Voici Duke, la mascotte de Java");
        lbl_Jongleur.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl_Jongleur.setVerticalTextPosition(SwingConstants.TOP);
        lbl_Jongleur.setToolTipText("Cool Duke !");

        // Demo d'un JPasswordField
        txt_MotDePasse.setToolTipText("Entrez votre mot de passe");

        // JButton avec images
        ImageIcon ico_ImageRepos = new ImageIcon(getClass().getResource("/img/expvbuda.gif"));
        ImageIcon ico_ImageSourisDessus = new ImageIcon(getClass().getResource("/img/expvbuha.gif"));

        btn_Demo.setIcon(ico_ImageRepos);
        btn_Demo.setRolloverIcon(ico_ImageSourisDessus);
        btn_Demo.setToolTipText("Un beau bouton");

        // Demo de java.awt.Font
        lbl_Label1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lbl_Label2.setFont(new Font("Serif", Font.BOLD, 14));
        lbl_Label3.setFont(new Font("Monospaced", Font.BOLD, 14));

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(lbl_Jongleur);
        c.add(txt_MotDePasse);
        c.add(btn_Demo);
        c.add(lbl_Label1);
        c.add(lbl_Label2);
        c.add(lbl_Label3);

        this.setSize(250, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }// cons
}// class
