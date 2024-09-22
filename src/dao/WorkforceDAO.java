package dao;

import entities.Workforce;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class WorkforceDAO implements DAO<Workforce>{
    private final Connection connection;

    public WorkforceDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Workforce> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Workforce> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Workforce workforce) {
        return false;
    }

    @Override
    public boolean update(Workforce workforce) {
        return false;
    }

    @Override
    public boolean delete(Workforce workforce) {
        return false;
    }
}
