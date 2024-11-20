package gestionarXML;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException,  ParserConfigurationException {
		String ruta = "books.xml";
		String autor = null, titulo = null, genero = null, descripcion = null;
		Date fecha;
		double precio;
    		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    		DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(Paths.get(ruta).toFile());
			NodeList listaLibros = doc.getElementsByTagName("book");
			for(int i=0; i<listaLibros.getLength(); i++) {
				Node nodo = listaLibros.item(i);
	            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
	            	Element libro = (Element) nodo;
	            	NodeList hijos = libro.getChildNodes();
	            	for (int j = 0; j < hijos.getLength(); j++) {
		            	autor= autor + hijos.item(j).getNodeType() + hijos.item(j).getTextContent();

	            	}
			}

	}

}
}
