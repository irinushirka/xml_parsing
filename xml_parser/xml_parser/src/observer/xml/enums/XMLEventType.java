package observer.xml.enums;

public enum XMLEventType {
    START_XML_PARSE("startXMLParse"),
    END_XML_PARSE("endXMLParse");
    private String eventString;
    XMLEventType(String eventString) {
        this.eventString = eventString;
    }
    public String getEventString() {
        return eventString;
    }
}
