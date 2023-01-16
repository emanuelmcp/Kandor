package io.github.emanuelmcp.KandorBackendStaff.database.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Data
@Table("group")
public class Group implements Serializable {
    Integer id;
    String name;
    String description;
    String prefix;
    String suffix;
}
