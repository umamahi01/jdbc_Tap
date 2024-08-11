package Batch_Inser;

/*batch update /inserting into database using peraperdStatemet _refernce .addBatch(); ==> add number of queries into batch 
    preapredStatement_reference.executeBatch(); ==> exceute the bactched Querirs;
 * 
 */



import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Update_Into_DataBase {
    public static void main(String[] args){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbcexp";
        String userName = "root";
        String password ="root";
        Connection con=null;
        PreparedStatement pstmt =null;
        String query = "Insert into employee (empid,empname,department,salary) values(?,?,?,?)";
        int empid ,salary,sum=0;
        String empname,department,ch="y";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
            pstmt = con.prepareStatement(query);

         while(ch.equalsIgnoreCase("y")){
            System.out.println("enter employee_id");
            empid = sc1.nextInt();
            System.out.println("enter employee_name");
            empname = sc2.nextLine();
            System.out.println("enter department");
            department = sc2.nextLine();
            System.out.println("enter the salary");
            salary = sc1.nextInt();

            pstmt.setInt(1,empid);
            pstmt.setString(2,empname);
            pstmt.setString(3,department);
            pstmt.setInt(4,salary);

            System.out.println("want to insert more data(enter y/n):-");
            ch = sc2.nextLine();
            pstmt.addBatch();
        }
         int batchUpdateCount [] =pstmt.executeBatch();
         for(int i=0;i<batchUpdateCount.length;i++){
            sum += batchUpdateCount[i];
         }

           System.out.println( sum+" rows effected");
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }
        finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                if(con != null){
                    con.close();
                }
                
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            sc1.close();
            sc2.close();
        }

        

    }
}
