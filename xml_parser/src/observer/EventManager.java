package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// "Базовый" издатель, из которого делаются другие издатели
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, String parseFileName) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, parseFileName);
        }
    }
}