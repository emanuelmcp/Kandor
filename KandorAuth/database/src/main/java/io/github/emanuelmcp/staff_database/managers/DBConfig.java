package io.github.emanuelmcp.staff_database.managers;
import lombok.Getter;

@Getter
public abstract class DBConfig {
    protected String hostname;
    protected String port;
    protected String username;
    protected String password;
    protected String database;
}
