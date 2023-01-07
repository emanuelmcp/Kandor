package io.github.emanuelmcp.staff_database.repositories;

import com.google.inject.Inject;
import io.github.emanuelmcp.staff_database.managers.PostgresConnectionPoolManager;
import io.github.emanuelmcp.staff_database.mappers.AccountMapper;
import io.github.emanuelmcp.staff_database.mappers.GroupMapper;
import io.github.emanuelmcp.staff_database.models.Account;
import io.github.emanuelmcp.staff_database.models.Group;
import io.github.emanuelmcp.staff_database.queries.AccountQueries;
import io.github.emanuelmcp.staff_database.queries.GroupQueries;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GroupRepositoryImpl implements GroupRepository{
    PostgresConnectionPoolManager pool;
    GroupMapper groupMapper;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;
    @Inject
    public GroupRepositoryImpl(PostgresConnectionPoolManager pool, GroupMapper groupMapper) {
        this.pool = pool;
        this.groupMapper = groupMapper;
    }
    @Override
    public void save(Group group) {
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(GroupQueries.CREATE);
            groupMapper.rowInsert(group, statement);
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
    public List<Group> getAll() {
        return null;
    }

    @Override
    public Group findById(String id) {
        Group group = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(GroupQueries.FIND_BY_ID);
            statement.setString(1, id);
            results = statement.executeQuery();
            if (results.next()) group = groupMapper.rowRead(results);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, results);
        }
        return group;
    }

    @Override
    public void update(Group someObject) {

    }

    @Override
    public void remove(String id) {
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(GroupQueries.DELETE);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
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
