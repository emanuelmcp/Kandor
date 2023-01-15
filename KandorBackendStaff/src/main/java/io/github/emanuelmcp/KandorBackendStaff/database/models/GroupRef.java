package io.github.emanuelmcp.KandorBackendStaff.database.models;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

//Para crear una clase poner primero la tabla que contiene la entidad debil

@Table("account_group")
@AllArgsConstructor
public class GroupRef {
    private String group;
}
