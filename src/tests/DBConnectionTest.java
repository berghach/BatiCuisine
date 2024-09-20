package tests;

import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {
    public static void main(String[] args)throws Exception{
        try {
            Connection connection = DBConnection.getConnection();
            System.out.println("Database connected successfully!");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
