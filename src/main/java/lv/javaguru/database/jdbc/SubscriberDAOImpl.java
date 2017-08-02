package lv.javaguru.database.jdbc;

import lv.javaguru.database.DBException;
import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;
@Component
public class SubscriberDAOImpl extends DAOImpl implements SubscriberDAO {

    @Override
    public Subscriber save(Subscriber subscriber) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "insert into SUBSCRIBERS(account_no, first_name, last_name, personal_Id, balance) " +
                    "values(default, ?, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, subscriber.getFirstName());
            preparedStatement.setString(2, subscriber.getLastName());
            preparedStatement.setString(3, subscriber.getPersonalID());
            preparedStatement.setString(4, String.valueOf(subscriber.getBalance()));

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                subscriber.setAccountNo(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute SubscriberDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return subscriber;

    }

    @Override
    public Optional<Subscriber> getByAccountNo(Long accountNo) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from SUBSCRIBERS where account_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            Subscriber subscriber = null;
            if (resultSet.next()) {
                subscriber = createSubscriber()
                        .withAccountNo(resultSet.getLong("account_no"))
                        .withFirstName(resultSet.getString("first_name"))
                        .withLastName(resultSet.getString("last_name"))
                        .withPersonalID(resultSet.getString("personal_id"))
                        .withBalance(resultSet.getDouble("balance")).build();
            }
            return Optional.ofNullable(subscriber);
        } catch (Throwable e) {
            System.out.println("Exception while execute SubscriberDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Subscriber> getByFirstName(String firstName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from SUBSCRIBERS where first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Subscriber subscriber = null;
            if (resultSet.next()) {
                subscriber = createSubscriber()
                        .withAccountNo(resultSet.getLong("account_no"))
                        .withFirstName(resultSet.getString("first_name"))
                        .withLastName(resultSet.getString("last_name"))
                        .withPersonalID(resultSet.getString("personal_id"))
                        .withBalance(resultSet.getDouble("balance")).build();
            }
            return Optional.ofNullable(subscriber);
        } catch (Throwable e) {
            System.out.println("Exception while execute SubscriberDAOImpl.getByFirstName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Subscriber> getByPersonalId(String personalId) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from SUBSCRIBERS where personal_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, personalId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Subscriber subscriber = null;
            if (resultSet.next()) {
                subscriber = createSubscriber()
                        .withAccountNo(resultSet.getLong("account_no"))
                        .withFirstName(resultSet.getString("first_name"))
                        .withLastName(resultSet.getString("last_name"))
                        .withPersonalID(resultSet.getString("personal_id"))
                        .withBalance(resultSet.getDouble("balance")).build();
            }
            return Optional.ofNullable(subscriber);
        } catch (Throwable e) {
            System.out.println("Exception while execute SubscriberDAOImpl.getByPersonalId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Subscriber> getAll() throws DBException {
        List<Subscriber> subscribers = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from SUBSCRIBERS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Subscriber subscriber = createSubscriber()
                        .withAccountNo(resultSet.getLong("account_no"))
                        .withFirstName(resultSet.getString("first_name"))
                        .withLastName(resultSet.getString("last_name"))
                        .withPersonalID(resultSet.getString("personal_id"))
                        .withBalance(resultSet.getDouble("balance")).build();
                subscribers.add(subscriber);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list SubscriberDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return subscribers;
    }

    @Override
    public void delete(Subscriber subscriber) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "delete from SUBSCRIBERS where account_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, subscriber.getAccountNo());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute SubscriberDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
