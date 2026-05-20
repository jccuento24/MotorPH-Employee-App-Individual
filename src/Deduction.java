/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
public class Deduction {

    private int deductionID;
    private double sssDeduction;
    private double philhealthDeduction;
    private double pagibigDeduction;
    private double withholdingTaxDeduction;

    public double calculateSSS(double salary) {

        if (salary <= 3250) {
            return 135;
        } else if (salary <= 3750) {
            return 157.50;
        } else if (salary <= 4250) {
            return 180;
        } else {
            return 1125;
        }
    }
    public double calculatePhilhealth(double salary) {

        double premium;

        if (salary <= 10000) {
            premium = 300;
        } else if (salary < 60000) {
            premium = salary * 0.03;
        } else {
            premium = 1800;
        }

        return premium / 2;
    }

    public double calculatePagibig(double salary) {

        double contribution;

        if (salary <= 1500) {
            contribution = salary * 0.01;
        } else {
            contribution = salary * 0.02;
        }
        if (contribution > 100) {
            contribution = 100;
        }

        return contribution;
    }

    public double calculateWithholdingTax(double taxableIncome) {

        if (taxableIncome <= 20833) {
            return 0;
        }

        if (taxableIncome <= 33333) {
            return (taxableIncome - 20833) * 0.20;
        }

        return (taxableIncome - 33333) * 0.25 + 2500;
    }

    public void updateRate() {

        System.out.println("Deduction rates updated.");
    }
}
