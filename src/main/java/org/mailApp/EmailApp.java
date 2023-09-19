package org.mailApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailApp extends JFrame implements ActionListener {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField departmentField;
    private JButton createButton;
    private JButton exitButton;

    public EmailApp() {
        setTitle("Email App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        JLabel departmentLabel = new JLabel("Department:");
        departmentField = new JTextField(20);

        createButton = new JButton("Create Email");
        createButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(departmentLabel);
        add(departmentField);
        add(createButton);
        add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String department = departmentField.getText();
            mail createMail = new mail(firstName, lastName, department);
            createMail.saveToFile("C:\\Users\\Aldo Becerra\\IdeaProjects\\EmailAdministration\\src\\main\\java\\org\\DataBase\\emails.txt");
            JOptionPane.showMessageDialog(this, "Email created and saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailApp app = new EmailApp();
            app.setVisible(true);
        });
    }
}
