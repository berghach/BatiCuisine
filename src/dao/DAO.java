package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<Entity> {
    Optional<Entity> get(long id);
    List<Entity> getAll();
    boolean save(Entity entity) throws IllegalAccessException;
    boolean update(Entity entity) throws IllegalAccessException;
    boolean delete(Entity entity);
}
