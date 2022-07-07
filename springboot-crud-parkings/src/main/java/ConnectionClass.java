import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static void main(String[] args) { 
        final String url = "jdbc:mysql://localhost:3306/parkingdb";
        final String username = "admin";
        final String password = "password"; 
        
        try {
            DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the db"); 
        } catch (SQLException e) {
            System.out.println("Unsuccessful connection");
            e.printStackTrace();
        }
        
    }

}
