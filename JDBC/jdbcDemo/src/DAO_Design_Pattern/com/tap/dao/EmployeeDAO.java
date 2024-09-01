package DAO_Design_Pattern.com.tap.dao;
import DAO_Design_Pattern.com.tap.model.Employee;
import java.util.List;


//public abstract methods
public interface EmployeeDAO {

        int insertEmp(Employee e);
        int deleteEmp(int empid);
        List<Employee> fetchAll(int id);
        Employee fetchEmp(int id);
        int updateOnId(int id,int salary);
    
}