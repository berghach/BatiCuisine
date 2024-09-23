package dao;

import entities.Client;
import entities.Project;
import enums.ProjectStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectDAO implements DAO<Project>{
    private final Connection connection;

    public ProjectDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Project> get(long id) {
        String query = "SELECT p.id AS project_id, p.name AS project_name, p.kitchen_surface, p.profit_margin, " +
                "p.vat_rate, p.total_price, p.project_stat, c.id AS client_id, c.name AS client_name, " +
                "c.adresse, c.phone, c.is_professional " +
                "FROM project p JOIN client c ON p.client_id = c.id WHERE p.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Client client = new Client(
                        rs.getInt("client_id"),
                        rs.getString("client_name"),
                        rs.getString("adresse"),
                        rs.getString("phone"),
                        rs.getBoolean("is_professional")
                );

                Project project = new Project(
                        rs.getInt("project_id"),
                        rs.getString("project_name"),
                        rs.getDouble("kitchen_surface"),
                        rs.getDouble("profit_margin"),
                        rs.getDouble("vat_rate"),
                        rs.getDouble("total_price"),
                        ProjectStatus.fromString(rs.getString("project_stat")),
                        client
                );

                project.setStatus(ProjectStatus.valueOf(rs.getString("project_stat")));

                return Optional.of(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Project> getAll() {
        String query = "SELECT p.id AS project_id, p.name AS project_name, p.kitchen_surface, p.profit_margin, " +
                "p.vat_rate, p.total_price, p.project_stat, c.id AS client_id, c.name AS client_name, " +
                "c.adresse, c.phone, c.is_professional " +
                "FROM project p JOIN client c ON p.client_id = c.id";

        List<Project> projects = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("client_id"),
                        rs.getString("client_name"),
                        rs.getString("adresse"),
                        rs.getString("phone"),
                        rs.getBoolean("is_professional")
                );

                Project project = new Project(
                        rs.getInt("project_id"),
                        rs.getString("project_name"),
                        rs.getDouble("kitchen_surface"),
                        rs.getDouble("profit_margin"),
                        rs.getDouble("vat_rate"),
                        rs.getDouble("total_price"),
                        ProjectStatus.fromString(rs.getString("project_stat")),
                        client
                );

                project.setStatus(ProjectStatus.valueOf(rs.getString("project_stat")));

                projects.add(project);
            }

            return projects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Project project) {
        String query = "INSERT INTO project (name, kitchen_surface, profit_margin, vat_rate, total_price, project_stat, client_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, project.getName());
            statement.setDouble(2, project.getKitchenSurface());
            statement.setDouble(3, project.getProfitMargin());
            statement.setDouble(4, project.getVatRate());
            statement.setDouble(5, project.getTotalPrice());
            statement.setString(6, project.getStatus().name());
            statement.setInt(7, project.getClient().getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Project project) {
        String query = "UPDATE project SET name = ?, kitchen_surface = ?, profit_margin = ?, vat_rate = ?, total_price = ?, project_stat = ?, client_id = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, project.getName());
            statement.setDouble(2, project.getKitchenSurface());
            statement.setDouble(3, project.getProfitMargin());
            statement.setDouble(4, project.getVatRate());
            statement.setDouble(5, project.getTotalPrice());
            statement.setString(6, project.getStatus().name());
            statement.setInt(7, project.getClient().getId());
            statement.setInt(8, project.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Project project) {
        String query = "DELETE FROM project WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, project.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
