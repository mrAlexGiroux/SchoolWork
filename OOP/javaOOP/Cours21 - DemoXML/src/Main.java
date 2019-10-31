
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Programme pour d�montrer l'utilisation du XML en java.
 * @author nrichard
 */
public class Main {
	
	private final static String ELM_EXAMEN         = "examen"; 
	private final static String ELM_QUESTION       = "question";
	private final static String ELM_QUESTION_MULTI = "question_multiple";
	
	private final static String ATTR_TEXTE     = "texte";
	private final static String ATTR_POINTS    = "points";

	
	/**
	 * �crit une question dans le fichier XML
     * @param p_doc Pour �crire dans le XML
     * @param p_texte Le texte de la question
     * @param p_points Les points associ�s � la question
     * @throws XMLStreamException
     */
    public static void �crireQuestion(XMLStreamWriter p_doc,
                                      String          p_texte,
                                      int             p_points)
            throws XMLStreamException {
        
        // <question ...
        p_doc.writeStartElement(ELM_QUESTION);
        
        // ... texte="..." ...
        p_doc.writeAttribute(ATTR_TEXTE, p_texte);
        
        // ... points="5" ...
        p_doc.writeAttribute(ATTR_POINTS, Integer.toString(p_points));
        
        // ... />
        p_doc.writeEndElement();
    }
	
	/**
	 * D�monstration d'�criture d'un fichier XML
	 */
	private static void d�mo�criture() {
		// D�clar� ici pour le fermer dans le finally
	    XMLStreamWriter doc = null;
		
		try {
			FileWriter output=new FileWriter(new File("data.xml"));
		
			doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
			
			// <?xml version="1.0" ?>
			doc.writeStartDocument();
			
			// <examen>
			doc.writeStartElement(ELM_EXAMEN);
			
			�crireQuestion(doc, "Pourquoi le ciel est-il bleu ?", 5);
			�crireQuestion(doc, "Qu'est-ce qu'une r�f�rence ?",   5);
			
			// <question_multiple>
			doc.writeStartElement(ELM_QUESTION_MULTI);
			
			�crireQuestion(doc, "Qu'est-ce qu'un \"int\" ?",    5);
			�crireQuestion(doc, "Qu'est-ce qu'un \"double\" ?", 5);
			
			// </question_multiple>
            doc.writeEndElement();
            
			// </examen>
			doc.writeEndElement();
			
			doc.writeEndDocument();
			
		} catch(IOException exp) {
			System.err.println("Erreur d'�criture : " + exp);
			
		} catch(XMLStreamException exp) {
			System.err.println("Erreur dans le XML : " + exp);
			
		} finally {
			if (doc != null) {
				try {
					doc.flush();
					doc.close();
					
				} catch(XMLStreamException exp) {
					System.err.println("Erreur lors de la fermeture" + exp);
					
				} finally {
					doc = null;
				}
			}
		}
	}

	
	/**
	 * Lit une question et l'affiche � l'�cran.
     * @param p_doc Document XML.
     * @param p_�lmQuestion �l�ment "Question".
     * @throws XMLStreamException
     */
	/*
    public static void lireQuestion(XMLEventReader p_doc,
                                    StartElement   p_�lmQuestion) throws XMLStreamException {
        // <question ...
        String texte = p_�lmQuestion.getAttributeByName(new QName(ATTR_TEXTE)).getValue();
        String points = p_�lmQuestion.getAttributeByName(new QName(ATTR_POINTS)).getValue();
        
        System.out.println("Question : " + texte + " (" + points + ")");
        
        // />
        p_doc.nextEvent();
    }
    */
	
	/**
	 * Pour lire une question.
     * @param p_doc Document XML
     * @throws XMLStreamException
     */
    public static void lireQuestion(XMLStreamReader p_doc)
            throws XMLStreamException {
        // <question ...
        String texte  = p_doc.getAttributeValue("", ATTR_TEXTE);
        String points = p_doc.getAttributeValue("", ATTR_TEXTE);

        System.out.println("Question : " + texte + " (" + points + ")");
        
        // Pour finir de lire le StartElement
        p_doc.next();
    }
	
	
	/**
     * D�monstration de lecture d'un fichier XML
     */
    private static void d�moLecture() {
        // D�clar� ici pour le fermer dans le finally
        XMLStreamReader doc = null;
        
        try {
            FileReader input=new FileReader(new File("data.xml"));
        
            doc = XMLInputFactory.newInstance().createXMLStreamReader(input);

            // Pour passer par-dessus le Start Document
            doc.next();
            
            if (!doc.getLocalName().equals(ELM_EXAMEN)) {
                throw new XMLStreamException(
                    "Pas le bon �l�ment racine : " + doc.getLocalName());
            }

            // <examen>
            doc.next();
            
            while(doc.isStartElement()) {
                if (doc.getLocalName().equals(ELM_QUESTION)) {
                    lireQuestion(doc);
                    
                    
                } else if (doc.getLocalName().equals(ELM_QUESTION_MULTI)){
                    // <question_multi>
                    doc.next();
                    
                    while(doc.isStartElement() && doc.getLocalName().equals(ELM_QUESTION)) {
                        lireQuestion(doc);
                    }
                    
                }

                // Pour passer par-dessus le EndElement
                doc.next();
            }
            

            /*
            doc = XMLInputFactory.newInstance().createXMLEventReader(input);
                        
            XMLEvent �v�nement = doc.nextEvent();
            
            // Le premier �v�nement est un StartDocumentEvent
            
            // Pour passer par-dessus le "start document"
            �v�nement = doc.nextEvent();
            
            // <examen>
            StartElement nouvel�l�ment = �v�nement.asStartElement();
            if (!nouvel�l�ment.getName().getLocalPart().equals(ELM_EXAMEN)){
                throw new XMLStreamException("Pas le bon �l�ment racine : " + nouvel�l�ment.getName());
            }
                        
            �v�nement = doc.nextEvent();
            while (�v�nement.isStartElement()) {
                nouvel�l�ment = �v�nement.asStartElement();
                
                if (nouvel�l�ment.getName().getLocalPart().equals(ELM_QUESTION)) {
                    lireQuestion(doc, nouvel�l�ment);
                    
                } else if (nouvel�l�ment.getName().getLocalPart().equals(ELM_QUESTION_MULTI)) {
                    
                    // <question_multiple>
                    �v�nement = doc.nextEvent();
                    nouvel�l�ment = �v�nement.asStartElement();
                    
                    lireQuestion(doc, nouvel�l�ment);
                    
                    // </question_multiple>
                    doc.nextEvent();
                } 
                �v�nement = doc.nextEvent();
            }
            */
        } catch(IOException exp) {
            System.err.println("Erreur de lecture de fichier : " + exp);
            
        } catch(XMLStreamException exp) {
            System.err.println("Fichier XML corrompu : " + exp);
            
        } finally {
            if (doc != null) {
                try {
                    doc.close();
                    
                } catch(XMLStreamException exp) {
                    System.err.println("Erreur lors de la fermeture" + exp);
                    
                } finally {
                    doc = null;
                }
            }
        }
    }

    

    
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		d�mo�criture();

		d�moLecture();
	}
	

}
