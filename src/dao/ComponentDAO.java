package dao;

import entities.Component;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ComponentDAO implements DAO<Component>{
    private final Connection connection;

    public ComponentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Component> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Component> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Component component) {
        return false;
    }

    @Override
    public boolean update(Component component) {
        return false;
    }

    @Override
    public boolean delete(Component component) {
        return false;
    }
}
