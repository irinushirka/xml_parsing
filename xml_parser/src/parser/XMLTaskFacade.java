package parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XMLTaskFacade {
    public XMLService xmlService;

    XMLTaskFacade(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    void completeXMLTask(String file_name, String tag_name) throws ParserConfigurationException, SAXException, IOException {
        ArrayList<String> results;
        results = xmlService.simpleSaxStart(file_name, tag_name);

        System.out.println("----- Results: -----");
        if (!results.isEmpty()) {
            for (String s : results) {
                System.out.println(s);
            }
        }
        else {
            System.out.println("No results.");
        }

        System.out.println("------- DOM -------");

        ArrayList<Book> books = xmlService.simpleDomParse(file_name);
        // Ideally, I would create classes DOMParser and BookParser, where BookParser would inherit from the 1st one
        BookShop bookShop = new BookShop(books);
        bookShop.showBooksData();
        System.out.println("\nTotal books cost: " + bookShop.countTotalCost()); // idk why i did it and don't ask me
    }
}
