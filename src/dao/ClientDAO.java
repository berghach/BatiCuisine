package dao;

import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements DAO<Client>{
    private final Connection connection;

    public ClientDAO(Connection connection){
        this.connection = connection;
    }

    public Optional<Client> get(String name){

        String query = "SELECT * FROM client WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("adresse"),
                        rs.getString("phone"),
                        rs.getBoolean("is_professional")
                );
                return Optional.of(client);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }
    @Override
    public Optional<Client> get(long id) {
        String query = "SELECT * FROM client WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("adresse"),
                        rs.getString("phone"),
                        rs.getBoolean("is_professional")
                );
                return Optional.of(client);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        String query = "SELECT * FROM client";
        
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(query)){

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Client client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("adresse"),
                        rs.getString("phone"),
                        rs.getBoolean("is_professional")
                );
                
                clients.add(client);
            }

            return clients;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(Client client) {
        String query = "INSERT INTO client (name, adresse, phone, is_professional)" +
                        " VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getAdresse());
            statement.setString(3, client.getPhone());
            statement.setBoolean(4, client.isProfessional());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if insert was successful
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Client client) {
        String query = "UPDATE client SET name = ?, adresse = ?, phone = ?, is_professional = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getAdresse());
            statement.setString(3, client.getPhone());
            statement.setBoolean(4, client.isProfessional());
            statement.setInt(5, client.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if update was successful
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Client client) {
        String query = "DELETE FROM client WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if delete was successful
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
