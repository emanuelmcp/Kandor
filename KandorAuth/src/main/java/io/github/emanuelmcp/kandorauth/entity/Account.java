package io.github.emanuelmcp.kandorauth.entity;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class Account {
    String uuid;
    String nick;
    String email;
    String password;
    Timestamp lastLogin;
    Boolean logged;
    Boolean banned;
}
