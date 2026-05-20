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

public class FileHandler {

    public static ArrayList<Employee> employeeList
            = new ArrayList<>();

    public static ArrayList<String[]> attendanceList
            = new ArrayList<>();

    public static void loadEmployees(String filePath) {

        try {

            BufferedReader bufferedReader
                    = new BufferedReader(new FileReader(filePath));

            bufferedReader.readLine();

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                String employeeID = data[0];
                String lastName = data[1];
                String firstName = data[2];
                String birthDate = data[3];

                double basicSalary = 0;

                try {

                    String salaryText = data[13]
                            .replace("\"", "")
                            .replace(",", "")
                            .trim();

                    if (!salaryText.equalsIgnoreCase("N/A")
                            && !salaryText.isEmpty()) {

                        basicSalary = Double.parseDouble(salaryText);
                    }

                } catch (NumberFormatException exception) {

                    basicSalary = 0;
                }

                Employee employee = new Employee(
                        employeeID,
                        lastName,
                        firstName,
                        birthDate,
                        "Batangas",
                        912345678,
                        "Employee",
                        basicSalary,
                        "Regular",
                        firstName.toLowerCase() + "@motorph.com",
                        "2020-01-01",
                        "Operations"
                        );

                employeeList.add(employee);
            }

            bufferedReader.close();

        } catch (IOException exception) {

            System.out.println("Error reading employees.csv file.");
        }
    }

    public static void loadAttendance(String filePath) {

        try {

            BufferedReader bufferedReader
                    = new BufferedReader(new FileReader(filePath));

            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");

                attendanceList.add(data);
            }

            bufferedReader.close();

        } catch (IOException exception) {

            System.out.println("Error reading attendance.csv file.");
        }
    }
}
