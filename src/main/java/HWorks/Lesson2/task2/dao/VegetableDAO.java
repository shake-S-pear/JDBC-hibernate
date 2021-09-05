package HWorks.Lesson2.task2.dao;

import HWorks.Lesson2.task2.entity.Vegetable;

public interface VegetableDAO {

    void add(Vegetable vegetable);

    void findAll();

    void getVegetablesByNumberOfCalories(int levelOfCalories);

    void updatePrice(Vegetable vegetable);

    void remove(String name);

}
