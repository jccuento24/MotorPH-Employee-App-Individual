/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class AttendanceRecord {

    private int attendanceID;
    private int workDate;
    private double timeIn;
    private double timeOut;
    private double overtimeHours;
    private double totalHoursWorked;

    public AttendanceRecord(int attendanceID,
            int workDate,
            double timeIn,
            double timeOut) {

        this.attendanceID = attendanceID;
        this.workDate = workDate;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    
}
    public void recordTimeIn(double timeIn) {
        this.timeIn = timeIn;
    }

    public void recordTimeOut(double timeOut) {
        this.timeOut = timeOut;
    }

    public double calculateTotalHours() {

        totalHoursWorked = timeOut - timeIn;

        if (totalHoursWorked > 4) {
            totalHoursWorked = totalHoursWorked - 1;
        }

        return totalHoursWorked;
    }

    public void recordWorkDay() {

        System.out.println("Attendance recorded successfully.");
    }
}

