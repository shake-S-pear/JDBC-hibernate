package HWorks.Lesson2.task2;

import HWorks.Lesson2.task2.dao.DAOFactory;
import HWorks.Lesson2.task2.dao.IDAOFactory;
import HWorks.Lesson2.task2.dao.VegetableDAO;
import HWorks.Lesson2.task2.entity.Vegetable;

public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        VegetableDAO vegetableDAO = factory.getVegetableDAO();

        vegetableDAO.add(new Vegetable("pepper", 30, 230));
        vegetableDAO.add(new Vegetable("cucumber", 7, 90));
        vegetableDAO.findAll();
        vegetableDAO.getVegetablesByNumberOfCalories(150);
        vegetableDAO.updatePrice(new Vegetable("tomato",10, 200));
        vegetableDAO.remove("pepper");




    }

}
