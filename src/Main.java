/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class Main {

    public static void main(String[] args) {

        FileHandler.loadEmployees("employees.csv");
        FileHandler.loadAttendance("attendance.csv");

        new MotorPHEmployeeGUI();
    }
}
