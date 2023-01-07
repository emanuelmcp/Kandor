package io.github.emanuelmcp.staff_database.mappers;

import com.google.inject.Singleton;
import io.github.emanuelmcp.api.database.mapper.RowMapper;
import io.github.emanuelmcp.staff_database.models.Account;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account rowRead(@NotNull ResultSet rs) throws SQLException {
        return Account.builder()
                .uuid(rs.getString("uuid"))
                .nick(rs.getString("nick"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .lastLogin(rs.getDate("last_login"))
                .banned(rs.getBoolean("banned"))
                .logged(rs.getBoolean("logged"))
                .build();
    }
    @Override
    public void rowInsert(@NotNull Account account, @NotNull PreparedStatement statement) throws SQLException {
        statement.setString(1, account.getUuid());
        statement.setString(2, account.getNick());
        statement.setString(3, account.getPassword());
        statement.setBoolean(4, account.isBanned());
        statement.setBoolean(5, account.isLogged());
    }
    @Override
    public void rowUpdate(@NotNull Account account, @NotNull PreparedStatement statement) throws SQLException {
        statement.setString(1, account.getNick());
        statement.setString(2, account.getEmail());
        statement.setString(3, account.getPassword());
        statement.setDate(4, new Date(account.getLastLogin().getTime()));
        statement.setBoolean(5, account.isLogged());
        statement.setBoolean(6, account.isBanned());
        statement.setString(7, account.getUuid());
    }
}