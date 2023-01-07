package io.github.emanuelmcp.KandorBackendStaff.api.repository;

import java.util.List;

public interface CrudRepository<T, K> {
    K save(T model);
    void update(T model);
    long count();
    List<T> findAll(int size, int page, String queryable);
    T findById(K id);
    void delete(K id);
    boolean exists(K id);
}
