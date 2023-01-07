package io.github.emanuelmcp.KandorBackendStaff.api.mappers;

import io.github.emanuelmcp.KandorBackendStaff.api.model.Model;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper  {
    Model rowRead(ResultSet rs) throws SQLException;
    void rowInsert(@NotNull Model model, @NotNull PreparedStatement statement) throws SQLException;
    void rowUpdate(@NotNull Model model, @NotNull PreparedStatement statement) throws SQLException;
}
