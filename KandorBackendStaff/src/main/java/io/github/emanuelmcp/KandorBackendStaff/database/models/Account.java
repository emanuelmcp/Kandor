package io.github.emanuelmcp.KandorBackendStaff.database.models;

import io.github.emanuelmcp.KandorBackendStaff.api.model.AbstractModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@Builder
public class Account extends AbstractModel<Account, String> {
    private String uuid;
    private String nick;
    private String email;
    private String password;
    private Date lastLogin;
    private boolean logged;
    private boolean banned;
    //private Set<Group> groups;
}
