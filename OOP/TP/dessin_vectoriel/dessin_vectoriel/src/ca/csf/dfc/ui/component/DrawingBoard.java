package ca.csf.dfc.ui.component;

import ca.csf.dfc.factory.DrawShape2D;
import ca.csf.dfc.factory.IDrawShape;
import ca.csf.dfc.shapes.AbstractShape;
import ca.csf.dfc.shapes.Ellipse;
import ca.csf.dfc.shapes.Line;
import ca.csf.dfc.shapes.Rectangle;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;


/**
 * @author J. Mainguy
 */
public class DrawingBoard extends JPanel {

	private final int BASE_WIDTH = 800;
	private final int BASE_HEIGHT = 600;
	private ArrayList<Shape> m_jShapeList;

	private ShapeOptionsDialog m_shapeOptions = new ShapeOptionsDialog();
	private Dimension m_boardDimension;
	private IDrawShape drawShape;
	private ArrayList<AbstractShape> m_shapes;
	private Point m_startPoint;
	private Point m_endPoint;
	private int m_selectedShapeIndex = -1;

	public DrawingBoard() {
		this.setBorder(new EtchedBorder());
		this.setDefaultBoardDimensions();
		this.m_shapes = new ArrayList<>();
		this.m_jShapeList = new ArrayList<>();

		this.addMouseListener(new ListenForClickAndRelease());
		this.addMouseMotionListener(new ListenForMouseDrag());
		this.addMouseListener(new ContextMenuListener());
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphic = (Graphics2D)g;
		this.drawShape = new DrawShape2D(graphic);

		// Pour un rendu de dessin en temps reel pluis fluide
		graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);

		// Pour rendre la forme opaque
		graphic.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

		for (AbstractShape s : m_shapes){
			this.drawShape.draw(s);
		}

