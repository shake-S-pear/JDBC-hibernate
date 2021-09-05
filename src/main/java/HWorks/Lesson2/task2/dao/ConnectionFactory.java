package HWorks.Lesson2.task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String driverClassName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/carsshop";
    String dbUser = "root";
    String dbPwd = "admin";

    private static HWorks.Lesson2.task2.dao.ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static HWorks.Lesson2.task2.dao.ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new HWorks.Lesson2.task2.dao.ConnectionFactory();
        }
        return connectionFactory;
    }

}
