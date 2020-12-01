package parser.interfaces;

import book_shop.Book;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface XMLServiceProtocol {
    ArrayList<String> simpleSaxStart(String file_name, String tag_name);
    ArrayList<Book> simpleDomParse(String file_name) throws ParserConfigurationException, SAXException, IOException;
}