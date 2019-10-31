/*
 * Copyright (c) 2019. AlexandreGiroux
 */

package ca.csf.dfc.persistance;

import ca.csf.dfc.shapes.AbstractShape;
import ca.csf.dfc.shapes.Ellipse;
import ca.csf.dfc.shapes.Line;
import ca.csf.dfc.shapes.Rectangle;
import ca.csf.dfc.ui.UIWindow;

import javax.swing.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static ca.csf.dfc.persistance.Persistance.*;

public class OpenXML {

	private ArrayList<AbstractShape> abstractShapes;
	private ArrayList<Shape> shapes;

	public OpenXML()
	{
		this.abstractShapes = new ArrayList<>();
		this.shapes = new ArrayList<>();
	}

	public void openXMLfile()
	{
		Shape swingShape;


		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileFilter(new XMLFileFilter());

		int result = chooser.showOpenDialog(UIWindow.getInstance());

		if (result == JFileChooser.APPROVE_OPTION) {

			XMLStreamReader doc = null;

			try {
				FileReader input = new FileReader(chooser.getSelectedFile());

				doc = XMLInputFactory.newInstance().createXMLStreamReader(input);

				// jump over Start Document
				doc.next();

				if (!doc.getLocalName().equals(ELM_SHAPE)) {
					throw new XMLStreamException("Wrong root element" + doc.getLocalName());
				}
				doc.next();


				while (doc.isStartElement()) {

					if (doc.getLocalName().equals(ELM_RECTANGLE)) {

						AbstractShape rect = new Rectangle(
								Integer.parseInt(doc.getAttributeValue("",ELM_START_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("",ELM_START_POINT_Y)),
								Integer.parseInt(doc.getAttributeValue("",ELM_END_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("",ELM_END_POINT_Y)),
								doc.getAttributeValue("", ELM_COLOR_FILL),
								doc.getAttributeValue("",ELM_COLOR_STROKE),
								Integer.parseInt(doc.getAttributeValue("",ELM_STROKE_WEIGHT)));
						swingShape = new Rectangle2D.Float(rect.getStartX(), rect.getStartY(), rect.getEndX(), rect.getEndY());
						this.shapes.add(swingShape);
						this.abstractShapes.add(rect);
						doc.next();
					}
					if (doc.getLocalName().equals(ELM_LINE)) {

						AbstractShape line = new Line(
								Integer.parseInt(doc.getAttributeValue("",ELM_START_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("",ELM_START_POINT_Y)),
								Integer.parseInt(doc.getAttributeValue("",ELM_END_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("",ELM_END_POINT_Y)),
								doc.getAttributeValue("", ELM_COLOR_FILL),
								doc.getAttributeValue("",ELM_COLOR_STROKE),
								Integer.parseInt(doc.getAttributeValue("",ELM_STROKE_WEIGHT)));
						swingShape = new Line2D.Float(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
						this.shapes.add(swingShape);
						this.abstractShapes.add(line);
						doc.next();
					}
					if (doc.getLocalName().equals(ELM_ELLIPSE)) {

						AbstractShape ellipse = new Ellipse(
								Integer.parseInt(doc.getAttributeValue("", ELM_START_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("", ELM_START_POINT_Y)),
								Integer.parseInt(doc.getAttributeValue("", ELM_END_POINT_X)),
								Integer.parseInt(doc.getAttributeValue("", ELM_END_POINT_Y)),
								doc.getAttributeValue("", ELM_COLOR_FILL),
								doc.getAttributeValue("", ELM_COLOR_STROKE),
								Integer.parseInt(doc.getAttributeValue("", ELM_STROKE_WEIGHT)));
						swingShape = new Ellipse2D.Float(ellipse.getStartX(), ellipse.getStartY(), ellipse.getEndX(), ellipse.getEndY());
						this.shapes.add(swingShape);
						this.abstractShapes.add(ellipse);
						doc.next();
					}
					doc.next();
				}
			} catch (IOException exp) {
				System.err.println("Error of file reading" + exp);
			} catch (XMLStreamException exp) {
				System.err.println("XML File Corrupted" + exp);
			}
			finally {
				try {
					doc.close();
				} catch (XMLStreamException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public ArrayList<AbstractShape> getAbstractShapes()
	{
		return this.abstractShapes;
	}

	public ArrayList<Shape> getShapes()
	{
		return this.shapes;
	}

}
