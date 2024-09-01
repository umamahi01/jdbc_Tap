import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
//connection to database
public class App {
    public static void main(String[] args) throws Exception {
        Connection con=null;
        System.out.println("Hello, World!");
        String url = "jdbc:mysql://localhost:3306/jdbcexp";
        String username = "root";
        String password ="root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully");
           con= DriverManager.getConnection(url, username, password);
            System.out.println("database connected successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println("driver not loaded");
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        finally{
            con.close();
        }
    }
}
