package com.springinaction.spitter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcSpitterDAO extends JdbcDaoSupport implements SpitterDAO {
    private static final String SQL_INSERT_SPITTER = "INSERT INTO Spitter (username, password, fullname) values (?,?,?)";
    private static final String SQL_SELECTSPITTER_BY_ID = "INSERT INTO Spitter (username, password, fullname) values (?,?,?)";
    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Spitter getSpitterById(long id){
        return jdbcTemplate.queryForObject(
                SQL_SELECTSPITTER_BY_ID, new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setFullName(rs.getString(1));
                        spitter.setUserName(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        return spitter;
                    }
                },id
        );
    }

    public void addSpitter(Spitter spitter){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", spitter.getUserName());
        params.put("password",spitter.getPassword());
        params.put("fullname", spitter.getFullName());
        jdbcTemplate.update(SQL_INSERT_SPITTER, params);
    }
}
