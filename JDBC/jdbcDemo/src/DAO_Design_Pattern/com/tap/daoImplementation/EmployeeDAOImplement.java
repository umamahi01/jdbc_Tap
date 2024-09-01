package DAO_Design_Pattern.com.tap.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DAO_Design_Pattern.com.tap.dao.EmployeeDAO;
import DAO_Design_Pattern.com.tap.model.Employee;
import DAO_Design_Pattern.com.tap.util.MyConnection;

public class EmployeeDAOImplement implements EmployeeDAO {
    private  MyConnection con ;
    private Connection connection;
    private PreparedStatement pstmt;
    public EmployeeDAOImplement(){
        con = MyConnection.getConnection();
        connection  = con.connectToDatabase();
    }

    @Override
    public int insertEmp(Employee e) {
        try {
            pstmt = connection.prepareStatement("insert into employee (empid,empname,department,salary) values(?,?,?,?)");
            pstmt.setInt(1,e.getEmpid());
            pstmt.setString(2, e.getEmpname());
            pstmt.setString(3,e.getDepartment());
            pstmt.setInt(4,e.getSalary());

            return pstmt.executeUpdate();

        } catch (SQLException e1) {
            
            e1.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmp(int empid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmp'");
    }

    @Override
    public List<Employee> fetchAll(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchAll'");
    }

    @Override
    public Employee fetchEmp(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchEmp'");
    }

    @Override
    public int updateOnId(int id, int salary) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOnId'");
    }
    
}
