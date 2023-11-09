package java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * An example XML reader. It reads the ships.java.xml file, and outputs the text content of
 * each node nested in each ship node. This was made for a game which uses XML files
 * as data for ship properties.
 *
 * @author Devlin Evans
 */
public class xmlReader {
    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/java.xml/ships.java.xml");
            NodeList shipList = doc.getElementsByTagName("ship");
            for (int i = 0; i < shipList.getLength(); i++) {
                Node s = shipList.item(i);
                if (s.getNodeType() == Node.ELEMENT_NODE) {
                    Element ship = (Element) s;
                    NodeList statsList = ship.getChildNodes();
                    for (int j = 0; j < statsList.getLength(); j++) {
                        returnValue(j, statsList);
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param i is the current node item in the node list.
     * @param list is the node list.
     */
    public static void returnValue(int i, NodeList list) {
        Node y = list.item(i);
        if (y.getNodeType() == Node.ELEMENT_NODE) {
            if (y.getNodeName() == "class") {
                Element name = (Element) y;
                System.out.println("Ship class: " + name.getTextContent());
            }
            else if (y.getNodeName() == "health") {
                Element name = (Element) y;
                System.out.println("Health: " + name.getTextContent());
            }
            else if (y.getNodeName() == "speed") {
                Element name = (Element) y;
                System.out.println("Speed: " + name.getTextContent());
            }
            else if (y.getNodeName() == "turretSlots") {
                Element name = (Element) y;
                System.out.println("Turret slots: " + name.getTextContent());
            }
            else if (y.getNodeName() == "cargoSpace") {
                Element name = (Element) y;
                System.out.println("Cargo space: " + name.getTextContent());
            }
            else if (y.getNodeName() == "crewSpace") {
                Element name = (Element) y;
                System.out.println("Crew space: " + name.getTextContent());
                System.out.println();
            }
        }
    }
}
