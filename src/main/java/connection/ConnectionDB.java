package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection connect() {
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/boardinghouse";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection =  DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load database driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }

        return connection;
    }
}