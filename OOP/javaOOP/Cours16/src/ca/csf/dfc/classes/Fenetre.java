package ca.csf.dfc.classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4351686856680603045L;

	public static final boolean rdo_ = false;

	JTextField txt = new JTextField(10);
	JButton btn_Go = new JButton("Go");
	JRadioButton rdo_bleu = new JRadioButton("Bleu");
	JRadioButton rdo_rouge = new JRadioButton("Rouge");
	JRadioButton rdo_vert = new JRadioButton("Vert");
	JCheckBox chk_italique = new JCheckBox("Italique");
	JCheckBox chk_gras = new JCheckBox("Gras");
	JLabel lbl_Texte = new JLabel("text ici");

	ButtonGroup grp_couleur = new ButtonGroup();

	public Fenetre() {
		super("Exercice");

		this.BuildContainer();
		this.SetWindowFrameAndBehavior();
		this.GroupRadiobuttons();
		this.CreateAndBuildListeners();

	}
	
	private void BuildContainer()
	{
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(this.txt);
		c.add(this.btn_Go);
		c.add(this.rdo_bleu);
		c.add(this.rdo_rouge);
		c.add(this.rdo_vert);
		c.add(this.chk_italique);
		c.add(this.chk_gras);
		c.add(this.lbl_Texte);
	}
	
	private void SetWindowFrameAndBehavior()
	{
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void GroupRadiobuttons()
	{
		grp_couleur.add(this.rdo_bleu);
		grp_couleur.add(this.rdo_rouge);
		grp_couleur.add(this.rdo_vert);
	}

	private void CreateAndBuildListeners()
	{
		GoMouseListener goMouseListener = new GoMouseListener(this.txt.getText(), this.lbl_Texte);
		this.btn_Go.addMouseListener(goMouseListener);
		
		ColorItemListener colorItemListener = new ColorItemListener(this.lbl_Texte);
		this.rdo_bleu.addItemListener(colorItemListener);
		this.rdo_rouge.addItemListener(colorItemListener);
		this.rdo_vert.addItemListener(colorItemListener);
		
		FontItemListener fontItemListener = new FontItemListener(this.lbl_Texte);
		this.chk_gras.addItemListener(fontItemListener);
		this.chk_italique.addItemListener(fontItemListener);
	}

	public class GoMouseListener extends MouseAdapter implements ActionListener {

		
		
		private String m_Texte;
		
		public GoMouseListener(String p_Texte, JLabel p_Destination) {
			this.m_Texte = p_Texte;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			lbl_Texte.setText(txt.getText());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


		

	}
	
	public class ColorItemListener implements ItemListener {

		private JLabel m_Destination;
		
		public ColorItemListener(JLabel p_Destination) {
			this.m_Destination = p_Destination;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (rdo_bleu.isSelected()) {
				this.m_Destination.setForeground(Color.blue);
			} else if (rdo_rouge.isSelected()) {
				this.m_Destination.setForeground(Color.red);
			} else if (rdo_vert.isSelected()) {
				this.m_Destination.setForeground(Color.green);
			}
		}
		
	}

	public class FontItemListener implements ItemListener {

		private JLabel m_Destination;
		
		public FontItemListener(JLabel p_Destination) {

			this.m_Destination = p_Destination;
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			int fontMode = 0;
			
			if (chk_gras.isSelected()) 
			{
				fontMode += Font.BOLD;
			}
			if (chk_italique.isSelected())
			{
				fontMode += Font.ITALIC;
			}
			this.m_Destination.setFont(new Font("Roboto", fontMode,24));
		}
	}
	public class EnterKeyListener implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
					
		}
		
	}
}
