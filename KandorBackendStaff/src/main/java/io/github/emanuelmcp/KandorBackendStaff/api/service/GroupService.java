package io.github.emanuelmcp.KandorBackendStaff.api.service;

import io.github.emanuelmcp.KandorBackendStaff.database.models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> getAll();
    Optional<Group> viewById(String id);
    void delete(String id);
    Group save(Group group);
    Group update(Group group);
}
