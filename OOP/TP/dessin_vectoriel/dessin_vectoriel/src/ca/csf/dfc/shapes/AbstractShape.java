package ca.csf.dfc.shapes;

import java.awt.Color;

public abstract class AbstractShape {
    private int m_startX, m_endX, m_startY, m_endY;
    private String m_fillColor;
    private String m_strokeColor;
    private int m_strokeWeight;

    public AbstractShape(){
        this.m_startX = 0;
        this.m_endX = 0;
        this.m_startY = 0;
        this.m_endY = 0;
        this.m_fillColor = null;
        this.m_strokeColor = null;
        this.m_strokeWeight = 0;
    }

    public AbstractShape(int p_startX, int p_startY, int p_endX, int p_endY, String p_fill, String p_stroke, int p_weight){
    	setStartX(p_startX);
        setStartY(p_startY);
        setEndX(p_endX);
        setEndY(p_endY);
        setFillColor(p_fill);
        setStrokeColor(p_stroke);
        setStrokeWeight(p_weight);
    }
    
    public abstract String getShapeType();

    public int getStartX(){
        return this.m_startX;
    }

    public int getStartY(){
        return this.m_startY;
    }

    public int getEndX(){
        return this.m_endX;
    }

    public int getEndY(){
        return this.m_endY;
    }

    public void setStartX(int p_startX) {
    	
        this.m_startX = p_startX;
    }

    public void setStartY(int p_startY) {
    	
    	
        this.m_startY = p_startY;
    }

    public void setEndX(int p_endx) {

        this.m_endX = p_endx;
    }

    public void setEndY(int p_endY) {

        this.m_endY = p_endY;
    }

    public int getStrokeWeight(){
        return this.m_strokeWeight;
    }

    public String getFillColor(){
        return this.m_fillColor;
    }
    
    public void setFillColor(String p_fill) {
    		
    	try {
            Color color = Color.decode(p_fill);
    	} catch (NumberFormatException e) {
      	     throw new NumberFormatException("p_fill Color is not a valid hex color"); 
    	}
    	
    	this.m_fillColor = p_fill;
    }
    
    public void setStrokeColor(String p_stroke) {
    	try {
            Color color = Color.decode(p_stroke);
    	} catch (NumberFormatException e) {
      	     throw new NumberFormatException("p_stroke Color is not a valid hex color"); 
    	}
    	
    	this.m_strokeColor = p_stroke;
    }

    public String getStrokeColor(){
        return this.m_strokeColor;
    }
    
    public void setStrokeWeight(int p_weight) {
    	if (p_weight < 1) {
    		p_weight = 1;
		}
    	
    	this.m_strokeWeight = p_weight;
    }


}
