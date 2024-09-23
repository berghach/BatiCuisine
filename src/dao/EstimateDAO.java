package dao;

import entities.Estimate;
import entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstimateDAO implements DAO<Estimate>{
    private final Connection connection;

    public EstimateDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Estimate> get(long id) {
        String query = "SELECT * FROM estimate WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                Estimate estimate = new Estimate(
                        rs.getDouble("amount"),
                        rs.getDate("issue_date"),
                        rs.getDate("validate_date"),
                        rs.getInt("project_id")
                );
                estimate.setAccepted(rs.getBoolean("is_accepted"));
                return Optional.of(estimate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Estimate> getAll() {
        String query = "SELECT * FROM estimate";

        List<Estimate> estimates = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Estimate estimate = new Estimate(
                        rs.getDouble("amount"),
                        rs.getDate("issue_date"),
                        rs.getDate("validate_date"),
                        rs.getInt("project_id")
                );
                estimate.setAccepted(rs.getBoolean("is_accepted"));
                estimates.add(estimate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estimates;
    }

    @Override
    public boolean save(Estimate estimate) {
        String query = "INSERT INTO estimate (amount, issue_date, validate_date, is_accepted, project_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, estimate.getAmount());
            statement.setDate(2, new java.sql.Date(estimate.getIssueDate().getTime()));
            statement.setDate(3, new java.sql.Date(estimate.getValidateDate().getTime()));
            statement.setBoolean(4, estimate.isAccepted());
            statement.setInt(5, estimate.getProjectId());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Estimate estimate) {
            String query = "UPDATE estimate SET amount = ?, issue_date = ?, validate_date = ?, is_accepted = ?, project_id = ? WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, estimate.getAmount());
                statement.setDate(2, new java.sql.Date(estimate.getIssueDate().getTime()));
                statement.setDate(3, new java.sql.Date(estimate.getValidateDate().getTime()));
                statement.setBoolean(4, estimate.isAccepted());
                statement.setInt(5, estimate.getProjectId());
                statement.setInt(6, estimate.getId());

                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public boolean delete(Estimate estimate) {
        String query = "DELETE FROM estimate WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, estimate.getId());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
