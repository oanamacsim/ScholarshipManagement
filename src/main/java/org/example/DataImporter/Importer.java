package org.example.DataImporter;

import com.github.javafaker.Faker;
import org.example.DAO.StudentDAO;

import java.util.Random;

public class Importer
{
    private static final String[] GROUPS = {"A1", "A2", "A3", "A4", "A5", "A6", "B1", "B2", "B3", "E1", "E2"};
    private static final String[] YEARS = {"1", "2", "3"};
    public static void main(String[] args)
    {
        cleanDatabase();

        addRandomStudents();
        addScholarships();
        assignScholarshipsToStudents();

        System.out.println("Data imported successfully");
    }

    private static void cleanDatabase()
    {
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.removeStudents();

        System.out.println("Database cleaned");
    }

    private static void addRandomStudents()
    {
        StudentDAO studentDAO = new StudentDAO();
        Random random = new Random();
        Faker faker = new Faker();

        for (String group : GROUPS) {
            for (String year : YEARS) {
                int numberOfStudents = 20 + random.nextInt(11);
                for (int i = 0; i < numberOfStudents; i++) {
                    String name = faker.name().fullName();
                    int age = 18 + random.nextInt(5);
                    String yearGroup = year + group;
                    studentDAO.addStudent(name, age, yearGroup);
                }
            }
        }

        System.out.println("Students imported");
    }

    private static void addScholarships()
    {
        //todo
    }

    private static void assignScholarshipsToStudents()
    {
        //todo
    }
}