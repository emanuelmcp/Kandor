package io.github.emanuelmcp.KandorBackendStaff.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
@Table("staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRef {
    private Integer group;
}
