package dao;

import entities.Component;
import enums.ComponentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComponentDAO implements DAO<Component>{
    private final Connection connection;

    public ComponentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Component> get(long id) {
        String query = "SELECT * FROM component WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Component component = new Component(
                        rs.getString("name"),
                        ComponentType.valueOf(rs.getString("component_type").toUpperCase()),
                        rs.getDouble("vat_rate"),
                        rs.getInt("project_id")
                );
                component.setId(rs.getInt("id"));

                return Optional.of(component);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Component> getAll() {
        String query = "SELECT * FROM component";
        List<Component> components = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Component component = new Component(
                        rs.getString("name"),
                        ComponentType.valueOf(rs.getString("component_type").toUpperCase()),
                        rs.getDouble("vat_rate"),
                        rs.getInt("project_id")
                );
                component.setId(rs.getInt("id"));

                components.add(component);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return components;
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
