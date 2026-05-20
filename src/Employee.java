/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class Employee {

    private String employeeID;
    private String employeeLastName;
    private String employeeFirstName;
    private String birthDate;
    private String address;
    private int contactNumber;
    private String position;
    private double basicSalary;
    private String employmentStatus;
    private String email;
    private String dateHired;
    private String department;

    public Employee(String employeeID,
            String employeeLastName,
            String employeeFirstName,
            String birthDate,
            String address,
            int contactNumber,
            String position,
            double basicSalary,
            String employmentStatus,
            String email,
            String dateHired,
            String department) {

        this.employeeID = employeeID;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.birthDate = birthDate;
        this.address = address;
        this.contactNumber = contactNumber;
        this.position = position;
        this.basicSalary = basicSalary;
        this.employmentStatus = employmentStatus;
        this.email = email;
        this.dateHired = dateHired;
        this.department = department;
    }

    public void viewProfile() {

        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + employeeFirstName + " " + employeeLastName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
    }

    public void updateInformation(String address,
            int contactNumber,
            String email) {

        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public String getDepartment() {
        return department;
    }
}
