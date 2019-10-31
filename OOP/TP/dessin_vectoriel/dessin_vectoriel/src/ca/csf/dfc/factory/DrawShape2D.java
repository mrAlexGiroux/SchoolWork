package ca.csf.dfc.factory;

import ca.csf.dfc.shapes.AbstractShape;
import ca.csf.dfc.shapes.Ellipse;
import ca.csf.dfc.shapes.Line;
import ca.csf.dfc.shapes.Rectangle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author G.Boucher
 *
 */
public class DrawShape2D implements IDrawShape{

    private Graphics2D m_g2d;
    private Shape m_shape;

    public DrawShape2D(Graphics2D m_g2d) {
        this.m_g2d = m_g2d;
        this.m_shape = null;
    }

    @Override
    public void draw(AbstractShape p_abs) {

        if(p_abs instanceof Ellipse){
            this.m_shape = drawEllipse(p_abs.getStartX(), p_abs.getStartY(), p_abs.getEndX(), p_abs.getEndY());
        }
        else if(p_abs instanceof Line){
            this.m_shape = drawLine(p_abs.getStartX(), p_abs.getStartY(), p_abs.getEndX(), p_abs.getEndY());
        }
        else if(p_abs instanceof Rectangle){
            this.m_shape = drawRectangle(p_abs.getStartX(), p_abs.getStartY(), p_abs.getEndX(), p_abs.getEndY());
        }

        this.m_g2d.setPaint(Color.decode(p_abs.getStrokeColor()));
        this.m_g2d.setStroke(new BasicStroke(p_abs.getStrokeWeight()));
        this.m_g2d.draw(this.m_shape);
        this.m_g2d.setPaint((Color.decode(p_abs.getFillColor())));
        this.m_g2d.fill(this.m_shape);

    }


    /**
     * @param p_x1 : Abscisse initiale
     * @param p_y1 : Ordonnee initiale
     * @param p_x2 : Abscisse finale
     * @param p_y2 : Ordonnee finale
     * @return : Un Ellipse2D construit a partir d'une AbstractShape
     */
    private Ellipse2D.Float drawEllipse(int p_x1, int p_y1, int p_x2, int p_y2){
        int x = Math.min(p_x1, p_x2);
        int y = Math.min(p_y1, p_y2);
        int width = Math.abs(p_x1 - p_x2);
        int height = Math.abs(p_y1 - p_y2);

        return new Ellipse2D.Float(x, y, width, height);
    }

    /**
     * @param p_x1 : Abscisse initiale
     * @param p_y1 : Ordonnee initiale
     * @param p_x2 : Abscisse finale
     * @param p_y2 : Ordonnee finale
     * @return : Un Rectangle2D construit a partir d'une AbstractShape
     */
    private Rectangle2D.Float drawRectangle(int p_x1, int p_y1, int p_x2, int p_y2){
        int x = Math.min(p_x1, p_x2);
        int y = Math.min(p_y1, p_y2);
        int width = Math.abs(p_x1 - p_x2);
        int height = Math.abs(p_y1 - p_y2);

        return new Rectangle2D.Float(x, y, width, height);
    }

    /**
     * @param p_x1 : Abscisse initiale
     * @param p_y1 : Ordonnee initiale
     * @param p_x2 : Abscisse finale
     * @param p_y2 : Ordonnee finale
     * @return : Une Line2D construite a partir d'une AbstractShape
     */
    private Line2D.Float drawLine(int p_x1, int p_y1, int p_x2, int p_y2){

        return new Line2D.Float(p_x1,p_y1,p_x2,p_y2);
    }
}
