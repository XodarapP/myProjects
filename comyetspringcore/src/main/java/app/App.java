package app;

import client.Client;
import event.Event;
import event.EventType;
import loggers.EventLogger;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger defaultEventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultEventLogger = defaultEventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultEventLogger;
            logger.logEvent(event);
        }
        else {
            logger.logEvent(event);
        }
    }
}
