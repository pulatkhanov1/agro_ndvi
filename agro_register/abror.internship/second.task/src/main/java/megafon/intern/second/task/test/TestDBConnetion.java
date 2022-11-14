package megafon.intern.second.task.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnetion {
    public static void main(String[] args) {
        String jdbcURL="jdbc:postgresql://localhost:5432/abror_internship";
        String username="postgres";
        String password="*";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Successfully connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
