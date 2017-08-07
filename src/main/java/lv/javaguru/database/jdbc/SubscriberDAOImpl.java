package lv.javaguru.database.jdbc;

import lv.javaguru.database.DBException;
import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Component
public class SubscriberDAOImpl implements SubscriberDAO {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SubscriberDAOImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static RowMapper<Subscriber> rowMapper() {
        return (rs, rowNum) -> {
            Subscriber s = new Subscriber();
            s.setAccountNo(rs.getLong("account_no"));
            s.setFirstName(rs.getString("first_name"));
            s.setLastName(rs.getString("last_name"));
            s.setPersonalID(rs.getString("personal_id"));
            s.setBalance(rs.getDouble("balance"));
            return s;
        };
    }

    @Override
    public Subscriber save(Subscriber subscriber) throws DBException {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("subscribers")
                .usingColumns("first_name", "last_name", "personal_id", "balance")
                .usingGeneratedKeyColumns("id");

        Map parameters = new HashMap();
        parameters.put("first_name", subscriber.getFirstName());
        parameters.put("last_name", subscriber.getLastName());
        parameters.put("personal_id", subscriber.getPersonalID());
        parameters.put("balance", subscriber.getBalance());

        Long account_no = insert.executeAndReturnKey(parameters).longValue();
        subscriber.setAccountNo(account_no);
//        Connection connection = null;
//
//        try {
//            connection = getConnection();
//            String sql = "insert into SUBSCRIBERS(account_no, first_name, last_name, personal_Id, balance) " +
//                    "values(default, ?, ?, ?, ?)";
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, subscriber.getFirstName());
//            preparedStatement.setString(2, subscriber.getLastName());
//            preparedStatement.setString(3, subscriber.getPersonalID());
//            preparedStatement.setString(4, String.valueOf(subscriber.getBalance()));
//
//            preparedStatement.executeUpdate();
//            ResultSet rs = preparedStatement.getGeneratedKeys();
//            if(rs.next()){
//                subscriber.setAccountNo(rs.getLong(1));
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while execute SubscriberDAOImpl.save()");
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }

        return subscriber;

    }

    @Override
    public Optional<Subscriber> getByAccountNo(Long accountNo) throws DBException {
        List<Subscriber> subscribers = this.jdbcTemplate.query(
                "select * from SUBSCRIBERS where account_no = ?",
                new Object[]{accountNo},
                rowMapper());
        if (subscribers.isEmpty()) {
            return Optional.empty();
        } else {
            if (subscribers.size() == 1) {
                return Optional.ofNullable(subscribers.get(0));
            } else {
                throw new IllegalStateException("More then one row returned!");
            }
        }
    }

    @Override
    public Optional<Subscriber> getByFirstName(String firstName) throws DBException {
        Subscriber subscriber = this.jdbcTemplate.queryForObject(
                "select * from SUBSCRIBERS where fist_name = ?",
                new Object[]{firstName},
                rowMapper());
        return Optional.ofNullable(subscriber);

    }

    @Override
    public Optional<Subscriber> getByPersonalId(String personalId) throws DBException {
        Subscriber subscriber = this.jdbcTemplate.queryForObject(
                "select * from SUBSCRIBERS where personal_id = ?",
                new Object[]{personalId},
                rowMapper());
        return Optional.ofNullable(subscriber);

    }


    @Override
    public List<Subscriber> getAll() throws DBException {
        List<Subscriber> subscriber = this.jdbcTemplate.query(
                "select * from SUBSCRIBERS",
                rowMapper());
        return subscriber;
    }

    @Override
    public void delete(Subscriber subscriber) throws DBException {
        this.jdbcTemplate.update(
                "delete from subscribers where account_no = ?",
                subscriber.getAccountNo());
    }

}
