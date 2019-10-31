package ca.csf.dfc.persistance.test;

import ca.csf.dfc.persistance.OpenXML;
import ca.csf.dfc.persistance.SaveXML;
import ca.csf.dfc.shapes.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class XMLTestSave {

	@Test
	public void ctr_casNormal_Valeur() {
		// Arranger

		SaveXML saveXML;
		OpenXML openXML = new OpenXML();

		ArrayList<AbstractShape> shapes = new ArrayList<>();
		AbstractShape rect = new Rectangle(50,50,100,100,"#ffffff","#ffffff",5);
		AbstractShape rect2 = new Rectangle(150,150,200,200,"#00ffff","#ffffff",10);
		AbstractShape line = new Line(50,50,100,100,"#ffff00","#ffffff",5);
		AbstractShape line2 = new Line(250,250,300,300,"#ff00ff","#ffffff",510);
		AbstractShape ellipse = new Ellipse(75,75,125,125,"#f0f0f0","#ffffff",5);
		AbstractShape ellipse1 = new Ellipse(100,100,250,250,"#0f0f0f","#ffffff",5);

		// Agir

		shapes.add(rect); shapes.add(rect2); shapes.add(line);
		shapes.add(line2); shapes.add(ellipse); shapes.add(ellipse1);
		saveXML = new SaveXML(shapes);
		saveXML.writeShape();

		ArrayList<AbstractShape> absShapes = openXML.getAbstractShapes();
		// Auditer
		// comparer le output de Open avec le shapes creer plus haut


		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
