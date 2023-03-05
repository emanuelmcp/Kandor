package io.github.emanuelmcp.kandorauth.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Group {
    String groupName;
    String description;
    String prefix;
    String suffix;
}
