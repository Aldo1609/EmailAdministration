package org.mailApp;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class mail {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String suffix = "example.com";
    private String email;

    public mail(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = setPassword(10);
        this.email = generateEmail();
    }

    private String generateEmail() {
        return String.format("%s.%s@%s.%s", firstName.toLowerCase(), lastName.toLowerCase(), department.toLowerCase(), suffix);
    }

    public void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String data = String.format("%s,%s\n", email, password);
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String setPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        StringBuilder password = new StringBuilder();

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(passwordSet.length());
            char randomChar = passwordSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

    public String showInfo() {
        return "Employee: " + firstName + " " + lastName +
                "\nDepartment: " + department +
                "\nCompany Email: " + email +
                "\nPassword: " + password;
    }
}
