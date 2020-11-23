package parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

interface SimpleDomInterface {
    ArrayList<Book> parse(String file_name) throws IOException, ParserConfigurationException, SAXException;
}

final class SimpleDOM implements SimpleDomInterface {
    @Override
    public ArrayList<Book> parse(String file_name) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf;
        DocumentBuilder        db;
        Document               doc;
        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        ArrayList<Book> books = new ArrayList<Book>();

        FileInputStream fis = new FileInputStream(file_name);
        doc = db.parse(fis);

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("book");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element)node;
                Book b = new Book();
                NamedNodeMap attrs = node.getAttributes();

                b.setPrice(Integer.parseInt(attrs.getNamedItem("price").getNodeValue()));
                b.setPages(Integer.parseInt(attrs.getNamedItem("pages").getNodeValue()));
                b.setTitle(el.getElementsByTagName("title").item(0).getTextContent());
                b.setAuthor(el.getElementsByTagName("author").item(0).getTextContent());

                books.add(b);
            }
        }
        return books;
    }
}
