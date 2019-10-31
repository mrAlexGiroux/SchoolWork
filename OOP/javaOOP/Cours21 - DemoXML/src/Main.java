
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
 * Programme pour démontrer l'utilisation du XML en java.
 * @author nrichard
 */
public class Main {
	
	private final static String ELM_EXAMEN         = "examen"; 
	private final static String ELM_QUESTION       = "question";
	private final static String ELM_QUESTION_MULTI = "question_multiple";
	
	private final static String ATTR_TEXTE     = "texte";
	private final static String ATTR_POINTS    = "points";

	
	/**
	 * Écrit une question dans le fichier XML
     * @param p_doc Pour écrire dans le XML
     * @param p_texte Le texte de la question
     * @param p_points Les points associés à la question
     * @throws XMLStreamException
     */
    public static void écrireQuestion(XMLStreamWriter p_doc,
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
	 * Démonstration d'écriture d'un fichier XML
	 */
	private static void démoÉcriture() {
		// Déclaré ici pour le fermer dans le finally
	    XMLStreamWriter doc = null;
		
		try {
			FileWriter output=new FileWriter(new File("data.xml"));
		
			doc = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
			
			// <?xml version="1.0" ?>
			doc.writeStartDocument();
			
			// <examen>
			doc.writeStartElement(ELM_EXAMEN);
			
			écrireQuestion(doc, "Pourquoi le ciel est-il bleu ?", 5);
			écrireQuestion(doc, "Qu'est-ce qu'une référence ?",   5);
			
			// <question_multiple>
			doc.writeStartElement(ELM_QUESTION_MULTI);
			
			écrireQuestion(doc, "Qu'est-ce qu'un \"int\" ?",    5);
			écrireQuestion(doc, "Qu'est-ce qu'un \"double\" ?", 5);
			
			// </question_multiple>
            doc.writeEndElement();
            
			// </examen>
			doc.writeEndElement();
			
			doc.writeEndDocument();
			
		} catch(IOException exp) {
			System.err.println("Erreur d'écriture : " + exp);
			
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
	 * Lit une question et l'affiche à l'écran.
     * @param p_doc Document XML.
     * @param p_ÉlmQuestion Élément "Question".
     * @throws XMLStreamException
     */
	/*
    public static void lireQuestion(XMLEventReader p_doc,
                                    StartElement   p_ÉlmQuestion) throws XMLStreamException {
        // <question ...
        String texte = p_ÉlmQuestion.getAttributeByName(new QName(ATTR_TEXTE)).getValue();
        String points = p_ÉlmQuestion.getAttributeByName(new QName(ATTR_POINTS)).getValue();
        
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
     * Démonstration de lecture d'un fichier XML
     */
    private static void démoLecture() {
        // Déclaré ici pour le fermer dans le finally
        XMLStreamReader doc = null;
        
        try {
            FileReader input=new FileReader(new File("data.xml"));
        
            doc = XMLInputFactory.newInstance().createXMLStreamReader(input);

            // Pour passer par-dessus le Start Document
            doc.next();
            
            if (!doc.getLocalName().equals(ELM_EXAMEN)) {
                throw new XMLStreamException(
                    "Pas le bon élément racine : " + doc.getLocalName());
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
                        
            XMLEvent événement = doc.nextEvent();
            
            // Le premier événement est un StartDocumentEvent
            
            // Pour passer par-dessus le "start document"
            événement = doc.nextEvent();
            
            // <examen>
            StartElement nouvelÉlément = événement.asStartElement();
            if (!nouvelÉlément.getName().getLocalPart().equals(ELM_EXAMEN)){
                throw new XMLStreamException("Pas le bon élément racine : " + nouvelÉlément.getName());
            }
                        
            événement = doc.nextEvent();
            while (événement.isStartElement()) {
                nouvelÉlément = événement.asStartElement();
                
                if (nouvelÉlément.getName().getLocalPart().equals(ELM_QUESTION)) {
                    lireQuestion(doc, nouvelÉlément);
                    
                } else if (nouvelÉlément.getName().getLocalPart().equals(ELM_QUESTION_MULTI)) {
                    
                    // <question_multiple>
                    événement = doc.nextEvent();
                    nouvelÉlément = événement.asStartElement();
                    
                    lireQuestion(doc, nouvelÉlément);
                    
                    // </question_multiple>
                    doc.nextEvent();
                } 
                événement = doc.nextEvent();
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
		démoÉcriture();

		démoLecture();
	}
	

}
