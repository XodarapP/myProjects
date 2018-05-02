package dbService;

import dbService.dao.UsersDAO;

import java.sql.*;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getMSsqlConnection();
    }

    public void addUserInfo (String ipAddress, Date dateTime) throws DBException {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            //dao.createTable();
            dao.insertUserInfo(ipAddress, dateTime);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public long getMaxUsersId() throws DBException {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            connection.commit();
            return dao.getMaxUsersID();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public void cleanUp() throws DBException {
        UsersDAO dao = new UsersDAO(connection);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void printConnectInfo() {
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMSsqlConnection() {
        try {
            String username = "reader";
            String password = "123";
            DriverManager.registerDriver((Driver) Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:jtds:sqlserver://").        //db type
                    append("HOMEPC:").           //host name
                    append("1433/").                //port
                    append("StepikDB");          //db name

            //System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString(), username, password);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
