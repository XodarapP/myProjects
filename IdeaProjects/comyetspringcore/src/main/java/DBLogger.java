import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLogger implements EventLogger {
    private JdbcTemplate jdbcTemplate;


    public DBLogger(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void logEvent(Event event) {
        jdbcTemplate.query(" SELECT * FROM [dbo].[third]", new DBLoggerMapper());

    }

    private class DBLoggerMapper implements RowMapper<ThirdDB>{

        @Override
        public ThirdDB mapRow(ResultSet rs, int rowNum) throws SQLException {
            ThirdDB thirdDB = new ThirdDB();
            thirdDB.setFirstRow(rs.getInt("int"));
            thirdDB.setSecondRow(rs.getString("string"));
            System.out.println(thirdDB.toString());
            return thirdDB;
        }
    }
}
