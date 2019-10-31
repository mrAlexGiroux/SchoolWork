package ca.csf.dfc.shapes.test;

import ca.csf.dfc.shapes.AbstractShape;
import ca.csf.dfc.shapes.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

	@Test
	public void ctr_casNormal_Valeur() {
		// Arranger
		AbstractShape rect = new Rectangle(66,511,783,581, "#ffffff", "#ffffff",5);
		// Agir
		
		// Auditer
		assertEquals(66, rect.getStartX());
		assertEquals(511, rect.getStartY());
		assertEquals(783, rect.getEndX());
		assertEquals(581,rect.getEndY());
		assertEquals("#ffffff", rect.getFillColor());
		assertEquals("#ffffff", rect.getStrokeColor());
		assertEquals(5, rect.getStrokeWeight());		}

	
	@Test
	public void ctr_casNormal_ValeurDepartNegative() {
		// Arranger
		AbstractShape rect = new Rectangle(-10,-200,783,581, "#ffffff", "#ffffff",5);
		// Agir
		
		// Auditer
		assertEquals(0, rect.getStartX());
		assertEquals(0, rect.getStartY());
		assertEquals(783, rect.getEndX());
		assertEquals(581,rect.getEndY());
		assertEquals("#ffffff", rect.getFillColor());
		assertEquals("#ffffff", rect.getStrokeColor());
		assertEquals(5, rect.getStrokeWeight());		
		}
	
	@Test
	public void ctr_casNormal_ValeurStrokeNegative() {
		// Arranger
		AbstractShape rect = new Rectangle(-10,-200,783,581, "#ffffff", "#ffffff",-10);
		// Agir
		
		// Auditer
		assertEquals(0, rect.getStartX());
		assertEquals(0, rect.getStartY());
		assertEquals(783, rect.getEndX());
		assertEquals(581,rect.getEndY());
		assertEquals("#ffffff", rect.getFillColor());
		assertEquals("#ffffff", rect.getStrokeColor());
		assertEquals(1, rect.getStrokeWeight());		
		}
	
	@Test
	public void ctr_casException_ValeurDepartFinalNegative() {
		// Arranger
		// Agir
		
		// Auditer
		assertThrows(IllegalArgumentException.class , () ->new Rectangle(-10,-200,-450,-580, "#ffffff", "#ffffff",5));
		}
	
	@Test
	public void ctr_casException_ValeurCouleurFillFausse() {
		// Arranger
		// Agir
		
		// Auditer
		assertThrows(NumberFormatException.class , () -> new Rectangle(10,200,783,581, "Allo", "#ffffff",5));
	
		}
	
	@Test
	public void ctr_casException_ValeurCouleurStrokeFausse() {
		// Arranger
		// Agir
		// Auditerz
		assertThrows(NumberFormatException.class , () -> new Rectangle(10,200,783,581, "#ffffff", "Allo",5));
	
		}
	
}