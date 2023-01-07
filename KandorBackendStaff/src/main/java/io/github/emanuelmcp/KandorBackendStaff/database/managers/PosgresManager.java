package io.github.emanuelmcp.KandorBackendStaff.database.managers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.emanuelmcp.KandorBackendStaff.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class PosgresManager {
    private final HikariConfig hikariConfig = new HikariConfig();
    private HikariDataSource dataSource;
    private final Database config;

    @Autowired
    public PosgresManager(Database config) {
        this.config = config;
    }

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName(config.getDriver())
                .url(config.getUrl())
                .username(config.getUsername())
                .password(config.getPassword())
                .build();
    }
    @Bean
    public void setupPool(){
        hikariConfig.setDataSource(datasource());
        hikariConfig.setMinimumIdle(3);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTimeout(5000);
        hikariConfig.setJdbcUrl(config.getUrl());
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
        return datasource().getConnection();
    }
}
