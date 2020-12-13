package parser;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDOMTest {
    @Test
    void parse() throws ParserConfigurationException, SAXException, IOException {
        SimpleDOM tester = new SimpleDOM();
        assertFalse(tester.parse("xml_parser\\resources\\file.xml").isEmpty());
    }
}