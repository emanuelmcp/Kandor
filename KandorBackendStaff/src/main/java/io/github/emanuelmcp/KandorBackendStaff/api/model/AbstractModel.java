package io.github.emanuelmcp.KandorBackendStaff.api.model;

import io.github.emanuelmcp.KandorBackendStaff.api.mappers.RowMapper;
import io.github.emanuelmcp.KandorBackendStaff.database.managers.PosgresManager;
import io.github.emanuelmcp.KandorBackendStaff.database.models.Account;
import io.github.emanuelmcp.KandorBackendStaff.database.queries.AccountQueries;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter

public abstract class AbstractModel<T, K> {
    String query;
    PosgresManager pool;
    RowMapper<AbstractModel<T, K>> mapper;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;
    private K id;

    public K save(AbstractModel<T, K> abstractModel) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(this.query);
            mapper.rowInsert(abstractModel, statement);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
        return abstractModel.getId();
    }
    public void update(@NotNull AbstractModel<T, K> abstractModel) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(this.query);
            mapper.rowUpdate(abstractModel, statement);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    public long count() {
        return 0;
    }
    public List<T> findAll(int size, int page, String queryable) {
        return new ArrayList<>();
    }
    public T findById(K id) {
        AbstractModel<T, K> abstractModel = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(AccountQueries.FIND_BY_ID);
            statement.setObject(1, id);
            results = statement.executeQuery();
            if (results.next()) abstractModel = mapper.rowRead(results);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
        return (T) abstractModel;
    }
    public void delete(K id) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(this.query);
            statement.setObject(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
    }
    public boolean exists(K id) {
        return findById(id) != null;
    }
    private void rollback(@NotNull Connection connection){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private K getId() {
        return this.id;
    }

}
