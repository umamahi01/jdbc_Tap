/* deleting data from database by taking user input id/placeholders  */



import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete_Data_InDataBase {
    public static void main(String [] args){
         Connection con = null;
         PreparedStatement pstmt = null;
         Scanner sc= new Scanner(System.in);
         String query = "delete from employee where empid =?";
         int id;
         try{
            con = ClassConnector.connection();
            pstmt  = con.prepareStatement(query);
            System.out.println("enter the id data  you want  to delete:");
            id = sc.nextInt();
            // pstmt.setInt(1, new Scanner(System.in).nextInt());
            pstmt.setInt(1, id);
            int  x = pstmt.executeUpdate();
            if( x!= 0){
                System.out.println("deleted "+x+" rows");
            }

            sc.close();

         }
         catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
         }
         finally{
            ClassConnector.connectionClose(pstmt,con);
         }



    }
}
