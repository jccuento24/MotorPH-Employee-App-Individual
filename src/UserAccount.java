/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juliusceasarcuento
 */
import javax.swing.*;

public class UserAccount {

    private String username;
    private String password;
    private String userRole;
    private String lastLogin;

    public UserAccount(String username, String password,
            String userRole, String lastLogin) {

        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.lastLogin = lastLogin;
    }

    public boolean logIn(String inputUsername, String inputPassword) {

        return username.equals(inputUsername)
                && password.equals(inputPassword);
    }

    public void logOut() {
        JOptionPane.showMessageDialog(null,
                "Logged out successfully.");
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getLastLogin() {
        return lastLogin;
    }
}
