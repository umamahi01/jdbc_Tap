package DAO_Design_Pattern.com.tap.main;
import DAO_Design_Pattern.com.tap.daoImplementation.EmployeeDAOImplement;
import DAO_Design_Pattern.com.tap.model.Employee;
public class demo {
    public static void main(String [] args){
        int empid=13,salary=8000;
        String empname="ravi",department="sales";
        Employee e = new Employee(empid, empname, department,salary);
        EmployeeDAOImplement obj = new EmployeeDAOImplement();
        System.out.println("status:- "+obj.insertEmp(e));
    }
}
