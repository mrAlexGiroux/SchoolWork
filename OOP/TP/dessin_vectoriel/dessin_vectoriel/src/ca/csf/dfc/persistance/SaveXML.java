/*
 * Copyright (c) 2019. AlexandreGiroux
 */

package ca.csf.dfc.persistance;

import ca.csf.dfc.shapes.AbstractShape;
import ca.csf.dfc.ui.UIWindow;

import javax.swing.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static ca.csf.dfc.persistance.Persistance.*;
import static ca.csf.dfc.persistance.Persistance.ELM_STROKE_WEIGHT;

public class SaveXML {

	private ArrayList<AbstractShape> shapes;

	public SaveXML(ArrayList<AbstractShape> p_shapes)
	{
		this.shapes = p_shapes;
	}

	public void writeShape() {

		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new XMLFileFilter());

		XMLStreamWriter doc = null;

		int result = chooser.showSaveDialog(UIWindow.getInstance());

		if (result == JFileChooser.APPROVE_OPTION) {

			try {
				FileWriter output = new FileWriter(chooser.getSelectedFile());

				doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
				// <?xml version="1.0" ?>
				doc.writeStartDocument();
				// <shape>

				doc.writeStartElement(ELM_SHAPE);

				for (AbstractShape shape: this.shapes) {
					doc.writeStartElement(shape.getShapeType());
					doc.writeAttribute(ELM_START_POINT_X, Integer.toString(shape.getStartX()));
					doc.writeAttribute(ELM_START_POINT_Y, Integer.toString(shape.getStartY()));
					doc.writeAttribute(ELM_END_POINT_X, Integer.toString(shape.getEndX()));
					doc.writeAttribute(ELM_END_POINT_Y, Integer.toString(shape.getEndY()));

					doc.writeAttribute(ELM_COLOR_FILL, shape.getFillColor());
					doc.writeAttribute(ELM_COLOR_STROKE, shape.getStrokeColor());

					doc.writeAttribute(ELM_STROKE_WEIGHT, Integer.toString(shape.getStrokeWeight()));
					doc.writeEndElement();
				}

				// </shape>
				doc.writeEndElement();


				doc.writeEndDocument();

			} catch (IOException ex) {
				System.err.println("Writing error" + ex);
			} catch (XMLStreamException ex) {
				System.err.println("Error in XML" + ex);
			} finally {
				if (doc != null)
					try {
						doc.flush();
						doc.close();
					} catch (XMLStreamException ex) {
						System.err.println("Error while closing" + ex);
					} finally {
						doc = null;
					}
			}
		}
	}

}
