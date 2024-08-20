
/**transcation aof amount from one account to another account using ACID properties  */

package Batch_Insert;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Transaction {
    private static String  url="jdbc:mysql://localhost:3306/jdbcexp";
    private static String userName ="root";
    private static String password="root";
    private static int pin = 1212;
    static Connection con =null;
    static PreparedStatement pstmt_s= null;
    static PreparedStatement pstmt_r= null;
    static Scanner sc =new Scanner(System.in); 
    public static void main(String[] args){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
            con.setAutoCommit(false);
            String sendQuery ="update bank set balance = balance-? where id = ?";
            String receiveQuery ="update bank set balance= balance+? where id=?";
            System.out.println("enter the sender uid:- ");
            int s_uid= sc.nextInt();
           
            System.out.println("enter the amount you want to send:-");
            int amount = sc.nextInt();
            pstmt_s = con.prepareStatement(sendQuery);
            pstmt_r =con.prepareStatement(receiveQuery);


            pstmt_s.setInt(1,amount);
            pstmt_s.setInt(2,s_uid);
            int n1 =pstmt_s.executeUpdate();
            System.out.println(n1+ " sending money");


            System.out.println("enter the receiver id:- ");
            int r_uid = sc.nextInt();
            pstmt_r.setInt(1,amount);
            pstmt_r.setInt(2, r_uid);
           int  n2 =pstmt_r.executeUpdate();
            System.out.println(n2+"money recieved");
            System.out.println("enter pin:-");
            if(pin == sc.nextInt()&& n1==1&& n2==1){
                con.commit();
                System.out.println("transaction successfull");
            }
            else{
                con.rollback();
                System.out.println("transaction failed");
            }


        }
        catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
        }
        finally{
            try{
                sc.close();
                if(pstmt_s!= null){
                    pstmt_s.close();
                }
                if(pstmt_r!=null){
                    pstmt_r.close();
                }
                if(con!=null){
                    con.close();
                }
               
            }
            catch(SQLException e){
                    e.printStackTrace();
            }

        }
    }
}
