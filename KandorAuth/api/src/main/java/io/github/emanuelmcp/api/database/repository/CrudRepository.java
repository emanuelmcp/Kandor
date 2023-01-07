package io.github.emanuelmcp.api.database.repository;

import org.bukkit.entity.Player;

import java.util.List;

public interface CrudRepository<T, K>{
    void save(T t);
    List<T> getAll();
    T findById(K id);
    void update(T someObject);
    void remove(K id);
    boolean exists(K id);
}
