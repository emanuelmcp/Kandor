package io.github.emanuelmcp.staff_database.managers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.emanuelmcp.api.annotations.PostConstruct;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class PostgresConnectionPoolManager extends DBConfig {
    @Inject
    private FileConfiguration config;
    @Inject
    private HikariConfig hikariConfig;
    @Getter
    private HikariDataSource dataSource;

    public void init() {
        hostname = config.getString("persistence_db.hostname");
        port = config.getString("persistence_db.port");
        database = config.getString("persistence_db.database");
        username = config.getString("persistence_db.username");
        password = config.getString("persistence_db.password");
    }
    @PostConstruct
    public void setupPool(){
        init();
        hikariConfig.setJdbcUrl("jdbc:postgresql://" + hostname + ":" + port + "/" + database);
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(3);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTimeout(5000);
        dataSource = new HikariDataSource(hikariConfig);
    }
    public void close(Connection conn, PreparedStatement ps, ResultSet res) {
        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
        if (res != null) try { res.close(); } catch (SQLException ignored) {}
    }
    public void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
