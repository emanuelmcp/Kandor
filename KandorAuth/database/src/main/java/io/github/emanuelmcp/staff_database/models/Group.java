package io.github.emanuelmcp.staff_database.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Builder
public class Group implements Serializable {
    String groupName;
    String description;
    String prefix;
    String suffix;
}
