# Scholarship Manager

## Overview

**Scholarship Manager** is a Java application developed to handle the management of scholarships for students. It provides features for tracking scholarship data, ensuring that information is accessible and transferable.

## Key Features
- Graphical interface.
- Managing students or scholarships by adding, removing and updating them
- Assigning scholarships to students available for a specific interval.
- Importing students and scholarships From CSV
- Importing random data for demo purposes.
- Simple or periodic export options
- Storing data into a database.

## Java Components

1. **Main**: Starting point of the application. It holds the main frame and handles menu changes between controlPanel, ManageScholarshipsPanel and ManageStudentsPanel.

2. **UI Components**: Handles the user interface and interaction logic:
   - **ControlPanel**: Panel where the functionalities allowing to import and export data are present in multiple forms described later in this documentation;
   - **ManageScholarshipsPanel**: Panel for managing scholarships. Functionalities include: selecting, editing, adding and the removal of data entries;
   - **ScholarshipFormDialog**: Dialog window for adding or editing scholarships' name and amount;
   - **ManageStudentsPanel**: Panel for managing students. Functionalities include: selecting, editing, adding and the removal of data entries;
   - **StudentFormDialog**: Dialog for adding or editing students' names, ages, academic groups and other similar attributes, implementing an user-friendly interface with ComboBoxes.

2. **Data Management**: Handles data import and export:
   - **RandomImporter**: Imports demo data for testing.
   - **IBANManager**: Manages IBAN validation and generation.
   - **CSVManager**: Manages CSV file import and export.

3. **Entities**: Records used to represent the entities from the application:
   - **Student.java**: Represents a student.
   - **Scholarship.java**: Represents a scholarship.
   - **StudentScholarship.java**: Represents a scholarship awarded to a student.

4. **DatabaseConnection.java**: Singleton that manages the connections to the database

5. **DAO Classes**: Manage data access and manipulation for all entities:
   - **StudentDAO.java**: Handles data operations for students.
   - **StudentScholarshipDAO.java**: Manages data operations for student scholarships.
   - **ScholarshipDAO.java**: Manages data operations for scholarships.

## User Interface

- *Control Panel*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/controlPanel.png" alt="Control Panel" width="600"/>

- *Manage Students Panel*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/manageStudents.png" alt="Manage Students Panel" width="600"/>

- *Student Form Dialog - add new student*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/addNewStudent.png" alt="Student Form Dialog" width="600"/>

- *Student Form Dialog - edit student*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/editStudent.png" alt="Student Form Dialog" width="600"/>

- *Manage Scholarships Panel*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/manageScholarships.png" alt="Manage Scholarships Panel" width="600"/>

- *Scholarship Form Dialog - add new scholarship*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/addNewScholarship.png" alt="Scholarship Form Dialog" width="600"/>

- *Scholarship Form Dialog - edit scholarship*
<img src="https://github.com/oanamacsim/ScholarshipManagement/blob/main/images/editScholarship.png" alt="Scholarship Form Dialog" width="600"/>

## Data Imports

- Import students - Allows the user to import a preset database of students, with the condition of importing a CSV file
- Imports scholarships - Allows the user to import a given containing scholarships, with the condition of importing a CSV file
- Import random(demo) data - Initialises the database with random mockup tables of students and scholarships, using the Faker Java Library. The assigned scholarships are also chosen with the use of a randomiser. 

## Data Exports

- Export students - Takes all the current students from the database and exports them into a CSV format file
- Export scholarships - Takes all the current scholarships from the database and exports them into a CSV format file
- Export students with their scholarships - Takes all the students together with their assigned scholarships and exports them into a CSV format file
- Export periodic payment reports for each student - Gives the user the possibility to select a period of time, then computes the amount of money that each student should receive
- Export periodic total costs per scholarship - Taking into account all the students that have been assigned scholarships in the database, this functionality computes the total sum needed to fulfil all the scholarships' cost

## Maven dependencies
   - **mysql**: mysql-connector-java version 8.0.33
   - **com.github.javafaker**: javafaker version 1.0.2
   - **org.jdatepicker**: jdatepicker version 1.3.4

## Collaborator
- Oana Marina Macsim
