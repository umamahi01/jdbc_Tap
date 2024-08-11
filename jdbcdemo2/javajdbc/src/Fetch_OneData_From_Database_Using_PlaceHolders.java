import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Fetch_OneData_From_Database_Using_PlaceHolders {
    public static void main(String [] args){
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet set_Result=null;
        Scanner sc= new Scanner(System.in);
        String query="select * from employee where empid=?";
        try{
            con = ClassConnector.connection();
            pstmt = con.prepareStatement(query);
            System.out.println("enter employee_id:");
            int id = sc.nextInt();
            pstmt.setInt(1,id);
            set_Result = pstmt.executeQuery();
            while(set_Result.next()){
                if(id == set_Result.getInt(1)){
                    System.out.println(set_Result.getInt(1)+" "+set_Result.getString(2)+" "+set_Result.getString(3)+" "+set_Result.getInt(4));
                }
                else {
                    System.out.println("data not present of that "+id);
                }
            }

            sc.close();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{ 
            ClassConnector.connectionClose(set_Result,pstmt,con);
        }

    }
    
}
