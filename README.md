# comp3005_a3_q1
https://youtu.be/aD6tXrdhsMM

Instructions to setup: create database "university" in postgre (pgadmin4)

Use query tool for university and put my create table sql code (a3_students.sql)

open query tool for university and copy and paste :

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

Download my java jbdc code and run it with your own postgre details (your password)





Function purpose and how it works
displayAllStudents(Connection conn):

addStudent(Connection conn, String firstName, String lastName, String email, String enrollmentDate):

updateStudentEmail(Connection conn, int studentId, String newEmail):

deleteStudent(Connection conn, int studentId):
