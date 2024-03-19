# comp3005_a3_q1
https://youtu.be/aD6tXrdhsMM

Instructions to setup: 

If JDBC java setup is not done, follow video till 9 minutes.
https://brightspace.carleton.ca/d2l/le/content/264064/viewContent/3673226/View

Create database "university" in postgre (pgadmin4)

Use query tool for university and put my create table sql code (a3_students.sql)

Open query tool for university and copy and paste :

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

Download my java jbdc code and run it with your own postgre details (your password)

Run main and make run whatever functions you'd like to try (examples of how are commented out)

Note: checking students table can be done in pgAdmin by right clicking the "students" listing on the left side bar and selecting "view/edit data -> all rows", which gives a select all query as well.

# Function purpose and how it works

# displayAllStudents(Connection conn): 

Prints out all students in the table

Connects to the database and runs a query to obtain all students and their info, then iterates through each one and displays them in the console

# addStudent(Connection conn, String firstName, String lastName, String email, String enrollmentDate):

Adds a student to the table

Connects to the database and runs a query to add a student and their info to the table. They're assigned an ID thats increasing everytime a student is added


# updateStudentEmail(Connection conn, int studentId, String newEmail):

Changes a students email

Connects to the database and runs a query overwrites an email string with another string that belongs to the given student ID. Their id and email is then set.

# deleteStudent(Connection conn, int studentId):

removes a student from the table

Connects to the database and runs a query to deletes a student and their info from the table. This is done by finding the student with the given Id. (? is replaced by studentId using pstmt.setInt())



# Contents:

a3_students.sql: sql file that creates the students table

Main.java: code to put into the maven based Java program as the "Main" class

DBExampleComp3005.zip: all contents of the java program if needed in addition to Main.java by itself


