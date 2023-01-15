package io.github.emanuelmcp.KandorBackendStaff.database.models;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Table("cuenta_grupo")
@AllArgsConstructor
public class GroupRef {
    @Column("id_grupo")
    private Integer group;

    Integer getGroup(){
        return group;
    }
}
