package io.github.emanuelmcp.staff_database;

import io.github.emanuelmcp.api.annotations.PostConstruct;
import io.github.emanuelmcp.staff_database.managers.PostgresConnectionPoolManager;
import io.github.emanuelmcp.staff_database.models.Group;
import io.github.emanuelmcp.staff_database.queries.InitQueries;
import io.github.emanuelmcp.staff_database.repositories.GroupRepositoryImpl;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Singleton
public class StaffDatabase {
    private final PostgresConnectionPoolManager pool;
    private final GroupRepositoryImpl repository;
    private Connection connection = null;
    private PreparedStatement statement = null;

    @Inject
    public StaffDatabase(PostgresConnectionPoolManager pool, GroupRepositoryImpl repository) {
        this.pool = pool;
        this.repository = repository;
    }
    @PostConstruct
    public void createStructure(){
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            for (String query : InitQueries.TABLES) connection.prepareStatement(query).execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            pool.close(connection, statement, null);
        }
    }
    public void addNeededData(){
        repository.save(
                Group.builder()
                        .groupName("default")
                        .description("Default group")
                        .prefix("")
                        .suffix("")
                        .build()
        );
    }
}
