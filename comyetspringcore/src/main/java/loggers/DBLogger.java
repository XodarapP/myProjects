package loggers;

import event.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tables.SpringLog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLogger implements EventLogger{
    private JdbcTemplate jdbcTemplate;

    public DBLogger(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void logEvent(Event event) {
        //jdbcTemplate.query(" SELECT * FROM [dbo].[third]", new DBLoggerMapper());
        jdbcTemplate.update("INSERT INTO spring_log VALUES (?,?)", event.getId(), event.getMsg());
    }

    public void getAllRecordsInTable() {
        jdbcTemplate.query("SELECT * FROM spring_log", (resultSet, i) -> {
            SpringLog springLog = new SpringLog();
            springLog.setId(resultSet.getString("id"));
            springLog.setMessage(resultSet.getString("message"));
            System.out.println(springLog.toString());
            return springLog;
        });
    }

    public void getFirstRecordInTable() {
        jdbcTemplate.query("SELECT TOP 1 FROM SPRING_LOG", (resultSet, i) -> {
            SpringLog springLog = new SpringLog();
            springLog.setId(resultSet.getString("id"));
            springLog.setMessage(resultSet.getString("message"));
            return springLog;
        });
    }

    public void init(){
        jdbcTemplate.update("CREATE TABLE ");
    }
}
