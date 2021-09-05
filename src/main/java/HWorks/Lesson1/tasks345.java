package HWorks.Lesson1;

import java.sql.*;

public class tasks345 {

    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "admin";

    private static final String GET_PHONE_ADDRESS = "select name, telephone, address from employee_name_telephone " +
            "join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee";

    private static final String GET_NOT_MARRIED = "select name, telephone, date from employee_name_telephone " +
            "join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee " +
            "where family = 'not married'";

    private static final String GET_INFO_ABOUT_MANAGERS = "select name, telephone, date from employee_name_telephone " +
            "join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee " +
            "join employee_salary_title on employee_name_telephone.idEmployee = employee_salary_title.idEmployee " +
            "where title = 'director' or title = 'manager'";

    public static void main(String[] args) {

        registerDriver();

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("1) Получите контактные данные сотрудников (номера телефонов, место жительства).\n");

        Connection connection1 = null;
        PreparedStatement statement1 = null;

        try {
            connection1 = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement1 = connection1.prepareStatement(GET_PHONE_ADDRESS);

            ResultSet resultSet1 = statement1.executeQuery();

                while (resultSet1.next()) {
                    String name = resultSet1.getString("name");
                    String telephone = resultSet1.getString("telephone");
                    String address = resultSet1.getString("address");

                    System.out.println(name + " " + " " + telephone + " " + address);
                }
        } catch(SQLException e){
                e.printStackTrace();
        }  finally{
                try {
                    connection1.close();
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("2) Получите информацию о дате рождения всех холостых сотрудников и их номера.\n");

        Connection connection2 = null;
        PreparedStatement statement2 = null;

        try {
            connection2 = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement2 = connection2.prepareStatement(GET_NOT_MARRIED);

            ResultSet resultSet2 = statement2.executeQuery();

            while (resultSet2.next()) {
                String name = resultSet2.getString("name");
                String telephone = resultSet2.getString("telephone");
                Date date = resultSet2.getDate("date");

                System.out.println(name + " " + " " + telephone + " " + date);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }  finally{
            try {
                connection2.close();
                statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n--------------------------------------------------------------------------------------");
        System.out.println("3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.\n");

        Connection connection3 = null;
        PreparedStatement statement3 = null;

        try {
            connection3 = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement3 = connection3.prepareStatement(GET_INFO_ABOUT_MANAGERS);

            ResultSet resultSet3 = statement3.executeQuery();

            while (resultSet3.next()) {
                String name = resultSet3.getString("name");
                String telephone = resultSet3.getString("telephone");
                Date date = resultSet3.getDate("date");

                System.out.println(name + " " + " " + telephone + " " + date);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }  finally{
            try {
                connection3.close();
                statement3.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n--------------------------------------------------------------------------------------");

    }


        private static void registerDriver () {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loading success!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


/*
        Задание 3
        Создайте базу данных с именем “MyJoinsDB” используя Workbench.
        Задание 4
        Используя Workbench в данной базе данных создайте 3 таблицы,
        В 1-й таблице содержатся имена и номера телефонов сотрудников компании.
        Во 2-й таблице содержатся ведомости о зарплате и должностях сотрудников: главный директор,
        менеджер, рабочий.
        В 3-й таблице содержится информация о семейном положении, дате рождения, и месте проживания.
        Задание 5
        Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
        1) Получите контактные данные сотрудников (номера телефонов, место жительства).
        2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
        3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
 */

//            -- 1)Получите контактные данные сотрудников (номера телефонов, место жительства).
//
//            select name, telephone, address from employee_name_telephone
//            join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee;
//
//            -- 2)Получите информацию о дате рождения всех холостых сотрудников и их номера.
//
//                    select name, telephone, date from employee_name_telephone
//            join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee
//            where family = 'not married';
//
//            -- 3)Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
//
//                    select name, telephone, date from employee_name_telephone
//            join employee_personalInformation on employee_name_telephone.idEmployee = employee_personalInformation.idEmployee
//            join employee_salary_title on employee_name_telephone.idEmployee = employee_salary_title.idEmployee
//            where title = 'director' or title = 'manager';