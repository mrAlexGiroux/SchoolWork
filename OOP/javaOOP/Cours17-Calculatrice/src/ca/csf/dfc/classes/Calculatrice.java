package ca.csf.dfc.classes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculatrice extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3556519484645974718L;
	
	private JButton btn_CE = new JButton("CE");
	private JButton btn_Plus = new JButton("+");
	private JButton btn_Minus = new JButton("-");
	private JButton btn_Divide = new JButton("/");
	private JButton btn_Multiply = new JButton("*");
	private JButton btn_Equals = new JButton("=");
	
	private JTextArea txt_Result = new JTextArea();
	
	public Calculatrice()
	{
		super("Calculatrice");
		
		this.initialiseWindow();
	}
	
	private void initialiseWindow()
	{
		this.buildLayoutAndAddComponent();
		this.setWindowFrameAndBehavior();
	}
	
	private void buildLayoutAndAddComponent()
	{
		Container c = this.getContentPane();
		
		c.setLayout(new BorderLayout(7,7));
		this.add(txt_Result, BorderLayout.NORTH);
		this.add(createJPanelWithGridForOperators(), BorderLayout.EAST);
		this.add(createJPanelWithGridForNumbers(), BorderLayout.CENTER);
	}
	
	private JPanel createJPanelWithGridForOperators()
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(5, 1));
		panel.add(btn_CE);
		panel.add(btn_Plus);
		panel.add(btn_Minus);
		panel.add(btn_Divide);
		panel.add(btn_Multiply);
		
		return panel;	
	}
	
	private JPanel createJPanelWithGridForNumbers()
	{
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(4,3));
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("0"));
		panel.add(new JButton("."));
		panel.add(btn_Equals);
		
		return panel;
	}
	
	private void setWindowFrameAndBehavior()
	{
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
