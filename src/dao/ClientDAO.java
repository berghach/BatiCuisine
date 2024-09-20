package dao;

import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements DAO<Client>{
    private Connection connection;

    public ClientDAO(Connection connection){
        this.connection = connection;
    }

    public Optional<Client> get(String name){

        String query = "SELECT * FROM client WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Client client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("adresse"),
                        resultSet.getString("phone"),
                        resultSet.getBoolean("is_professional")
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

        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Client client) {
        return false;
    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }
}
