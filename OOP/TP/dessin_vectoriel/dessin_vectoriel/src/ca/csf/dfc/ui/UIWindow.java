package ca.csf.dfc.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ca.csf.dfc.persistance.OpenXML;
import ca.csf.dfc.persistance.SaveXML;
import ca.csf.dfc.ui.component.*;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 * Classe representant la fenetre principale
 * contenant les divers elements de controle
 * et de dessin.
 * Cette classe est SINGLETON afin de pouvoir
 * la passer en parametre dans les constructeurs
 * de JDialog (et aider le positionnement divers)
 */
public class UIWindow extends JFrame {

    private static UIWindow instance;
    private Controls btnCtrl;

    private DrawingBoard drawingBoard;
    private JSlider sliderWidth, sliderHeight;
    private JLabel canvasWidth = new JLabel("Width : ", SwingConstants.CENTER);
    private JLabel canvasHeight = new JLabel("Height : ", SwingConstants.CENTER);

    private UIWindow() {
        super("Paint App 3000 Pro Pay2Win");
        this.initializeWindow();
        ManagerCanvasDimensions canvas = new ManagerCanvasDimensions();
        this.sliderHeight.addChangeListener(canvas);
        this.sliderWidth.addChangeListener(canvas);
        this.setVisible(true);
    }

    public static UIWindow getInstance(){
        if (instance == null) {
            instance = new UIWindow();
        }

        return instance;
    }

    private void setLayoutAndDimensions() {
        this.setMinimumSize(new Dimension(300, 300));
        this.setSize(1000, 800);
    }

    /**
     * Ajoute l'espace de dessin dans un JPanel
     * qui est à son tour contenu dans un JScrollPane
     * Nous avons procéder de cette façon pour empêcher la redimension
     * automatique de l'espace de dessin
     */
    private void addAreasAndContent() {
        JPanel drawContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        drawContainer.setBackground(Color.LIGHT_GRAY);

        this.drawingBoard = new DrawingBoard();
        this.btnCtrl = new Controls();

        drawContainer.add(this.drawingBoard);

        JScrollPane scrollPane = new JScrollPane(drawContainer);
        scrollPane.setOpaque(true);

        scrollPane.setPreferredSize(new Dimension(300, 300));
        scrollPane.setBackground(Color.LIGHT_GRAY);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(this.btnCtrl, BorderLayout.NORTH);
    }

    /**
     * Crée et rempli un JMenuBar avec ses éléments
     */
    private void createAndFillMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        createFileMenuWithListeners(fileMenu);

        JMenu sizeMenu = new JMenu("Dimensions");
        createDimensionMenu(sizeMenu);

        menuBar.add(fileMenu);
        menuBar.add(sizeMenu);

        this.setJMenuBar(menuBar);
    }

    /**
     * Méthode pour créer un menu de Fichiers
     * @param p_Menu : Le JMenu a remplir
     */
    private void createFileMenuWithListeners(JMenu p_Menu){
        JMenuItem newUIWindow = new JMenuItem("New");
        JMenuItem openXML = new JMenuItem("Open");
        JMenuItem saveXML = new JMenuItem("Save");
        JMenuItem exportSVG = new JMenuItem("Export");
        JMenuItem quitProgram = new JMenuItem("Quit");

        newUIWindow.addActionListener(new ManagerNewUI());
        openXML.addActionListener(new ManagerOpenXML());
        saveXML.addActionListener(new ManagerSaveXML());
        quitProgram.addActionListener(new ManagerQuit());
        exportSVG.addActionListener(new ManagerExportSVG());

        p_Menu.add(newUIWindow);
        p_Menu.add(openXML);
        p_Menu.add(saveXML);
        p_Menu.add(exportSVG);
        p_Menu.add(quitProgram);
    }

    /**
     * Methode pour créer un menu contenant un panneau
     * de controle pour les dimensions de l'espace dessin
     * @param p_Menu : Le JMenu a remplir
     */
    private void createDimensionMenu(JMenu p_Menu){
        Dimension dim = this.drawingBoard.getBoardDimension();
        JPanel mainPan = new JPanel(new BorderLayout());
        JPanel northPan = new JPanel(new GridLayout(1,2));
        JPanel southPan = new JPanel(new GridLayout(1,2));

        this.sliderWidth = new JSlider(300, 3000, dim.width);
        this.sliderWidth.setMajorTickSpacing(500);
        this.sliderWidth.setMinorTickSpacing(125);
        this.sliderWidth.setPaintTicks(true);
        this.sliderWidth.setPaintLabels(true);

        this.sliderHeight = new JSlider(300, 2000, dim.height);
        this.sliderHeight.setMajorTickSpacing(400);
        this.sliderHeight.setMinorTickSpacing(100);
        this.sliderHeight.setPaintTicks(true);
        this.sliderHeight.setPaintLabels(true);


        northPan.add(this.canvasWidth);
        northPan.add(this.canvasHeight);
        southPan.add(this.sliderWidth);
        southPan.add(this.sliderHeight);

        mainPan.add(northPan, BorderLayout.NORTH);
        mainPan.add(southPan, BorderLayout.SOUTH);

        p_Menu.add(mainPan);
    }

    /**
     * Template method pour definir les étapes
     * obligatoires à la construction de la fenêtre
     * et ses composants
     */
    private final void initializeWindow() {
        this.setLayoutAndDimensions();
        this.addAreasAndContent();
        this.createAndFillMenuBar();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private class ManagerOpenXML implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

            OpenXML openXML = new OpenXML();
            openXML.openXMLfile();
            drawingBoard.setAbstractShapes(openXML.getAbstractShapes());
            drawingBoard.setSwingShapes(openXML.getShapes());
            drawingBoard.repaint();
		}
	}

	private class ManagerCanvasDimensions implements ChangeListener {
        private int widthVal = drawingBoard.getBoardDimension().width;
        private int heightVal = drawingBoard.getBoardDimension().height;

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == sliderWidth){
                widthVal = sliderWidth.getValue();
            }

            if(e.getSource() == sliderHeight){
                heightVal = sliderHeight.getValue();
            }

            drawingBoard.setBoardDimensions(widthVal, heightVal);
            canvasWidth.setText("Width : " + widthVal + " px");
            canvasHeight.setText("Height : " + heightVal + " px");
        }
    }

    private class ManagerNewUI implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!drawingBoard.getShapes().isEmpty()){
                ConfirmNewDialog confirmation = new ConfirmNewDialog(UIWindow.getInstance());
                confirmation.setVisible(true);

                if(confirmation.getAction() == "accept"){
                    drawingBoard.setAbstractShapes(new ArrayList<>());
                    drawingBoard.setSwingShapes(new ArrayList<>());
                    drawingBoard.repaint();
                }
            }
        }

    }

    private class ManagerExportSVG implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DOMImplementation domImp = GenericDOMImplementation.getDOMImplementation();
            String svgRef = "http://www.w3.org/2000/svg";
            Document doc = domImp.createDocument(svgRef, "svg", null);
            SVGGraphics2D svgGen = new SVGGraphics2D(doc);

            try {
                FileWriter output = new FileWriter(new File("svgShapes.svg"));
                drawingBoard.paint(svgGen);
                svgGen.stream(output, true);
            } catch (UnsupportedEncodingException ex) {
                System.err.println("Encoding error : " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println("Writing error : " + ex.getMessage());
            }
        }
    }

    private class ManagerSaveXML implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            SaveXML saveXML = new SaveXML(drawingBoard.getShapes());

                saveXML.writeShape();

        }
    }

    private class ManagerQuit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
