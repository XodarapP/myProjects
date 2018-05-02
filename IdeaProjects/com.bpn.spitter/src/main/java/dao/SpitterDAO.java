package dao;

import model.UsersInformation;

public interface SpitterDAO {
    public static final String PARAMETERIZED_SQL_INSERT = "INSERT INTO " + UsersInformation.TABLE_NAME + " VALUES (:login, :password, :name, :fullName )";
    public static final String PARAMETERIZED_SQL_SELECT = "SELECT *  FROM " + UsersInformation.TABLE_NAME;
    public static final String PARAMETERIZED_SQL_DELETE = "DELETE FROM " + UsersInformation.TABLE_NAME + " WHERE " + UsersInformation.LOGIN_COLUMN + "=:login";
    public static final String PARAMETERIZED_SQL_SELECT_BY_LOGIN = "SELECT *  FROM " + UsersInformation.TABLE_NAME + " WHERE " + UsersInformation.LOGIN_COLUMN + "=:login" ;
    public static final String PARAMETERIZED_SQL_UPDATE = "UPDATE " + UsersInformation.TABLE_NAME + " SET login = :newLogin WHERE login = :login";

    public void insert(UsersInformation usersInformation);
    public void insert(String login, String password, String name, String fullName);
    public void select();
    public void delete(String login);
    public UsersInformation selectByLogin(String login);
    public int update(String newLogin, String Login);

}
