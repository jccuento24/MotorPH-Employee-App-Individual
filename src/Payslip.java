/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
import java.io.*;
import java.util.ArrayList;

public class Payslip {

    private int payslipID;
    private String payPeriod;
    private double totalEarnings;
    private String totalDeductionsBreakdown;
    private double finalNetPay;

    public Payslip(int payslipID,
            String payPeriod,
            double totalEarnings,
            String totalDeductionsBreakdown,
            double finalNetPay) {

        this.payslipID = payslipID;
        this.payPeriod = payPeriod;
        this.totalEarnings = totalEarnings;
        this.totalDeductionsBreakdown = totalDeductionsBreakdown;
        this.finalNetPay = finalNetPay;
    
}
    public void generatePayslipPDF() {

        System.out.println("Payslip PDF generated.");
    }

    public void downloadPayslip() {

        System.out.println("Payslip downloaded successfully.");
    }
}
