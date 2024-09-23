package tests;

import dao.ClientDAO;
import database.DBConnection;
import entities.Client;
import enums.ProjectStatus;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ClientDAOTest {
    public static void main(String[] args)throws Exception{
        Connection connection = DBConnection.getConnection();
        ClientDAO clientDAO = new ClientDAO(connection);
        Optional<Client> client = clientDAO.get(1);
        if (client.isPresent()) {
            System.out.println(client.get().toString());
        } else {
            System.out.println("Client not found");
        }

    }
}
