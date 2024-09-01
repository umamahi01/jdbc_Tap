import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.PreparedStatement;


class Insert_Into_DataBase_Two_UserInput {
    

    public static void main(String [] args){
        Connection con=null;
        // Statement stmt;
        PreparedStatement pstmt=null;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int id,salary;
        String name,department;
        String query= "insert into employee(empid,empname,department,salary) values(?,?,?,?)";
        try{
            con = ClassConnector.connection();
            System.out.println("enter id:-");
            id = sc1.nextInt();
            System.out.println("enter name:-");
            name = sc2.nextLine();
            System.out.println("enter department:-");
            department = sc2.nextLine();
            System.out.println("enter salary:-");
            salary = sc1.nextInt();
            // stmt = con.createStatement();
            //if the same sql query/statement is executing many times it is better to use prepare statement
            //preparedstatement takes sql statement of one or more ?(placeholders)  which is incomplete sql query
            //returns prepared statement object which precompiled sql query;
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.setString(3,department);
            pstmt.setString(2,name);
            pstmt.setInt(4,salary);
            
            int x = pstmt.executeUpdate();
            System.out.println(x+" rows effected");
            sc1.close();
            sc2.close();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{
            ClassConnector.connectionClose(pstmt,con);
        }
    }
    
}
