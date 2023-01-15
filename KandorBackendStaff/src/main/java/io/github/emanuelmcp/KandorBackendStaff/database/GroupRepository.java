package io.github.emanuelmcp.KandorBackendStaff.database;

import io.github.emanuelmcp.KandorBackendStaff.database.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, String> {
}
