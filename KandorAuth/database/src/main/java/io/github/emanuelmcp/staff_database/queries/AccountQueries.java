package io.github.emanuelmcp.staff_database.queries;

public class AccountQueries {
    public static final String FIND_BY_ID = "SELECT * FROM account WHERE uuid LIKE ?";
    public static final String CREATE = "INSERT INTO account(" +
            "uuid, " +
            "nick, " +
            "password, " +
            "banned, " +
            "logged) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE = "UPDATE account " +
            "SET nick = ?, " +
            "email = ?, " +
            "password = ?, " +
            "last_login = ?, " +
            "logged = ?, " +
            "banned = ? " +
            "WHERE uuid = ?";
    public static final String DELETE = "DELETE FROM account WHERE uuid = ?";
}
