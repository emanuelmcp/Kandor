package io.github.emanuelmcp.KandorBackendStaff.api.model;

import io.github.emanuelmcp.KandorBackendStaff.api.repository.CrudRepository;
import lombok.Getter;

@Getter
public abstract class Model<K> extends CrudRepository<K> {

}
