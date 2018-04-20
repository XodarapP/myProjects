package app;

import event.Event;
import event.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        app.logEvent(EventType.INFO, event, "INFO message for USER 1");
        app.logEvent(EventType.ERROR, event, "ERROR message for USER 2");
        app.logEvent(null, event, "NULL message for USER 3");
        ctx.close();
    }
}
