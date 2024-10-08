import java.sql.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.io.FileInputStream;
public class App {
    private static Connection con;
    private static PreparedStatement pstmt;
    static Scanner sc = new Scanner(System.in);
    private static PreparedStatement pstmt2;

    public static void main(String[] args) {
        
        try {
            File file = new File("D:\\Apr24\\java\\Advanced_java\\BlobAndClob\\images\\empOne.jpeg");
            FileInputStream fir = new FileInputStream(file);
            File file2 = new File("D:\\Apr24\\java\\Advanced_java\\BlobAndClob\\lib\\text.txt");
            FileReader fir2 = new FileReader(file2);
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexp","root","root");
            con.setAutoCommit(false);
            pstmt = con.prepareStatement("update  employee set empImg =? where empid=?");
            System.out.print("enter the id");
            int id=sc.nextInt();
            pstmt.setInt(2,id);
            pstmt.setBinaryStream(1,fir);
           int x= pstmt.executeUpdate();

            pstmt2= con.prepareStatement("update employee set about=? where empid=?");

           
            pstmt2.setInt(2,id);
            pstmt2.setCharacterStream(1,fir2);
           int y= pstmt2.executeUpdate();
          
               
             System.out.println(x+x>0&&y>0?"succuess":"not updated");
            con.commit();



        } catch (FileNotFoundException|ClassNotFoundException|SQLException e) {
            
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmt2 != null){
                    pstmt2.close();
                }
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
        }
    }
    

}

