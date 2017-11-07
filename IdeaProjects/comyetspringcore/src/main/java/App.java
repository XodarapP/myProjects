import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;
    private Map<EventType, EventLogger> eventLoggers;
    private EventLogger defaultEventLogger;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> eventLoggers) {
        this.client = client;
        this.defaultEventLogger = eventLogger;
        this.eventLoggers = eventLoggers;

    }

    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        App app = (App) context.getBean("app");

        Event event = (Event) context.getBean("event 1");
        app.logEvent(null, event,"Some NULL message for user 1");

        event = (Event) context.getBean("event 2");
        app.logEvent(EventType.INFO, event,"Some INFO message for user 2");

        event = (Event) context.getBean("event 3");
        app.logEvent(EventType.ERROR, event,"Some ERROR message for user 3");

        DBLogger dbLogger = (DBLogger) context.getBean("dblogger");
        dbLogger.logEvent(event);

        context.close();

    }

    public void logEvent (EventType eventType, Event event, String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = eventLoggers.get(eventType);
        if (logger == null){
            logger = defaultEventLogger;
            logger.logEvent(event);
        }
        else {
            logger.logEvent(event);
        }
    }
}
