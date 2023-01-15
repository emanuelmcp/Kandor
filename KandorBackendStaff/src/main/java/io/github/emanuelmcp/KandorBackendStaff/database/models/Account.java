package io.github.emanuelmcp.KandorBackendStaff.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Table("cuenta")
public class Account implements Persistable<String> {
    @Column("uuid")
    @Id
    private String uuid;

    @Column("nick")
    private String nick;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("ultimo_login")
    private LocalDate lastLogin;

    @Column("logueado")
    private boolean logged;

    @Column("baneado")
    private boolean banned;

    @Transient
    private Set<GroupRef> groupId = new HashSet<>();
    @Transient
    @JsonIgnore
    private boolean newEntity;

    void addGroup(Group group) {
        this.getGroupId().add(new GroupRef(group.getGroupName()));
    }

    @Override
    @JsonIgnore
    public String getId() {
        return uuid;
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
