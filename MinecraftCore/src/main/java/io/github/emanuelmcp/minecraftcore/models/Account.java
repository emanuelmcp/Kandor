package io.github.emanuelmcp.minecraftcore.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
public class Account {
    private String uuid;
    private String nick;
    private String email;
    private String password;
    private Timestamp lastLogin;
    private boolean logged;
    private boolean banned;
}
