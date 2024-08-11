/*cloumns names and description of coulmn is only called as meta data */


package Batch_Inser;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class MetaData{
    static final String  URL = "jdbc:mysql://localhost:3306/myntra";
      static final  String USERNAME="root";
       static final  String PASSWORD="root";
       
    public static void main(String [] args){
        Connection con= null;
        Statement stmt =null;
        ResultSet  res =null;
        ResultSetMetaData metaData= null;
        String query="select * from user";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            stmt = con.createStatement();
             res =stmt.executeQuery(query);
             metaData = res.getMetaData();
             int x = metaData.getColumnCount();
             System.out.println("No. of columns = "+x);

             for(int i=1;i<=x;i++){
                System.out.println("column number:- "+i+"\n\t"+"column name:- "+metaData.getColumnName(i)+"\n\t"+"column type:- "+"\n\t"+metaData.getColumnType(i)+"\n\t"+"column type name:- "+metaData.getColumnTypeName(i)+"\n\t"+"is nullable:- "+((metaData.isNullable(i)==1)?"yes":"No")+"\n\t"+"is AutoIncrement:- "+((metaData.isAutoIncrement(i)== false)?"No":"yes")+"\n\n");
             }

             
           
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally{

        }


    }
}