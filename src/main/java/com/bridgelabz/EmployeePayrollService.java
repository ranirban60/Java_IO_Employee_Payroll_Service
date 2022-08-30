package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    List<EmployeePayrollData> employeePayrollDataList;
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList){
        this.employeePayrollDataList = employeePayrollDataList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData();
    }
    /**
     * This method reads the data from user
     * @param consoleInputReader input from console
     */
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }
    /**
     * This method writes the user data in console
     */
    private void writeEmployeePayrollData() {
        System.out.println("\n Writing Employee Payroll Roaster to Console \n" +employeePayrollDataList);
    }
}
