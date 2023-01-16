package io.github.emanuelmcp.KandorBackendStaff.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("account")
public class Account implements Persistable<String> {
    @Id
    private String uuid;
    private String nick;
    private String email;
    private String password;
    private LocalDate login;
    private boolean logged;
    private boolean banned;
    private Set<GroupRef> groups;
    @Transient
    @JsonIgnore
    private boolean newEntity;

    void addGroup(@NotNull Group group) {
        this.getGroups().add(new GroupRef(group.getId()));
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
