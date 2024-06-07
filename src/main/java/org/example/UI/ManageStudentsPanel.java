package org.example.UI;

import org.example.DAO.StudentDAO;
import org.example.Entities.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ManageStudentsPanel extends JPanel {
    private JPanel contentPanel;
    private StudentRow selectedRow;

    public ManageStudentsPanel()
    {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = createScrollPane();
        JPanel buttonPanel = createButtonPanel();

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JScrollPane createScrollPane()
    {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(0, 500));
        scrollPane.setMaximumSize(new Dimension(0, 500));

        populateScrollPane();

        return scrollPane;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton addNewStudentButton = new JButton("Add new Student");
        JButton editStudentButton = new JButton("Edit Student");
        JButton deleteStudentButton = new JButton("Delete Student");

        addNewStudentButton.addActionListener(e-> addOrEditStudent(null));

        editStudentButton.addActionListener(e->{
            if (selectedRow != null)
            {
                addOrEditStudent(selectedRow.getStudent());
                selectedRow = null;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Select a student to edit.");
            }
        });

        deleteStudentButton.addActionListener(e->{
            if (selectedRow != null)
            {
                deleteStudent(selectedRow.getStudent());
                selectedRow = null;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Select a student to delete.");
            }
        });

        buttonPanel.add(addNewStudentButton);
        buttonPanel.add(editStudentButton);
        buttonPanel.add(deleteStudentButton);

        return buttonPanel;
    }

    private void populateScrollPane() {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getStudents();
        contentPanel.removeAll();
        contentPanel.add(new RowHeader(new String[]{"Line", "ID", "Name", "Age", "Group Year"}));
        for (int i=0;i<students.size();i++)
        {
            StudentRow studentRow = new StudentRow(i, students.get(i), null);
            studentRow.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    if(selectedRow != null)
                        selectedRow.setBackground(null);

                    studentRow.setBackground(Color.lightGray);
                    selectedRow = studentRow;
                }
            });

            contentPanel.add(studentRow);

            contentPanel.revalidate();
            contentPanel.repaint();
        }
    }

    private void addOrEditStudent(Student student) {
        StudentFormDialog dialog = new StudentFormDialog((Frame) SwingUtilities.getWindowAncestor(this), "Edit Student", student);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                populateScrollPane();
            }
        });

        dialog.setVisible(true);
    }

    private void deleteStudent(Student student)
    {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.removeStudent(student.id());

        JOptionPane.showMessageDialog(this, "Student was deleted");

        populateScrollPane();
    }
}