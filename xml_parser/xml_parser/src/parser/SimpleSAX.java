package parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import observer.xml.XMLEditor;
import observer.xml.interfaces.XMLEditorEventsInterface;
import observer.xml.enums.XMLEventType;
import observer.xml.listeners.XMLStartEndParseListener;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import parser.interfaces.SimpleSAXInterface;

import java.util.ArrayList;
final class SimpleSAX implements SimpleSAXInterface {
    private ArrayList<String> results = new ArrayList();
    private XMLEditorEventsInterface editor = new XMLEditor();

    DefaultHandler handler;

    public SimpleSAX() {
        editor.subscribeTo(XMLEventType.START_XML_PARSE, new XMLStartEndParseListener());
        editor.subscribeTo(XMLEventType.END_XML_PARSE, new XMLStartEndParseListener());
    }

    @Override
    public ArrayList<String> start(String tag, String file_name) {
        handler = new DefaultHandler() {
            boolean tagOn = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                tagOn = qName.equalsIgnoreCase(tag);
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                if (tagOn) {
                    results.add(new String(ch, start, length));
                    tagOn = false;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException
            {
                super.endElement(uri, localName, qName);
            }

            @Override
            public void startDocument() throws SAXException
            {
                try {
                    editor.startXMLParse(file_name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void endDocument() throws SAXException
            {
                try {
                    editor.endXMLParse(file_name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            SAXParserFactory factory;
            factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(file_name, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
