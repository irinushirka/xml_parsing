package observer.xml.interfaces;
import observer.xml.enums.XMLEventType;

public interface XMLEditorEventsInterface {
    void startXMLParse(String parseFileName);
    void endXMLParse(String parseFileName);
    void subscribeTo(XMLEventType event, XMLEventListenerInterface eventListener);
}
