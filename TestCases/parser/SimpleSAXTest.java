package parser;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSAXTest {

    @Test
    void start() {
        SimpleSAX tester = new SimpleSAX();
        assertFalse(tester.start("author", "xml_parser\\resources\\file.xml").isEmpty());
    }
}