/**what you want to update take user input based  on which ? */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
public class Update_Data_ByTaking_UserInput {
    static private String url="jdbc:mysql://localhost:3306/uni";
    static private  String username="root";
    static private String password="root";
    Connection con=null;
    PreparedStatement pst = null;
   static  Statement stmt = null;
    Scanner sc=null;
    static ResultSet res = null;
    static ResultSetMetaData restd = null;
   static  String query ="select * from student_data";


    public static void main(String []args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            restd = res.getMetaData();
            int x = restd.getColumnCount();
            System.out.println("number of columns are:-"+x);
            System.out.println("which student details do you want  to update");
            
           
           System.out.printf("%-10s | %-10s\n",restd.getColumnName(1),restd.getColumnName(2));
            
            while(res.next()){
                System.out.printf("%-10d | %-10s\n",res.getInt(1),res.getString(2));
                }
            System.out.println();
            


        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally{

        }



    }
    
}
