package io.github.emanuelmcp.staff_database.mappers;

import com.google.inject.Singleton;
import io.github.emanuelmcp.api.database.mapper.RowMapper;
import io.github.emanuelmcp.staff_database.models.Group;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class GroupMapper implements RowMapper<Group> {

    @Override
    public Group rowRead(ResultSet rs) throws SQLException {
        return Group.builder()
                .groupName(rs.getString("group_name"))
                .description(rs.getString("description"))
                .prefix(rs.getString("prefix"))
                .suffix(rs.getString("suffix"))
                .build();
    }

    @Override
    public void rowInsert(@NotNull Group group, @NotNull PreparedStatement statement) throws SQLException {
        statement.setString(1, group.getGroupName());
        statement.setString(2, group.getDescription());
        statement.setString(3, group.getPrefix());
        statement.setString(4, group.getSuffix());
    }

    @Override
    public void rowUpdate(@NotNull Group model, @NotNull PreparedStatement statement) throws SQLException {

    }
}
