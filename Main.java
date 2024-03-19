import java.sql.*;


public class Main
{
    /*
    Main function setup, connects to postgre
    */
    public static void main(String[] args)
    {
        String url = "jdbc:postgresql://localhost:5432/university";
        String user = "postgres";
        String password = "MassiBo123";


        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            //deleteStudent(connection,2);
            //addStudent(connection,"dante", "fs", "dspezza", "2023-12-12");
            //deleteStudent(connection,4);
            //updateStudentEmail(connection,11,"jimmythadon@ph.com");
            displayAllStudents(connection);
            //deleteStudent(connection,8);
            //displayAllStudents(connection);


        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    /*Connects to the database and runs a query to obtain all students and their info, then iterates through each one and displays them in the console*/
    public static void displayAllStudents(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("student_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String enrollmentDate = rs.getString("enrollment_date");
            System.out.println("Student ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email + ", Enrollment Date: " + enrollmentDate);
        }
        rs.close();
        stmt.close();
    }

    /*Connects to the database and runs a query to add a student and their info to the table. They're assigned an ID thats increasing everytime a student is added*/
    public static void addStudent(Connection conn, String firstName, String lastName, String email, String enrollmentDate) throws SQLException {
        String sql = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setDate(4, Date.valueOf(enrollmentDate));
        pstmt.executeUpdate();
        pstmt.close();
    }
/*Connects to the database and runs a query overwrites an email string with another string that belongs to the given student ID. Their id and email is then set. */
    public static void updateStudentEmail(Connection conn, int studentId, String newEmail) throws SQLException {
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newEmail);
        pstmt.setInt(2, studentId);
        pstmt.executeUpdate();
        pstmt.close();
    }


    /*Connects to the database and runs a query to deletes a student and their info from the table. This is done by finding the student with the given Id. (? is replaced by studentId using pstmt.setInt())*/
    public static void deleteStudent(Connection conn, int studentId) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
