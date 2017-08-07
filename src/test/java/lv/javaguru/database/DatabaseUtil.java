package lv.javaguru.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseUtil {

    private JdbcTemplate jdbcTemplate;

    public DatabaseUtil(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void cleanDatabase() throws DBException {

        this.jdbcTemplate.update(
                "delete from subscribers");
    }

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("SUBSCRIBERS");
        return tableNames;
    }
}
