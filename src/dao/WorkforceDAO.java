package dao;

import entities.Workforce;
import enums.ComponentType;
import enums.WorkforceLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkforceDAO implements DAO<Workforce>{
    private final Connection connection;

    public WorkforceDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Workforce> get(long id) {
        String query = "SELECT * FROM workforce WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Workforce workforce = new Workforce(
                        rs.getString("name"),
                        ComponentType.valueOf(rs.getString("component_type").toUpperCase()),
                        rs.getDouble("vat_rate"),
                        rs.getInt("project_id"),
                        WorkforceLevel.valueOf(rs.getString("workforce_level").toUpperCase()),
                        rs.getDouble("hourly_rate"),
                        rs.getDouble("work_hours"),
                        rs.getDouble("productivity_coefficient")
                );
                workforce.setId(rs.getInt("id"));
                return Optional.of(workforce);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Workforce> getAll() {
        String query = "SELECT * FROM workforce";
        List<Workforce> workforces = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Workforce workforce = new Workforce(
                        rs.getString("name"),
                        ComponentType.valueOf(rs.getString("component_type").toUpperCase()),
                        rs.getDouble("vat_rate"),
                        rs.getInt("project_id"), // Assuming ProjectDAO handles project fetching
                        WorkforceLevel.valueOf(rs.getString("workforce_level").toUpperCase()),
                        rs.getDouble("hourly_rate"),
                        rs.getDouble("work_hours"),
                        rs.getDouble("productivity_coefficient")
                );
                workforce.setId(rs.getInt("id"));
                workforces.add(workforce);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workforces;
    }

    @Override
    public boolean save(Workforce workforce) {
        String query = "INSERT INTO workforce (name, component_type, vat_rate, project_id, workforce_level, hourly_rate, work_hours, productivity_coefficient) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, workforce.getName());
            statement.setString(2, workforce.getComponentType().name().toLowerCase());
            statement.setDouble(3, workforce.getVatRate());
            statement.setInt(4, workforce.getProjectId());
            statement.setString(5, workforce.getWorkforceLevel().name().toLowerCase());
            statement.setDouble(6, workforce.getHourlyRate());
            statement.setDouble(7, workforce.getWorkHours());
            statement.setDouble(8, workforce.getProductivityCoefficient());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Workforce workforce) {
        String query = "UPDATE workforce SET name = ?, component_type = ?, vat_rate = ?, project_id = ?, workforce_level = ?, hourly_rate = ?, work_hours = ?, productivity_coefficient = ? " +
                "WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, workforce.getName());
            statement.setString(2, workforce.getComponentType().name().toLowerCase());
            statement.setDouble(3, workforce.getVatRate());
            statement.setInt(4, workforce.getProjectId());
            statement.setString(5, workforce.getWorkforceLevel().name().toLowerCase());
            statement.setDouble(6, workforce.getHourlyRate());
            statement.setDouble(7, workforce.getWorkHours());
            statement.setDouble(8, workforce.getProductivityCoefficient());
            statement.setInt(9, workforce.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Workforce workforce) {
        String query = "DELETE FROM workforce WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, workforce.getId());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
