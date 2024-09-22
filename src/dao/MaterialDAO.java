package dao;

import entities.Material;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class MaterialDAO implements DAO<Material>{
    private final Connection connection;

    public MaterialDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Material> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Material> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Material material) {
        return false;
    }

    @Override
    public boolean update(Material material) {
        return false;
    }

    @Override
    public boolean delete(Material material) {
        return false;
    }
}
