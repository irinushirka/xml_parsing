package parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import observer.XMLPublisher;
import observer.XMLStartEndParseListener;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

interface SimpleSAXInterface {
    ArrayList<String> start(String tag, String file_name);
}

final class SimpleSAX implements SimpleSAXInterface {
    private ArrayList<String> results = new ArrayList();
    private XMLPublisher XMLPublisher = new XMLPublisher();

    DefaultHandler handler;

    public SimpleSAX() {
        XMLPublisher.events.subscribe("startXMLParse", new XMLStartEndParseListener());
        XMLPublisher.events.subscribe("endXMLParse", new XMLStartEndParseListener());
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
                    XMLPublisher.startXMLParse(file_name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void endDocument() throws SAXException
            {
                try {
                    XMLPublisher.endXMLParse();
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
