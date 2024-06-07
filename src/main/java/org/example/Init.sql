DROP DATABASE IF EXISTS scholarship_manager;

CREATE DATABASE scholarship_manager;

USE scholarship_manager;

DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    group_year VARCHAR(3) NOT NULL
);

DROP TABLE IF EXISTS scholarships;

CREATE TABLE scholarships (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(100) NOT NULL,
    amount INT NOT NULL
);

DROP TABLE IF EXISTS student_scholarships;

CREATE TABLE student_scholarships (
    student_id INT,
    scholarship_id INT,
    PRIMARY KEY (student_id, scholarship_id),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (scholarship_id) REFERENCES scholarships(id)
);