package HWorks.Lesson2.task2.dao;

import HWorks.Lesson2.task2.entity.Vegetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VegetableJDBCDao implements VegetableDAO {

    private Connection connection = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultSet = null;

    public VegetableJDBCDao(){
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Vegetable vegetable) {
        try {
            String queryString = "INSERT INTO vegetable (name, price, calories) VALUES(?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, vegetable.getName());
            ptmt.setInt(2, vegetable.getPrice());
            ptmt.setInt(3, vegetable.getCalories());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updatePrice(Vegetable vegetable) {
        try {
            String queryString = "UPDATE vegetable SET price=? WHERE name=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, vegetable.getPrice());
            ptmt.setString(2, vegetable.getName());
            ptmt.executeUpdate();
            System.out.println("Data updated Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void remove(String name) {
        try {
            String queryString = "DELETE FROM vegetable WHERE name=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, name);
            ptmt.executeUpdate();
            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll() {
        System.out.println("\nSelect all \n");
        try {
            String queryString = "SELECT * FROM vegetable";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name") + ", Price: "
                        + resultSet.getString("price") + ", Calories: "
                        + resultSet.getString("calories"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getVegetablesByNumberOfCalories(int levelOfCalories) {
        System.out.println("\n Vegetables what have more calories than " + levelOfCalories + "\n");
        try {
            String queryString = "SELECT * FROM vegetable WHERE calories > " + levelOfCalories;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name") + ", Price: "
                        + resultSet.getString("price") + ", Calories: "
                        + resultSet.getString("calories"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}