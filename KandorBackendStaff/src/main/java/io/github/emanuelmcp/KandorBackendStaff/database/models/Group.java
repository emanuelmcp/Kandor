package io.github.emanuelmcp.KandorBackendStaff.database.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Data
@AllArgsConstructor
@Table("group")
public class Group implements Serializable {
    @Id
    Integer id;
    String name;
    String description;
    String prefix;
    String suffix;
}
