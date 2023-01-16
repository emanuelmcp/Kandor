package io.github.emanuelmcp.KandorBackendStaff.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
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

    @JsonIgnore
    private Set<GroupRef> groupId = new HashSet<>();
    @Transient
    @JsonIgnore
    private boolean newEntity;

    void addGroup(@NotNull Group group) {
        this.getGroupId().add(new GroupRef(group.getId()));
    }

    public Set<Integer> getGroupIds(){
        return this.groupId.stream().map(GroupRef::getGroup).collect(Collectors.toSet());
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
