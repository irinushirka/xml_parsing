package parser;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NullPointerException, ParserConfigurationException, SAXException, IOException {
        Scanner scanner = new Scanner(System.in);
        String file_name = "file.xml";
        String tag_name;
        //XMLCreator.create(); // create XML if you need it
        if (Check.instance.check(file_name, "schema.xsd")) { // checking if this XML is valid according to XSD
            System.out.println("XML file is valid!");
            System.out.println("------- SAX -------");
            System.out.println("Input tag name: ");
            tag_name = scanner.nextLine();
            // As SAX-parser is used for information search in XML,
            // I decided to make class SimpleSAX return an array with resulted strings
            XMLService xmlService = new XMLService(new SimpleDOM(), new SimpleSAX());
            XMLTaskFacade xmlTaskFacade = new XMLTaskFacade(xmlService);
            xmlTaskFacade.completeXMLTask(file_name, tag_name);
        }
        else {
            System.out.println("XML file is invalid!");
        }
    }
}
