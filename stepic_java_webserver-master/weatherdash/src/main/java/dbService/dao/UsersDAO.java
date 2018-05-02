package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;
import dbService.executor.ResultHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public long getMaxUsersID() throws SQLException {
        return executor.execQuery("select max (id) from users_info", resultSet -> {
            resultSet.next();
            return resultSet.getLong(1);
        });
    }

    public void insertUserInfo (String ipAddress, Date dateTime) throws SQLException {
        executor.execUpdate("insert into users_info (user_ip, release_date) values ('" + ipAddress + "', '" + dateTime + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table users_info (ID int identity (1, 1) primary key, user_ip varchar(50), release_date date)");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}