		// guide pour tracer les formes
		if (m_startPoint != null && m_endPoint != null && !Controls.isSelection()){
			graphic.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.40f));

			graphic.setPaint(Color.LIGHT_GRAY);
			AbstractShape s = this.makeAbstractShape(Controls.getCurrentShape(), m_startPoint.x, m_startPoint.y, m_endPoint.x, m_endPoint.y);

			this.drawShape.draw(s);
		}
	}

	/**
	 * 
	 * @param p_shapeType : Type de Forme
	 * @param p_startX : X depart
	 * @param p_startY : Y depart
	 * @param p_endX : X Final
	 * @param p_endY : Y Final
	 * @return Une forme selon notre definition
	 */
	private AbstractShape makeAbstractShape(String p_shapeType, int p_startX, int p_startY, int p_endX, int p_endY){
		AbstractShape abs = null;

		if(p_shapeType == "ellipse"){
			abs = new Ellipse(p_startX, p_startY, p_endX, p_endY,
					Controls.getFillColorHex(), Controls.getOutlineColorHex(), Controls.getStrokeValue());
		}
		else if (p_shapeType == "line") {
			abs = new Line(p_startX, p_startY, p_endX, p_endY,
					Controls.getFillColorHex(), Controls.getOutlineColorHex(), Controls.getStrokeValue());
		}
		else if (p_shapeType == "rectangle") {
			abs = new Rectangle(p_startX, p_startY, p_endX, p_endY,
					Controls.getFillColorHex(), Controls.getOutlineColorHex(), Controls.getStrokeValue());
		}

		return abs;
	}

	/**
	 * 
	 * @param p_shapeType : Type de Forme
	 * @param p_startX : X depart
	 * @param p_startY : Y depart
	 * @param p_endX : X Final
	 * @param p_endY : Y Final
	 * @return Une forme sous l'interface Shape
	 */
	private Shape makeSwingShape(String p_shapeType, int p_startX, int p_startY, int p_endX, int p_endY){
		Shape s = null;
		if(p_shapeType == "ellipse"){
			s = new Ellipse2D.Float(p_startX, p_startY, p_endX, p_endY);
		}
		else if (p_shapeType == "line") {
			s = new Line2D.Float(p_startX, p_startY, p_endX, p_endY);
		}
		else if (p_shapeType == "rectangle") {
			s = new Rectangle2D.Float(p_startX, p_startY, p_endX, p_endY);
		}

		return s;
	}

	// Méthodes surchargée pour appeler en cascade un nouveau
	// set de dimensions pour l'espace de dessin
	public void setBoardDimensions(int p_Width, int p_Height){
		this.setBoardDimensions(new Dimension(p_Width, p_Height));
	}

	public void setBoardDimensions(Dimension p_Dimension){
		this.setPreferredSize(p_Dimension);
		this.setSize(p_Dimension.width, p_Dimension.height);
		this.m_boardDimension = p_Dimension;
	}

	public void setDefaultBoardDimensions(){
		this.setBoardDimensions(BASE_WIDTH, BASE_HEIGHT);
	}

	public Dimension getBoardDimension(){
		return this.m_boardDimension;
	}


	public ArrayList<AbstractShape> getShapes() {
		return this.m_shapes;
	}

	public void setAbstractShapes(ArrayList<AbstractShape> p_Shapes)
	{
		this.m_shapes = p_Shapes;
	}

	public void setSwingShapes(ArrayList<Shape> p_Shapes){
		this.m_jShapeList = p_Shapes;
	}

	
	/**
	 * Listener pour clic enfoncé et relaché
	 */
	private class ListenForClickAndRelease extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			String shapeType = Controls.getCurrentShape();

			if (shapeType != null) {
				m_startPoint = new Point(e.getX(), e.getY());
				m_endPoint = m_startPoint;
				repaint();
			}

			if(Controls.isSelection()){
				boolean foundShape = false;

				if(!m_jShapeList.isEmpty()){
					for(int i = m_jShapeList.size() - 1; i >= 0 && !foundShape; i--){
						if(m_jShapeList.get(i).contains(m_startPoint)){
							m_selectedShapeIndex = i;
							foundShape = true;
						}
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);

			if(!Controls.isSelection()){
				AbstractShape s = makeAbstractShape(Controls.getCurrentShape(), m_startPoint.x, m_startPoint.y, e.getX(), e.getY());
				Shape jShape = makeSwingShape(Controls.getCurrentShape(), m_startPoint.x, m_startPoint.y, e.getX(), e.getY());
				m_endPoint = new Point(e.getX(), e.getY());

				m_shapes.add(s);
				m_jShapeList.add(jShape);

				m_startPoint = null;
				m_endPoint = null;
			}
			else{
				m_selectedShapeIndex = -1;
			}

			repaint();
		}
	}

	/**
	 * Listener pour la forme de guide et pour bouger la forme choisie
	 */
	private class ListenForMouseDrag extends MouseMotionAdapter{
		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);

			if(Controls.isSelection() && m_selectedShapeIndex != -1 && !e.isPopupTrigger()){
				AbstractShape abs = m_shapes.get(m_selectedShapeIndex);
				Shape s = m_jShapeList.get(m_selectedShapeIndex);
				Rectangle2D bounds = s.getBounds2D();

				int xDistance = (e.getX() - (int)bounds.getX());
				int yDistance = (e.getY() - (int)bounds.getY());
				final int shapeWidth = (abs.getEndX() - abs.getStartX());
				final int shapeHeight = (abs.getEndY() - abs.getStartY());

				abs.setStartX(xDistance);
				abs.setStartY(yDistance);
				abs.setEndX(xDistance + shapeWidth);
				abs.setEndY(yDistance + shapeHeight);
			}

			m_endPoint = new Point(e.getX(), e.getY());
			repaint();
		}
	}
	
	/**
	 * Pour determiner si on peut ouvrir le menu contextuel ou non
	 */
	private class ContextMenuListener extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent p_e) {
			super.mousePressed(p_e);
			this.showMenu(p_e);
		}
		
		@Override
		public void mouseReleased(MouseEvent p_e) {
			super.mouseReleased(p_e);
			this.showMenu(p_e);
		}
		
		private void showMenu(MouseEvent p_e) {
			if(p_e.isPopupTrigger() && Controls.isSelection()) {
				m_shapeOptions.show(p_e.getComponent(), p_e.getX(), p_e.getY());
			}
		}
	}

}
