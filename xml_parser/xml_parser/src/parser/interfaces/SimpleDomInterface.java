package parser.interfaces;

import book_shop.Book;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface SimpleDomInterface {
    ArrayList<Book> parse(String file_name) throws IOException, ParserConfigurationException, SAXException;
}