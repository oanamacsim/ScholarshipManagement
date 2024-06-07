package org.example.UI;

import org.example.DAO.StudentDAO;
import org.example.Entities.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StudentFormDialog extends JDialog {
    private final JTextField nameField;
    private final JComboBox<Integer> ageComboBox;
    private final JComboBox<String> groupComboBox;
    private final JComboBox<String> yearComboBox;

    public StudentFormDialog(Frame parent, String title, Student student) {
        super(parent, title, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setMinimumSize(new Dimension(400, 250));
        setMaximumSize(new Dimension(400, 250));

        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageComboBox = new JComboBox<>();
        for (int age = 18; age <= 60; age++) {
            ageComboBox.addItem(age);
        }
        panel.add(ageComboBox);

        panel.add(new JLabel("Year:"));
        yearComboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        panel.add(yearComboBox);

        panel.add(new JLabel("Group:"));
        groupComboBox = new JComboBox<>(new String[]{"A1", "A2", "A3", "A4", "A5", "A6", "B1", "B2", "B3", "B4", "E1", "E2"});
        panel.add(groupComboBox);

        if (student != null)
        {
            nameField.setText(student.name());
            ageComboBox.setSelectedItem(student.age());

            String year = student.groupYear().substring(0, 1);
            String group = student.groupYear().substring(1, 2);
            yearComboBox.setSelectedItem(year);
            groupComboBox.setSelectedItem(group);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener((ActionEvent e) -> submitUpdate(student));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener((ActionEvent e) -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel);
        add(panel);
    }

    boolean isNameValid() {
        String name = nameField.getText().trim();
        return !name.isEmpty();
    }

    private void submitUpdate(Student student) {

        if(!isNameValid())
        {
            JOptionPane.showMessageDialog(this, "The name is invalid");
            return;
        }

        String newName = nameField.getText().trim();
        int newAge = ageComboBox.getItemAt(ageComboBox.getSelectedIndex());
        String newYear = yearComboBox.getItemAt(yearComboBox.getSelectedIndex());
        String newGroup = groupComboBox.getItemAt(groupComboBox.getSelectedIndex());
        String newYearGroup = newYear + newGroup;

        StudentDAO studentDAO = new StudentDAO();
        if(student != null)
        {
            studentDAO.updateStudent(student.id(), newName, newAge, newYearGroup);
            JOptionPane.showMessageDialog(this, "Student updated");
        }
        else
        {
            studentDAO.addStudent(newName, newAge, newYearGroup);
            JOptionPane.showMessageDialog(this, "Student added");
        }

        dispose();
    }
}