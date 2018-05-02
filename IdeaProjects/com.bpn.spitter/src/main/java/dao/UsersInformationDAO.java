package dao;

import model.UsersInformation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UsersInformationDAO implements SpitterDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @DateTimeFormat(pattern = "dd/mm/yyyy hh:mm")
    private LocalDateTime dateTimeWithFormat;

    public UsersInformationDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(UsersInformation usersInformation) {

    }

    @Override
    public void insert(String login, String password, String name, String fullName) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        //parameterSource.addValue("id", id);
        parameterSource.addValue("login", login);
        parameterSource.addValue("password", password);
        parameterSource.addValue("name", name);
        parameterSource.addValue("fullName", fullName);
        jdbcTemplate.update(PARAMETERIZED_SQL_INSERT, parameterSource);
    }

    @Override
    public UsersInformation selectByLogin(String login) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("login", login);
        return jdbcTemplate.queryForObject(PARAMETERIZED_SQL_SELECT_BY_LOGIN, parameterSource, new UserInformationRowMapper<>());
    }

    @Override
    public int update(String newLogin, String login) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("newLogin", newLogin);
        parameterSource.addValue("login", login);
        return jdbcTemplate.update(PARAMETERIZED_SQL_UPDATE, parameterSource);
    }

    @Override
    public void select() {
        jdbcTemplate.query(PARAMETERIZED_SQL_SELECT, new UserInformationRowMapper<>());
    }

    @Override
    public void delete(String login) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("login", login);
        jdbcTemplate.update(PARAMETERIZED_SQL_DELETE, parameterSource);
    }

    public void lambdaQuery(){

    }

    private static class UserInformationRowMapper<T> implements RowMapper {
        @Override
        public UsersInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
            UsersInformation usersInformation = new UsersInformation();
            //usersInformation.setId(rs.getInt("id"));
            usersInformation.setLogin(rs.getString("login"));
            usersInformation.setName(rs.getString("name"));
            usersInformation.setPassword(rs.getString("password"));
            usersInformation.setFullName(rs.getString("fullName"));
            System.out.println(usersInformation.toString());
            return usersInformation;
        }
    }
}
