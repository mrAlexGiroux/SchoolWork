package cours15;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3343594929092840131L;

	JTextField txt_NbUn = new JTextField(10);
	JTextField txt_NbDeux = new JTextField(10);
	JButton btn_Calculer = new JButton("Calculer");
	JLabel lbl_Question = new JLabel("Entrez un nombre");
	
	public Calculer()
	{
		super("Calculer");
		
		txt_NbUn.setToolTipText("Insert number here!");
		txt_NbDeux.setToolTipText("You got Squared");
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(this.lbl_Question);
		c.add(this.txt_NbUn);
		c.add(this.btn_Calculer);
		c.add(this.txt_NbDeux);

		GestionActionBtnCalculer gestionBtnOk = new GestionActionBtnCalculer();
		this.btn_Calculer.addActionListener(gestionBtnOk);
		
		this.pack();
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class GestionActionBtnCalculer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Double nombre = Double.parseDouble(Calculer.this.txt_NbUn.getText());
			
			Double resultat = Math.pow(nombre, 2);
			
			Calculer.this.txt_NbDeux.setText(resultat.toString());
			
		}
		
	}
}
