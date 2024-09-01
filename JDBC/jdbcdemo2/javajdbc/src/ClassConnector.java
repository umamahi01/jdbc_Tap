 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

 class ClassConnector {
    private static String url="jdbc:mysql://localhost:3306/jdbcexp";
    private static String userName="root";
    private static String password="root";
    static Connection con;
 
    static Connection connection() throws ClassNotFoundException,SQLException {
        System.out.println("Connection is established");
        
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,userName,password);
            return con;
    }
    static void connectionClose(ResultSet set,Statement smt,Connection con){
        try{
            if(set!=null){
                set.close();
            }
            if(smt!=null){
                smt.close();
            }
            
            if(con!=null){
                con.close();
            }
            System.out.println("connection is closed");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
    static void connectionClose(Statement smt,Connection con){
        try{
            if(smt!=null){
                smt.close();
            }
            if(con!=null){
                con.close();

            }
           
            System.out.println("Connection closed");
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //close();
    //insert place holders
    //update place holders
    static void conenctionClose(PreparedStatement pstmt,Connection con){
        try{
            if(pstmt!=null){
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
    //close();
    //fetch place holders
    static void conenctionClose( ResultSet set,PreparedStatement pstmt,Connection con){
        try{
            if(set!=null){
                set.close();
            }
            if(pstmt!=null){
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




