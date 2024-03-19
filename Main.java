import java.sql.*;


public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:postgresql://localhost:5432/university";
        String user = "postgres";
        String password = "MassiBo123";


        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            deleteStudent(connection,2);

            //addStudent(connection,"dante", "fs", "dspezza", "2023-12-12");
            //deleteStudent(connection,4);
            updateStudentEmail(connection,11,"jimmythadon@ph.com");


            displayAllStudents(connection);
            //deleteStudent(connection,8);
            //displayAllStudents(connection);


        }
        catch (Exception e){
            System.out.println(e);
        }
    }

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

    public static void updateStudentEmail(Connection conn, int studentId, String newEmail) throws SQLException {
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newEmail);
        pstmt.setInt(2, studentId);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public static void deleteStudent(Connection conn, int studentId) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, studentId);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
