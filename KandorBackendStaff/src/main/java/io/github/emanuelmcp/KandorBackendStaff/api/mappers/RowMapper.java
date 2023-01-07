package io.github.emanuelmcp.KandorBackendStaff.api.mappers;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T rowRead(ResultSet rs) throws SQLException;
    void rowInsert(@NotNull T model, @NotNull PreparedStatement statement) throws SQLException;
    void rowUpdate(@NotNull T model, @NotNull PreparedStatement statement) throws SQLException;
}
