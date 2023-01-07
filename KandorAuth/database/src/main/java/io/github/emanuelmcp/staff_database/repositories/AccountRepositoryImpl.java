package io.github.emanuelmcp.staff_database.repositories;

import com.google.inject.Inject;
import io.github.emanuelmcp.staff_database.managers.PostgresConnectionPoolManager;
import io.github.emanuelmcp.staff_database.mappers.AccountMapper;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.queries.AccountQueries;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class AccountRepositoryImpl implements AccountRepository{
    private final PostgresConnectionPoolManager pool;
    private final AccountMapper accountMapper;
    private Connection connection = null;
    private PreparedStatement statement = null;
    ResultSet results = null;
    @Inject
    public AccountRepositoryImpl(PostgresConnectionPoolManager pool, AccountMapper accountMapper) {
        this.pool = pool;
        this.accountMapper = accountMapper;
    }
    @Override
    public void save(Account account) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(AccountQueries.CREATE);
            accountMapper.rowInsert(account, statement);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    @Override
    public List<Account> getAll() {
        return null;
    }
    @Override
    public Account findById(String id) {
        Account player = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(AccountQueries.FIND_BY_ID);
            statement.setString(1, id);
            results = statement.executeQuery();
            if (results.next()) player = accountMapper.rowRead(results);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
        return player;
    }
    @Override
    public void update(@NotNull Account account) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(AccountQueries.UPDATE);
            accountMapper.rowUpdate(account, statement);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    @Override
    public void remove(String id) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(AccountQueries.DELETE);
            statement.setString(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    @Override
    public boolean exists(String id) {
        return findById(id) != null;
    }
}
