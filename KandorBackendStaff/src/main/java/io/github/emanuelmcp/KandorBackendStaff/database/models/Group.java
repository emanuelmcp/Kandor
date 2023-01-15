package io.github.emanuelmcp.KandorBackendStaff.database.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
@Data
@Table("grupo")
public class Group implements Persistable<String>, Serializable {
    @Id
    @Column("nombre")
    String groupName;
    @Column("descripcion")
    String description;
    @Column("prefijo")
    String prefix;
    @Column("sufijo")
    String suffix;

    @Transient
    @JsonIgnore
    private boolean newEntity;

    @Override
    @JsonIgnore
    public String getId() {
        return groupName;
    }
    public void setNew(boolean newInstance) {
        this.newEntity = newInstance;
    }
    @Override
    @JsonIgnore
    public boolean isNew() {
        return newEntity;
    }
}
