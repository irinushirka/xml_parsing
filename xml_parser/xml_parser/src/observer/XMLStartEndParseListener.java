package observer;

import observer.xml.interfaces.EventListener;

// подписчик
public class XMLStartEndParseListener implements EventListener {
    @Override
    public void update(String eventType, String parseFileName) {
        System.out.println("Someone has performed " + eventType + " from file: " + parseFileName);
    }
}
