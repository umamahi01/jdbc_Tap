// import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
// import java.sql.DriverManager;

class Select_Data {
    public static void main(String [] args){
       Connection con =null;
       Statement stmt=null;
       ResultSet set_Result=null;

        int id,salary;
        String name,department;
       String query ="select * from employee";
       

       try{
        
        con = ClassConnector.connection();
      

        // System.out.println("Connection is established");
             stmt = con.createStatement();
            // set_Result= stmt.executeQuery("select * from employee");
            set_Result = stmt.executeQuery(query);
            
           
            while(set_Result.next()){
                id=set_Result.getInt(1);
            name = set_Result.getString(2);
            department = set_Result.getString(3);
            salary = set_Result.getInt(4);
                /* 1.way of displayig the data
                System.out.println(set_Result.getInt(1)+" "+set_Result.getString(2)+" "+set_Result.getString(3)+" "+set_Result.getInt(4));
               */
              /*2.second way of displaying the data
                System.out.println(id+" "+name+" "+department+" "+salary);
                */
                /* 3.third way of writing for formating the output in a neet manner use pformat*/
                 System.out.printf("%-3d %-19s %-19s %d\n",id,name,department,salary);
                 
                
               
            }
       }
       catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
       }
       finally{
        
        ClassConnector.connectionClose(set_Result,stmt,con);
        
       }


    }
}
