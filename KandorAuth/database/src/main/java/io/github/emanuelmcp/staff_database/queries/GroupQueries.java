package io.github.emanuelmcp.staff_database.queries;

public class GroupQueries {
    public static String FIND_BY_ID = "SELECT * FROM account_type WHERE group_name LIKE ?";
    public static String CREATE = "INSERT INTO account_type(" +
            "group_name, " +
            "description, " +
            "prefix, " +
            "suffix) " +
            "VALUES (?, ?, ?, ?)";
    public static String DELETE = "DELETE FROM account_type WHERE group_name = ?";
}
