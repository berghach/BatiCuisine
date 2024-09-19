/**
 * PostgreSQLConnection
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/baticuisine";
        String user = "postgres";
        String password = "post2001";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to PostgreSQL database!");
            } else {
                System.out.println("Failed to connect.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}