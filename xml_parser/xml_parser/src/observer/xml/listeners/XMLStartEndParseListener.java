package observer.xml.listeners;

import observer.xml.interfaces.XMLEventListenerInterface;

public class XMLStartEndParseListener implements XMLEventListenerInterface {
    @Override
    public void update(String eventType, String parseFileName) {
        System.out.println("Someone has performed " + eventType + " from file: " + parseFileName);
    }
}
