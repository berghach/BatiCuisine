package tests;

import dao.ClientDAO;
import database.DBConnection;
import entities.Client;

import java.sql.Connection;
import java.util.Optional;

public class ClientDAOTest {
    public static void main(String[] args)throws Exception{
        Connection connection = DBConnection.getConnection();
        ClientDAO clientDAO = new ClientDAO(connection);
        Optional<Client> client = clientDAO.get("John Doe");
        System.out.println(client);
    }
}
