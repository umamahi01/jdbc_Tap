/**updating(incrementing) the employee salary based on the department  only ,not by other parameters*/

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class UpdateData_BY_One_Parameter {
    public static void  main(String [] args){
        String url="jdbc:mysql://localhost:3306/jdbcexp";
        String userName ="root";
        String password ="root";

        Connection  con = null;
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);

        String query = "UPDATE employee set salary = salary+? where department =? ";
        
        System.out.println("enter the salary you want to increment");
        int incement_Of_Salary = sc.nextInt();
        sc.nextLine();
        System.out.println("which department salary is incrementing");
        String department = sc.nextLine();
        sc.close();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,userName,password);
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,incement_Of_Salary);
            pstmt.setString(2,department);
            System.out.println(pstmt.executeUpdate()+ " rows Effected");
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{
           try{
            if(pstmt != null){
                pstmt.close();
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
