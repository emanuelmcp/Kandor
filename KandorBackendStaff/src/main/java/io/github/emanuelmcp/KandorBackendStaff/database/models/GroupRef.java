package io.github.emanuelmcp.KandorBackendStaff.database.models;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Table("staff")
@AllArgsConstructor
public class GroupRef {
    private Integer group;

    Integer getGroup(){
        return group;
    }
}
