package cours15;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcouteurDeSouris extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2008610272644441845L;

	JLabel lbl_Mousse = new JLabel("Commencons");
	
	
	public EcouteurDeSouris()
	{
		
		super("Ecoutez la souris");
		
	Container c = this.getContentPane();
	c.setLayout(new FlowLayout());
	c.add(lbl_Mousse);
	
	this.setSize(300, 200);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	
	GestionMouse gestionMouse = new GestionMouse();
	this.lbl_Mousse.addMouseListener(gestionMouse);
	}
	private class GestionMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent p_event) {
			lbl_Mousse.setText("Souris clicker");
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			lbl_Mousse.setText("Souris entrer");
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			lbl_Mousse.setText("Souris Sorti");
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			lbl_Mousse.setText("Souris Appuyer");
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			lbl_Mousse.setText("Souris Relacher");
			
		}
		
		
	}
	
}
