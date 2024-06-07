package org.example.UI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Scholarship Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new BorderLayout());

        frame.setSize(1400, 720);
        frame.setMinimumSize(new Dimension(600, 500));

        JPanel menuPanels = new JPanel();
        JPanel contentPanel = new JPanel(new BorderLayout());

        JButton manageStudents = new JButton("Manage Students");
        JButton manageScholarships = new JButton("Manage Scholarships");

        manageStudents.addActionListener(e -> displayManageStudents(contentPanel));
        manageScholarships.addActionListener(e -> displayManageScholarships(contentPanel));

        menuPanels.add(manageStudents);
        menuPanels.add(manageScholarships);
        menuPanels.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        frame.add(menuPanels, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void displayManageStudents(JPanel contentPanel)
    {
        contentPanel.removeAll();
        contentPanel.add(new ManageStudentsPanel());

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private static void displayManageScholarships(JPanel contentPanel)
    {
        contentPanel.removeAll();

        contentPanel.revalidate();
        contentPanel.repaint();
    }
}