import java.sql.*;

public class ConnectionClass {
    Connection conn ;
    Statement stm ;

    ConnectionClass(){
        try {
            // 1. Load Drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Making Connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GymManagement", "root", "Riya1234$");
            System.out.println("Connection Successfull");
            stm = conn.createStatement();


        }catch (Exception e) {
            e.printStackTrace();
        }
   }

    public static void main(String[] args) {
        new ConnectionClass();
    }
}
