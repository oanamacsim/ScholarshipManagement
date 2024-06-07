package org.example.UI;

import org.example.Entities.Scholarship;
import org.example.Entities.Student;

import javax.swing.*;
import java.awt.*;

public class StudentRow extends JPanel {
    private Student student;
    private JComboBox<Scholarship> scholarshipComboBox;
    public StudentRow(int rowNumber, Student student, JComboBox<Scholarship> scholarshipComboBox)
    {
        this.student = student;
        this.scholarshipComboBox = scholarshipComboBox;

        setLayout(new GridLayout(1, 6));

        add(createCenteredLabel(Integer.toString(rowNumber)));
        add(createCenteredLabel(Integer.toString(student.id())));
        add(createCenteredLabel(student.name()));
        add(createCenteredLabel(Integer.toString(student.age())));
        add(createCenteredLabel(student.groupYear()));

        if(scholarshipComboBox != null)
            add(scholarshipComboBox);

        setPreferredSize(new Dimension(0, 50));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    }

    public Student getStudent() {
        return student;
    }

    private JLabel createCenteredLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}