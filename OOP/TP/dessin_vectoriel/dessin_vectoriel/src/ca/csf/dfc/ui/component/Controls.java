package ca.csf.dfc.ui.component;

import ca.csf.dfc.ui.UIWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;


/**
 * @author J. Mainguy
 */
public class Controls extends JPanel {

	private static final long serialVersionUID = -8879039787078956019L;

	// Pour determiner la forme a dessiner
	private static String shapeType = "line";

	// La couleur du contour
	private static String outlineColorHex = "#000000";

	// La couleur du remplissage
	private static String  fillColorHex = "#ffffff";

	private static int strokeValue = 5;
	// Épaisseur du trait

	private static boolean isSelectMode;

	public Controls() {
		isSelectMode = false;
		this.initializePanel();
		this.setVisible(true);
	}

	public static boolean isSelection(){
		return isSelectMode;
	}

	public static String getCurrentShape() {
		return shapeType;
	}

	public static String getOutlineColorHex() {
		return outlineColorHex;
	}

	public static String getFillColorHex() {
		return fillColorHex;
	}

	public static int getStrokeValue(){
		return strokeValue;
	}

	public static void setStrokeValue(int p_strokeVal){
		strokeValue = p_strokeVal;
	}
	
	private void setLayoutAndDimensions() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	private void addButtons() {
		JButton btnEllipse, btnRectangle, btnLine, btnOutline, btnFill, btnStroke, btnSelection;

		btnLine = createShapeButtonWithListener("./src/img/diagonal-line.png", "line");
		btnLine.setToolTipText("Line Creation Tool");
		btnRectangle = createShapeButtonWithListener("./src/img/rectangle.png", "rectangle");
		btnRectangle.setToolTipText("Rectangle Creation Tool");
		btnEllipse = createShapeButtonWithListener("./src/img/ellipse.png", "ellipse");
		btnEllipse.setToolTipText("Ellipse Creation Tool");

		btnOutline = createColorButtonWithListener("./src/img/paint-board-and-brush.png", 4, true);
		btnOutline.setToolTipText("Outline Color Chooser");
		btnFill = createColorButtonWithListener("./src/img/paint-bucket.png", 5, false);
		btnFill.setToolTipText("Filling Color Chooser");
		btnStroke = createStrokeButtonWithListener("./src/img/paint-brush.png");
		btnStroke.setToolTipText("Stroke Weight (1-20)");
		btnSelection = createSelectionButtonWithListener("./src/img/move.png");

		this.add(btnEllipse);
		this.add(btnRectangle);
		this.add(btnLine);
		this.add(btnOutline);
		this.add(btnFill);
		this.add(btnStroke);
		this.add(btnSelection);
	}

	private JButton createSelectionButtonWithListener(String p_filepath){
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon(p_filepath));

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isSelectMode = true;
			}
		});

		return btn;
	}

	private JButton createStrokeButtonWithListener(String p_Filepath){
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon(p_Filepath));

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isSelectMode = false;
				StrokeDialog strokeDialog = new StrokeDialog(UIWindow.getInstance());
				strokeDialog.setVisible(true);

				int strokeVal = strokeDialog.getStrokeValue();
				Controls.strokeValue = strokeVal;
			}
		});

		return btn;
	}

	/**
	 *
	 * @param p_filepath : Chemin du fichier image a convertir
	 * @param p_shape : Valeur de l'ENUM ShapeType
	 * @return
	 */
	private JButton createShapeButtonWithListener(String p_filepath, final String p_shape){
		JButton btn = new JButton();
		ImageIcon icon = new ImageIcon(p_filepath);
		btn.setIcon(icon);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shapeType = p_shape;
				isSelectMode = false;
			}
		});

		return btn;
	}

	/**
	 *
	 * @param p_filepath : Chemin du fichier image a convertir
	 * @param p_actionNb :   Valeur de l'ENUM ShapeType
	 * @param p_outline : boolean determinant la couleur a modifier
	 *                	soit remplissage ou contour
	 * @return
	 */
	private JButton createColorButtonWithListener(String p_filepath, final int p_actionNb, final boolean p_outline){
		JButton btn = new JButton();
		ImageIcon icon = new ImageIcon(p_filepath);
		btn.setIcon(icon);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isSelectMode = false;
				if(p_outline){
					Color temporaryColor;
					temporaryColor = JColorChooser.showDialog(null, "Choisissez une couleur de contour", Color.BLACK);
					if(temporaryColor != null){
						outlineColorHex = "#"+Integer.toHexString(temporaryColor.getRGB()).substring(2);
					}
				}
				else{
					Color temporaryColor;
					temporaryColor = JColorChooser.showDialog(null, "Choisissez une couleur de remplissage", Color.BLACK);
					if (temporaryColor != null) {
						fillColorHex = "#"+Integer.toHexString(temporaryColor.getRGB()).substring(2);
					}
				}
			}
		});

		return btn;
	}

	
	private final void initializePanel() {
		this.setLayoutAndDimensions();
		this.addButtons();
	}
}
