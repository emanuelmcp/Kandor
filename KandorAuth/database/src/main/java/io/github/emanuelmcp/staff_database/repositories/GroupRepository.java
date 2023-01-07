package io.github.emanuelmcp.staff_database.repositories;

import io.github.emanuelmcp.api.database.repository.CrudRepository;
import io.github.emanuelmcp.staff_database.models.Group;

public interface GroupRepository extends CrudRepository<Group, String> {
}
