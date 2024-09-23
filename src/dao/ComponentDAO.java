package dao;

import entities.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public boolean save(Component component) throws IllegalAccessException {
        throw new IllegalAccessException("Component does not has access to a such functionality.");
    }

    @Override
    public boolean update(Component component) throws IllegalAccessException{
        throw new IllegalAccessException("Component does not has access to a such functionality.");
    }

    @Override
    public boolean delete(Component component) {
        String query = "DELETE FROM component WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, component.getId());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
