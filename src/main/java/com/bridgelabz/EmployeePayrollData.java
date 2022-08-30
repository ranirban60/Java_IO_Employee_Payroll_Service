package com.bridgelabz;

public class EmployeePayrollData {
    int id;
    String name;
    double salary;

    public EmployeePayrollData(int id, String name, double salary){
      this.id = id;
      this.name = name;
      this.salary = salary;
    }
    /**String class represents character String
     * @Override toString in class object
    */
    @Override
    public String toString(){
        return "Employee Id: "+id+", Employee Name: "+name+", Employee Salary: "+salary;
    }
}
