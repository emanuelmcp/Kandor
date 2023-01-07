package io.github.emanuelmcp.KandorBackendStaff.api.repository;

import io.github.emanuelmcp.KandorBackendStaff.api.mappers.RowMapper;
import io.github.emanuelmcp.KandorBackendStaff.api.model.Model;
import io.github.emanuelmcp.KandorBackendStaff.database.managers.PosgresManager;
import io.github.emanuelmcp.KandorBackendStaff.database.queries.AccountQueries;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class CrudRepository<K> {
    String query;
    PosgresManager pool;
    RowMapper mapper;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;
    protected Model save(Model model) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(this.query);
            mapper.rowInsert(model, statement);
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
        return null;
    }
    protected void update(@NotNull Model model) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(this.query);
            mapper.rowUpdate(model, statement);
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
    protected long count() {
        return 0;
    }
    protected List<Model> findAll(int size, int page, String queryable) {
        return null;
    }
    protected Model findById(K id) {
        Model model = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(AccountQueries.FIND_BY_ID);
            statement.setObject(1, id);
            results = statement.executeQuery();
            if (results.next()) model = mapper.rowRead(results);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
        return model;
    }
    protected void delete(K id) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(AccountQueries.DELETE);
            statement.setObject(1, id);
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
    protected boolean exists(K id) {
        return findById(id) != null;
    }
}
