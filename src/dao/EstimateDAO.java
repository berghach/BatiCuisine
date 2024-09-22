package dao;

import entities.Estimate;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class EstimateDAO implements DAO<Estimate>{
    private final Connection connection;

    public EstimateDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Estimate> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Estimate> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Estimate estimate) {
        return false;
    }

    @Override
    public boolean update(Estimate estimate) {
        return false;
    }

    @Override
    public boolean delete(Estimate estimate) {
        return false;
    }
}
