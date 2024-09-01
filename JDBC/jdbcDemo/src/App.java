

// import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String url="jdbc:mysql://localhost:3306/jdbcexp";
            String username ="root";
            String password="root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("driver loaded succesfully");
           DriverManager.getConnection(url, username, password);
           System.out.println("connection is established");
        }
        catch(ClassNotFoundException e){
            System.out.println("driver is not loaded");

        }
        catch(SQLException e){
           
            System.out.println("connection is  not established");
            e.printStackTrace();
        }
    }
}
