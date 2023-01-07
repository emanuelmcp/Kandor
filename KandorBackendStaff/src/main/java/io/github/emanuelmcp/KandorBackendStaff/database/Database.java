package io.github.emanuelmcp.KandorBackendStaff.database;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "database")
public class Database {
    String url;
    String driver;
    String username;
    String password;
}
