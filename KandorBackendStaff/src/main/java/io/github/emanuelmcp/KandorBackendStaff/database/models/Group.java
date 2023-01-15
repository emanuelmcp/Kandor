package io.github.emanuelmcp.KandorBackendStaff.database.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Data
@Table("grupo")
public class Group implements Serializable {
    @Id
    @Column("nombre")
    String groupName;
    @Column("descripcion")
    String description;
    @Column("prefijo")
    String prefix;
    @Column("sufijo")
    String suffix;
}
