package ca.csf.dfc.shapes;



public class Ellipse extends AbstractShape {

    public Ellipse(int x1, int y1, int x2, int y2, String fill, String stroke, int weight) {
        super(x1, y1, x2, y2, fill, stroke, weight);
    }

	@Override
	public String getShapeType() {
		return "ellipse";
	}



}
