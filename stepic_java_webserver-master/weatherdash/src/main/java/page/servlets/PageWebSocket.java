package page.servlets;

import dbService.DBException;
import dbService.DBService;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class PageWebSocket {
    private Session session;
    private DBService dbService;

    public PageWebSocket() {
    }

    @OnWebSocketConnect
    public void onOpen(Session session) throws DBException {
        this.session = session;
        this.dbService = new DBService();

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        dbService.addUserInfo(session.getRemoteAddress().toString(), sqlDate);
        long id = getMaxUsersID();
        System.out.println(id);
        System.out.println(dbService.getMaxUsersId());
    }

    @OnWebSocketMessage
    public void onMessage(String data) {

    }

    public long getMaxUsersID () throws DBException {
        try {
            dbService.getMaxUsersId();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return dbService.getMaxUsersId();
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) throws DBException {
        //dbService.cleanUp();
    }
}
