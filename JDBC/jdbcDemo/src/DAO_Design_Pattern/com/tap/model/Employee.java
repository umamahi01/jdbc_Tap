package DAO_Design_Pattern.com.tap.model;

public class Employee {
    int empid,salary;
    String empname,department;
    Employee(){
        super();
    }
    public Employee(int empid, String empname, String department, int salary) {
        this.empid = empid;
        this.salary = salary;
        this.empname = empname;
        this.department = department;
    }
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getEmpname() {
        return empname;
    }
    public void setEmpname(String empname) {
        this.empname = empname;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employee [empid=" + empid + ", salary=" + salary + ", empname=" + empname + ", department=" + department
                + "]";
    }

    


}
