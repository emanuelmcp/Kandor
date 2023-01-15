package io.github.emanuelmcp.KandorBackendStaff.database.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("Permisos")
public class Permission {
    @Column("nombre")
    @Id
    String groupName;
    @Column("description")
    String description;
}
