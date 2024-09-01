/*
 * Inserting data into database without using/taking user input
 */

import java.sql.SQLException;
import java.sql.Connection;
// import java.sql.ResultSet;
import java.sql.Statement;
class Insert_Data_One {
    static Connection con=null;
    static Statement stmt =null;
    // static ResultSet  set_Result = null;
    public static void main(String [] args){
        String query= "insert into employee (empid,empname,department,salary) values(12,'null','null',null)";
        // String query="";
        try{
            con = ClassConnector.connection();
            stmt = con.createStatement();
            int x = stmt.executeUpdate(query);
            // System.out.println("no of rows "+x+ " effected");
            if(x!=0){
                System.out.println("data inserted succesfully");
            }
            else if(x == 0){
                System.out.println("data is not given");
            }

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{
            ClassConnector.connectionClose(stmt,con);
        }
    }
}
