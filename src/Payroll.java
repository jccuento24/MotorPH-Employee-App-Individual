/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class Payroll {

    private int payrollID;
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;
    private String payPeriodStart;
    private String payPeriodEnd;
    private double overtimePay;

    private Deduction deduction;

    public Payroll() {

        deduction = new Deduction();
    }

    public double computeGrossSalary(double hoursWorked,
            double hourlyRate) {

        grossSalary = hoursWorked * hourlyRate;

        return grossSalary;
    }
    public double computeTotalDeductions(double grossSalary) {

        double sss = deduction.calculateSSS(grossSalary);
        double philhealth = deduction.calculatePhilhealth(grossSalary);
        double pagibig = deduction.calculatePagibig(grossSalary);

        double taxableIncome = grossSalary
                - (sss + philhealth + pagibig);

        double tax = deduction.calculateWithholdingTax(taxableIncome);

        totalDeductions = sss + philhealth + pagibig + tax;

        return totalDeductions;
    }

    public double computeNetSalary(double grossSalary,
            double totalDeductions) {

        netSalary = grossSalary - totalDeductions;

        return netSalary;
}
    public void generatePayslip() {

        System.out.println("Payslip generated successfully.");
    }
}
