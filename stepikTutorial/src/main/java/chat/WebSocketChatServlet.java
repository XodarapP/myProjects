package chat;

import org.eclipse.jetty.websocket.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "WebSocketChatServlet", urlPatterns = {"/chat"})
public class WebSocketChatServlet extends WebSocketServlet {
    private final ChatWebSocket webSocket;
    private final static int LOGOUT_TIME = 10 * 60 * 1000;

    public WebSocketChatServlet() {
        this.webSocket = new ChatWebSocket();
    }
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        factory.setCreator((req, resp) -> new ChatWebSocket());
    }
}
