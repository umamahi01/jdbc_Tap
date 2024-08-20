package Stored_Procedure;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.sql.Types;
//call an existing procedure in the database

class Stored_Procedure {
    private static Connection con;
    private static CallableStatement prepareCall;
    static Scanner sc = new Scanner(System.in) ;
    public static void main(String [] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/procedure_triggers","root","root");
            prepareCall= con.prepareCall("{call get_Count_Of_Employes(?,?)}");
            System.out.println("Enter the department id:- ");
            int dept_id = sc.nextInt();
            prepareCall.setInt(1,dept_id);

            prepareCall.registerOutParameter(2,Types.INTEGER);
            prepareCall.execute();
            int x = prepareCall.getInt(2);
            System.out.println("no of employees in dep  "+dept_id+"has "+x);
            prepareCall = con.prepareCall("{call get_Salariescount_Greater(?,?)}");
            System.out.println("Enter the salary:-");
            int  salary = sc.nextInt();
            prepareCall.setInt(1,salary);
            prepareCall.registerOutParameter(2,Types.INTEGER);
            prepareCall.execute();
             x = prepareCall.getInt(2);
             System.out.println("these many persons are there with this salary:-"+x);

           
        }
        catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        finally{

        }
    }
}   
