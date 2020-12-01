package observer.xml;
import observer.xml.enums.XMLEventType;
import observer.xml.interfaces.XMLEventListenerInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class XMLEventManager {
    Map<XMLEventType, List<XMLEventListenerInterface>> listeners = new HashMap<>();

    public XMLEventManager(XMLEventType... operations) {
        for (XMLEventType operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(XMLEventType eventType, XMLEventListenerInterface listener) {
        List<XMLEventListenerInterface> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(XMLEventType eventType, XMLEventListenerInterface listener) {
        List<XMLEventListenerInterface> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(XMLEventType eventType, String parseFileName) {
        List<XMLEventListenerInterface> users = listeners.get(eventType);
        for (XMLEventListenerInterface listener : users) {
            listener.update(eventType.getEventString(), parseFileName);
        }
    }
}