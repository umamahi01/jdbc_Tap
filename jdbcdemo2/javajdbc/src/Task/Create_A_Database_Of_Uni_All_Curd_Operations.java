package Task;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 1.show data ----> show all data (select * from table)
 * 2.show specific data ----> fetch only specific student data using student id (select * from student_data where id=5);
 * 3.register user ---> insert new data into table
 * 4.delete user ------> 
 * 5.modify user ---> update data using id
 * 6.exit   ---> exit the application
 */

public class Create_A_Database_Of_Uni_All_Curd_Operations {
    static Connection con = null;
    static PreparedStatement pstmt = null;
    static Statement stmt = null;
    static ResultSet set_Result = null;
    static String url ="jdbc:mysql://localhost:3306/uni";
    static String userName ="root";
    static String password = "root";
    static Scanner sc1 = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
   
   //show all data from the database
    public static  void showdata(Connection con ){
        int id,phone_Number;
        String name,email,address,branch,state;
        String query="select * from student_data";
       
        try{
              stmt =con.createStatement();
              set_Result = stmt.executeQuery(query);
              while(set_Result.next()){
                id = set_Result.getInt(1);
                name = set_Result.getString(2);
                email = set_Result.getString(3);
                address = set_Result.getString(4);
                phone_Number = set_Result.getInt(5);
                branch = set_Result.getString(6);
                state = set_Result.getString(7);
    
                System.out.printf(" %-2d %-10s %-20s %-10s %-10d %-10s %-10s \n",id,name,email,address,phone_Number,branch,state);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
           
        }
      
    }

   
   
   
   //insert data into database
    public static int insert_Data(Connection con,int id,String name,String email,String address,int phone_Number,String branch,String state){
        String query ="insert into student_data (student_id,name,email,address,phone_number,branch,state) values(?,?,?,?,?,?,?) ";
        int x=0;
        try{
            
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3, email);
            pstmt.setString(4,address);
            pstmt.setInt(5,phone_Number);
            pstmt.setString(6,branch);
            pstmt.setString(7,state);
             x= pstmt.executeUpdate();
          
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return x;
    }

    //fecth one user
    public static void fect_Single_Data_By_Id(Connection con){
        String query ="select * from student_data where student_id =?";
        try{
            pstmt = con.prepareStatement(query);
            System.out.println("enter id of the student:-");
            pstmt.setInt(1,sc1.nextInt());

           set_Result= pstmt.executeQuery();
           
           while(set_Result.next()){
                System.out.println(set_Result.getInt(1)+" "+set_Result.getString(2)+" "+set_Result.getString(3)+" "+set_Result.getString(4)+" "+
                set_Result.getInt(5)+" "+set_Result.getString(6)+" "+set_Result.getString(7));
           }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

     }

     //delete the record
     public static int delete_record(Connection con,int id){
            String query  = "delete from student_data where id=?";
            int x=0;
            try{
                pstmt = con.prepareStatement(query);
                System.out.print("enter the id of student :- ");
                pstmt.setInt(1,sc1.nextInt());
                
                x =pstmt.executeUpdate();
            }
            catch(SQLException e){
                e.printStackTrace();
            }

            return x;
        }

        //update the record
        public static void updated_The_Records(Connection con){
            String query="update student_data set ?=?  where id=? ";
            String name,address,state,branch,email; 
            int phone_Number;
           int x=0;
            

            System.out.println("which record do you want to update:-\n 1.name\n2.email\n3.address\n4.phoneNumber\n5.branch\n6.state");
            int choice =sc1.nextInt();
            try{
                pstmt= con.prepareStatement(query);
                switch (choice) {
                    case 1:
                        // pstmt.setString(1, name);
                        System.out.print("enter new name:- ");
                        pstmt.setString(2, sc2.nextLine());
                        x = pstmt.executeUpdate();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("enter proper option");
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

   public static void main(String [] args) {
      
    int id,phone_Number;
    String name,email,address,branch,state;
    id = sc1.nextInt();
    name = sc2.nextLine();
    email = sc2.nextLine();
    address = sc2.nextLine();
    phone_Number = sc1.nextInt();
    branch = sc2.nextLine();
    state = sc2.nextLine();
        int x=0;
        int choice =0;
       

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,userName,password);

        //1. insert data
                x = insert_Data(con,id,name,email,address,phone_Number,branch,state);
                System.out.println(x+ "rows effected");
        //2.show data
            showdata(con);
       
        //3.fetch specific data by id;
            fect_Single_Data_By_Id(con);

        //4.delete record
           System.out.println( delete_record(con,id)+ "rows deleted");

        //5.update the records
            updated_The_Records(con);

    }
    catch(ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }
    finally{
        sc1.close();
        sc2.close();

    }
    


   }
}
