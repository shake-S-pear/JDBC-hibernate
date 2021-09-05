package HWorks.Lesson2.extraTask.dao;

import HWorks.Lesson2.extraTask.entity.Employee;

public interface EmployeeDAO {

    void add(Employee employee);

    void update(Employee employee);

    void delete(int idEmployee);

    void findAll();

    void findByTelephoneOperator(String operatorCode);

}
