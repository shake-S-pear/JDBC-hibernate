package HWorks.Lesson2.extraTask.dao;

public class DAOFactory implements FactoryDAO {

    private static FactoryDAO factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized FactoryDAO getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public EmployeeJDBCDAO getEmployeeDAO() {
        return new EmployeeJDBCDAO();
    }

}
