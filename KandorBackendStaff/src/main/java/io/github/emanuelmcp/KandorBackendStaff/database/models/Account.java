package io.github.emanuelmcp.KandorBackendStaff.database.models;

import io.github.emanuelmcp.KandorBackendStaff.api.model.Model;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
public class Account extends Model<String> implements Serializable {
    private String uuid;
    private String nick;
    private String email;
    private String password;
    private Date lastLogin;
    private boolean logged;
    private boolean banned;
    //private Set<Group> groups;
}
