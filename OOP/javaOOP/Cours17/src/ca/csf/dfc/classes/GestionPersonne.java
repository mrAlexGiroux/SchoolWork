package ca.csf.dfc.classes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.tools.JavaFileManager;

public class GestionPersonne extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1703207448345960089L;

	
	public GestionPersonne()
	{
		super("Gestion de personne");
		
		this.initialiseWindow();
	}
	
	private void initialiseWindow()
	{
		this.buildLayoutAndAddComponent();
		this.initializeMenuBarAndItems();
		this.setWindowFrameAndBehavior();
	}
	
	private void buildLayoutAndAddComponent()
	{
		this.setLayout(new BorderLayout(7,7));
		this.add(createJPanelWithGridLayout(), BorderLayout.EAST);
		this.add(createPanelWithScrollText(), BorderLayout.CENTER);
		
	}
	
	private JPanel createJPanelWithGridLayout()
	{
		JPanel panelWithGrid = new JPanel();
		
		panelWithGrid.setLayout(new GridLayout(4, 1));
		panelWithGrid.add(new JButton("Ajouter"));
		panelWithGrid.add(new JButton("Modifier"));
		panelWithGrid.add(new JButton("Supprimer"));
		panelWithGrid.add(new JButton("Quitter"));
		
		return panelWithGrid;
	}
	
	private JScrollPane createPanelWithScrollText()
	{
		JScrollPane panelWithScrollText = new JScrollPane(new JTextArea("Allo",20,20));
		
		return panelWithScrollText;
	}
	
	private void initializeMenuBarAndItems()
	{
		JMenuBar menuWindow = new JMenuBar();
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenu menuFile = new JMenu("Files");
		menuFile.add(open);
		menuFile.add(save);
		menuFile.addSeparator();
		menuFile.add(quit);
		
		menuWindow.add(menuFile);
		
		JMenu menuEdit = new JMenu("Edit");
		menuEdit.add(new JMenuItem("Copy"));
		menuEdit.add(new JMenuItem("Cut"));
		menuEdit.add(new JMenuItem("Paste"));
		
		menuWindow.add(menuEdit);
		
		JMenu menuHelp = new JMenu("Help, Please!");
		menuHelp.add(new JMenuItem("About"));
		
		menuWindow.add(menuHelp);
		
		open.addActionListener(new ManagerOpen());
		save.addActionListener(new ManagerSave());
		quit.addActionListener(new ManagerQuit());
		
		this.setJMenuBar(menuWindow);
	}
	
	private class ManagerOpen implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser(".");
			
			chooser.setFileFilter(new TextFileFilter());
			
			int result = chooser.showOpenDialog(GestionPersonne.this);
			
			String msg = null;
			
			if (result == JFileChooser.APPROVE_OPTION) {
				msg = "User choose : " + chooser.getSelectedFile();
			}
			else {
				msg = "User hasn't choosen a file";
			}
		}
		
	}
	
	private static class TextFileFilter extends FileFilter
	{

		@Override
		public boolean accept(File p_file) {
			boolean accept = false;
			
			if (p_file.isDirectory()) {
				accept = true;
			} else {
				String ext = extractExtension(p_file);
				if ((ext != null) && ext.equalsIgnoreCase("txt")) {
					accept = true;
				}
			}
			return accept;
		}

		@Override
		public String getDescription() {

			return "Text file (.txt)";
		}
		
		private static String extractExtension(File p_file)
		{
			String fileName = p_file.getName();
			int index = fileName.lastIndexOf(".");
			
			String extension = null;
			
			if (index > 0 && index < fileName.length() - 1) {
				extension = fileName.substring(index + 1).toLowerCase();
			}
			
			return extension;
		}
		
	}
	
	private class ManagerSave implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	private class ManagerQuit implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	private void setWindowFrameAndBehavior()
	{
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
