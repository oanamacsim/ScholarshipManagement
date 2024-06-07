package org.example.DAO;

import org.example.Database.DatabaseConnection;
import org.example.Entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(String name, int age, String groupYear) {
        String query = "INSERT INTO students (name, age, group_year) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, groupYear);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int studentId, String name, int age, String groupYear) {
        String query = "UPDATE students SET name = ?, age = ?, group_year = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, groupYear);
            statement.setInt(4, studentId);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("group_year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    public List<Student> getStudentsFromGroup(String groupYear) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE group_year LIKE ? ORDER BY name";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, groupYear);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String group = rs.getString("group_year");
                    students.add(new Student(id, name, age, group));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return students;
    }

    public void removeStudents()
    {
        String query = "DELETE FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeStudent(int studentId) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}