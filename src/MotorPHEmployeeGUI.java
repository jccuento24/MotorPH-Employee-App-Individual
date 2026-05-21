/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public final class MotorPHEmployeeGUI extends JFrame
        implements ActionListener {

    JLabel titleLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;

    JTextField usernameField;
    JPasswordField passwordField;

    JButton loginButton;
    JButton logoutButton;

    JTextArea displayArea;

    JTable employeeTable;

    JScrollPane scrollPane;

    JPanel loginPanel;
    JPanel dashboardPanel;
    
    UserAccount[] accounts;

    public MotorPHEmployeeGUI() {

        createAccounts();
        initializeFrame();
        initializeComponents();
        buildLoginPanel();

        setVisible(true);
    }

    public void initializeFrame() {

        setTitle("MotorPH Employee App");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
    }

    public void initializeComponents() {

        titleLabel = new JLabel("MotorPH Employee App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");
        logoutButton = new JButton("Logout");

        loginButton.addActionListener(this);
        logoutButton.addActionListener(this);

        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);

        scrollPane = new JScrollPane(displayArea);
    }

    public void buildLoginPanel() {

        loginPanel = new JPanel();

        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints design = new GridBagConstraints();

        design.insets = new Insets(10, 10, 10, 10);

        design.anchor = GridBagConstraints.WEST;

        // TITLE
        design.gridx = 0;
        design.gridy = 0;
        design.gridwidth = 2;

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        loginPanel.add(titleLabel, design);

        // USERNAME LABEL
        design.gridx = 0;
        design.gridy = 1;
        design.gridwidth = 1;

        loginPanel.add(usernameLabel, design);

        // USERNAME TEXTFIELD
        design.gridx = 1;
        design.gridy = 1;

        usernameField.setPreferredSize(new Dimension(200, 30));

        loginPanel.add(usernameField, design);

        // PASSWORD LABEL
        design.gridx = 0;
        design.gridy = 2;

        loginPanel.add(passwordLabel, design);

        // PASSWORD FIELD
        design.gridx = 1;
        design.gridy = 2;

        passwordField.setPreferredSize(new Dimension(200, 30));

        loginPanel.add(passwordField, design);

        // LOGIN BUTTON
        design.gridx = 1;
        design.gridy = 3;

        loginButton.setPreferredSize(new Dimension(120, 35));

        loginPanel.add(loginButton, design);

        add(loginPanel);
    }

    public void buildDashboard(UserAccount currentAccount) {

        dashboardPanel = new JPanel();

        dashboardPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        JLabel roleLabel = new JLabel(
                "Logged in as: "
                + currentAccount.getUserRole()
        );

        topPanel.add(roleLabel);

        logoutButton = new JButton("Logout");

        logoutButton.addActionListener(this);

        topPanel.add(logoutButton);

        dashboardPanel.add(topPanel,
                BorderLayout.NORTH);

        // =================================================
        // EMPLOYEE ACCESS
        // =================================================
        if (currentAccount.getUserRole().equals("Employee")) {

            JPanel employeePanel = new JPanel();

            employeePanel.setLayout(new GridLayout(10,
                    1,
                    10,
                    10));

            String username = currentAccount.getUsername();

            Employee loggedEmployee = null;

            for (Employee employee : FileHandler.employeeList) {

                String generatedUsername
                        = employee.getEmployeeLastName()
                                .toLowerCase()
                        + employee.getEmployeeID();

                if (generatedUsername.equals(username)) {

                    loggedEmployee = employee;

                    break;
                }
            }
            
            final Employee employeeData = loggedEmployee;

            JLabel employeeInfo = new JLabel(
                    "<html>"
                    + "<h2>Employee Information</h2>"
                    + "Employee ID: "
                    + loggedEmployee.getEmployeeID()
                    + "<br>"
                    + "Name: "
                    + loggedEmployee.getEmployeeFirstName()
                    + " "
                    + loggedEmployee.getEmployeeLastName()
                    + "<br>"
                    + "Position: "
                    + loggedEmployee.getPosition()
                    + "<br>"
                    + "Department: "
                    + loggedEmployee.getDepartment()
                    + "</html>"
            );
            
            JButton employeeInformationButton
                    = new JButton("View Employee Information");

            JButton payCoverageButton
                    = new JButton("Pay Coverage");
            
            employeeInformationButton.addActionListener(e -> {

                showEmployeeInformationPage(employeeData);            
            });

            payCoverageButton.addActionListener(e -> {

                showPayCoveragePage(employeeData);
            });


            employeePanel.add(employeeInfo);

            employeePanel.add(employeeInformationButton);

            employeePanel.add(payCoverageButton);
            
            dashboardPanel.add(employeePanel,
                    BorderLayout.CENTER);
        } 

        // =================================================
        // PAYROLL STAFF ACCESS
        // ==================================================
        
        else {

            DefaultTableModel model
                    = new DefaultTableModel();

            model.addColumn("Employee ID");

            model.addColumn("Employee Name");

            model.addColumn("Position");

            model.addColumn("Salary");

            for (Employee employee
                    : FileHandler.employeeList) {

                model.addRow(new Object[]{
                    employee.getEmployeeID(),
                    employee.getEmployeeFirstName()
                    + " "
                    + employee.getEmployeeLastName(),
                    employee.getPosition(),
                    employee.getBasicSalary()
                });
            }

            employeeTable = new JTable(model);

            dashboardPanel.add(
                    new JScrollPane(employeeTable),
                    BorderLayout.CENTER
            );
        }

        add(dashboardPanel);

        revalidate();

        repaint();
    }
    
    public void createAccounts() {

        accounts = new UserAccount[FileHandler.employeeList.size() + 2];

        int index = 0;

        // CREATE ACCOUNTS FOR ALL EMPLOYEES
        for (Employee employee : FileHandler.employeeList) {

            String username
                    = employee.getEmployeeLastName()
                            .toLowerCase()
                    + employee.getEmployeeID();

            String password
                    = "MPH"
                    + employee.getEmployeeID();

            accounts[index] = new UserAccount(
                    username,
                    password,
                    "Employee",
                    "May 20 2026"
            );

            index++;
        }

        // PAYROLL STAFF ACCOUNT 1
        accounts[index] = new UserAccount(
                "payroll_admin",
                "Payroll2026",
                "Payroll Staff",
                "May 20 2026"
        );

        index++;

        // PAYROLL STAFF ACCOUNT 2
        accounts[index] = new UserAccount(
                "payroll_staff",
                "MotorPHStaff",
                "Payroll Staff",
                "May 20 2026"
        );
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == loginButton) {

            handleLogin();
        }

        if (event.getSource() == logoutButton) {

            dispose();
            new MotorPHEmployeeGUI();
        }
    }

    public void handleLogin() {
        String username = usernameField.getText();
        String password
                = String.valueOf(passwordField.getPassword());

        boolean isValid = false;

        for (UserAccount account : accounts) {

            if (account.logIn(username, password)) {

                JOptionPane.showMessageDialog(this,
                        "Login successful.");

                remove(loginPanel);

                buildDashboard(account);

                isValid = true;
                break;
                }
        }

        if (!isValid) {

            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
    
    
    public void showPayCoveragePage(
            Employee employee) {

        JFrame payCoverageFrame
                = new JFrame("Pay Coverage");

        payCoverageFrame.setSize(600,
                500);

        payCoverageFrame.setLocationRelativeTo(null);

        JPanel panel
                = new JPanel();

        panel.setLayout(new BorderLayout());

        // =========================================
        // TOP INPUT PANEL
        // =========================================
        JPanel inputPanel
                = new JPanel();

        inputPanel.setLayout(
                new GridLayout(3,
                        2,
                        10,
                        10)
        );

        JLabel startDateLabel
                = new JLabel("Start Date:");

        JTextField startDateField
                = new JTextField();

        JLabel endDateLabel
                = new JLabel("End Date:");

        JTextField endDateField
                = new JTextField();

        JButton generateButton
                = new JButton("Generate Payslip");

        inputPanel.add(startDateLabel);

        inputPanel.add(startDateField);

        inputPanel.add(endDateLabel);

        inputPanel.add(endDateField);

        inputPanel.add(generateButton);

        // =========================================
        // PAYSLIP AREA
        // =========================================
        JTextArea payslipArea
                = new JTextArea();

        payslipArea.setEditable(false);

        JScrollPane scrollPane
                = new JScrollPane(payslipArea);

        // =========================================
        // BUTTON ACTION
        // =========================================
        generateButton.addActionListener(e -> {

            try {

                String startDate
                        = startDateField.getText();

                String endDate
                        = endDateField.getText();

                if (startDate.isEmpty()
                        || endDate.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            payCoverageFrame,
                            "Please enter all dates."
                    );

                    return;
                }

                Payroll payroll
                        = new Payroll();

                double grossSalary
                        = payroll.computeGrossSalary(
                                160,
                                employee.getBasicSalary()
                                / 160
                        );

                double deductions
                        = payroll.computeTotalDeductions(
                                grossSalary
                        );

                double netSalary
                        = payroll.computeNetSalary(
                                grossSalary,
                                deductions
                        );

                payslipArea.setText(
                        "========== MOTORPH PAYSLIP ==========\n\n"
                        + "Pay Coverage\n"
                        + startDate
                        + " to "
                        + endDate
                        + "\n\n"
                        + "Employee ID: "
                        + employee.getEmployeeID()
                        + "\n\n"
                        + "Employee Name: "
                        + employee.getEmployeeFirstName()
                        + " "
                        + employee.getEmployeeLastName()
                        + "\n\n"
                        + "Position: "
                        + employee.getPosition()
                        + "\n\n"
                        + "Basic Salary: "
                        + employee.getBasicSalary()
                        + "\n\n"
                        + "Gross Salary: "
                        + grossSalary
                        + "\n\n"
                        + "Total Deductions: "
                        + deductions
                        + "\n\n"
                        + "Net Salary: "
                        + netSalary
                );

            } catch (Exception exception) {

                JOptionPane.showMessageDialog(
                        payCoverageFrame,
                        "Error generating payslip."
                );
            }
        });

        panel.add(inputPanel,
                BorderLayout.NORTH);

        panel.add(scrollPane,
                BorderLayout.CENTER);

        payCoverageFrame.add(panel);

        payCoverageFrame.setVisible(true);
    }
    
    public void showEmployeeInformationPage(
            Employee employee) {

        JFrame informationFrame
                = new JFrame("Employee Information");

        informationFrame.setSize(500,
                500);

        informationFrame.setLocationRelativeTo(null);

        JPanel panel
                = new JPanel();

        panel.setLayout(new GridLayout(10,
                1,
                10,
                10));

        JLabel title
                = new JLabel(
                        "Employee Information"
                );

        JLabel employeeID
                = new JLabel(
                        "Employee ID: "
                        + employee.getEmployeeID()
                );

        JLabel employeeName
                = new JLabel(
                        "Employee Name: "
                        + employee.getEmployeeFirstName()
                        + " "
                        + employee.getEmployeeLastName()
                );

        JLabel birthDate
                = new JLabel(
                        "Birth Date: "
                        + employee.getBirthDate()
                );

        JLabel position
                = new JLabel(
                        "Position: "
                        + employee.getPosition()
                );

        JLabel department
                = new JLabel(
                        "Department: "
                        + employee.getDepartment()
                );

        JLabel salary
                = new JLabel(
                        "Basic Salary: "
                        + employee.getBasicSalary()
                );

        JButton backButton
                = new JButton("Back");

        backButton.addActionListener(e -> {

            informationFrame.dispose();
        });

        panel.add(title);

        panel.add(employeeID);

        panel.add(employeeName);

        panel.add(birthDate);

        panel.add(position);

        panel.add(department);

        panel.add(salary);

        panel.add(backButton);

        informationFrame.add(panel);

        informationFrame.setVisible(true);
    }
}
