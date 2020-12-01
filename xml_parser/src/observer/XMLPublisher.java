package observer;

// Издатель, которого отслеживают наблюдатели
public class XMLPublisher {
    private EventManager events;
    private String parseFileName;
    public XMLPublisher() {
        this.events = new EventManager("startXMLParse", "endXMLParse");
    }
    public void startXMLParse(String parseFileName) {
        this.parseFileName = parseFileName;
        events.notify("startXMLParse", parseFileName);
    }
    public void endXMLParse() {
        events.notify("endXMLParse", parseFileName);
    }
}