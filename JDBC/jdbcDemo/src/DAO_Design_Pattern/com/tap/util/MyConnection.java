package DAO_Design_Pattern.com.tap.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private MyConnection(){

    }
    private static MyConnection connection = new MyConnection();
    public static MyConnection getConnection(){
        return connection;
    }

    public  Connection connectToDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexp","root","root");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
