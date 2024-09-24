package console;

import dao.EstimateDAO;
import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class EstimateConsole {
    private final Connection connection = DBConnection.getConnection();
    private final EstimateDAO estimateDAO = new EstimateDAO(connection);
    private final Scanner scanner = new Scanner(System.in);

    public EstimateConsole() throws SQLException {
    }

}
