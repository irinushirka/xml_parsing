package parser;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

interface XMLServiceProtocol {
    ArrayList<String> simpleSaxStart(String file_name, String tag_name);
    ArrayList<Book> simpleDomParse(String file_name) throws ParserConfigurationException, SAXException, IOException;
}

public class XMLService implements XMLServiceProtocol  {
    SimpleDomInterface simpleDom;
    SimpleSAXInterface simpleSAX;

    public XMLService(SimpleDOM simpleDOM, SimpleSAX simpleSAX) {
        this.simpleDom = simpleDOM;
        this.simpleSAX = simpleSAX;
    }

    @Override
    public ArrayList<String> simpleSaxStart(String file_name, String tag_name) {
        return simpleSAX.start(tag_name, file_name);
    }

    @Override
    public ArrayList<Book> simpleDomParse(String file_name) throws ParserConfigurationException, SAXException, IOException {
        return simpleDom.parse(file_name);
    }
}
