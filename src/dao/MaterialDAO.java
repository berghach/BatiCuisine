package dao;

import entities.Material;
import entities.Project;
import enums.ComponentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialDAO implements DAO<Material>{
    private final Connection connection;

    public MaterialDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Material> get(long id) {
        String query = "SELECT * FROM material WHERE id = ?";
        ProjectDAO projectDAO = new ProjectDAO(connection);

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Project project = projectDAO.get(rs.getInt("project_id")).orElse(null);

                Material material = new Material(
                        rs.getString("name"),
                        ComponentType.valueOf(rs.getString("component_type").toUpperCase()),
                        rs.getDouble("vat_rate"),
                        project,
                        rs.getDouble("unit_price"),
                        rs.getDouble("quantity"),
                        rs.getDouble("transport_price"),
                        rs.getDouble("quality_coefficient")
                );
                material.setId(rs.getInt("id"));
                return Optional.of(material);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Material> getAll() {
        String query = "SELECT * FROM material";
        ProjectDAO projectDAO = new ProjectDAO(connection);

        List<Material> materials = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Project project = projectDAO.get(rs.getInt("project_id")).orElse(null);

                Material material = new Material(
                        rs.getString("name"),
                        ComponentType.fromString(rs.getString("component_type")),
                        rs.getDouble("vat_rate"),
                        project,
                        rs.getDouble("unit_price"),
                        rs.getDouble("quantity"),
                        rs.getDouble("transport_price"),
                        rs.getDouble("quality_coefficient")
                );
                material.setId(rs.getInt("id"));
                materials.add(material);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return materials;
    }

    @Override
    public boolean save(Material material) {
        String query = "INSERT INTO material (name, component_type, vat_rate, project_id, unit_price, quantity, transport_price, quality_coefficient) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, material.getName());
            statement.setString(2, material.getComponentType().toString()); 
            statement.setDouble(3, material.getVatRate());
            statement.setInt(4, material.getProject().getId());
            statement.setDouble(5, material.getUnitPrice());
            statement.setDouble(6, material.getQuantity());
            statement.setDouble(7, material.getTransportPrice());
            statement.setDouble(8, material.getQualityCoefficient());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting material", e);
        }
    }

    @Override
    public boolean update(Material material) {
        String query = "UPDATE material SET name = ?, component_type = ?, vat_rate = ?, project_id = ?, " +
                "unit_price = ?, quantity = ?, transport_price = ?, quality_coefficient = ? " +
                "WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, material.getName());
            statement.setString(2, material.getComponentType().getName()); 
            statement.setDouble(3, material.getVatRate());
            statement.setInt(4, material.getProject().getId());
            statement.setDouble(5, material.getUnitPrice());
            statement.setDouble(6, material.getQuantity());
            statement.setDouble(7, material.getTransportPrice());
            statement.setDouble(8, material.getQualityCoefficient());
            statement.setInt(9, material.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error updating material", e);
        }
    }

    @Override
    public boolean delete(Material material) {
        String query = "DELETE FROM component WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, material.getId());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
