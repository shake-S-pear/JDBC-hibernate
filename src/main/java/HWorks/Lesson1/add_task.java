package HWorks.Lesson1;

import java.sql.*;
import java.util.Calendar;

public class add_task {

    private static final String URL = "jdbc:mysql://localhost:3306/shopdb";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "admin";

    private static final String INSERT_NEW = "INSERT INTO customers(FName, LName, MName, Address1, Address2, City, Phone, DateInSystem) "
            + " VALUES(?,?,?,?,?,?,?,?)";

    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(INSERT_NEW);

            statement.setString(1, "Afrodita");
            statement.setString(2, "Grim");
            statement.setString(3, "Zevsivna");
            statement.setString(4, "Khreshchatyk, 1");
            statement.setString(5, "Shevchenka, 23");
            statement.setString(6, "Kyiv");
            statement.setString(7, "(011)0012100");
            statement.setDate(8, new Date(Calendar.DATE));

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
