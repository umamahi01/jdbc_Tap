/** update the data of dev departement by 5000(increment their salary) using createStatement(without taking userIntput) */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Update_Data_ToDataBase {
    private static String url="jdbc:mysql://localhost:3306/jdbcexp";
        private static String userName = "root";
        private static String password ="root";
         static Connection con =null;
         static Statement stmt = null;
    public static void main(String [] args){
        String query="UPDATE  `employee` set `salary`= `salary`+5000 where `department`= 'dev' ";
      
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
            stmt = con.createStatement();
            int x = stmt.executeUpdate(query);
           if(x !=0){
            System.out.println(x+" rows effected");
            System.out.println("Updated Succesfully");
           }
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
        finally{
            try{
                if(stmt!= null){
                    stmt.close();
                }
                if(con!= null){
                    con.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

    }
    
}
