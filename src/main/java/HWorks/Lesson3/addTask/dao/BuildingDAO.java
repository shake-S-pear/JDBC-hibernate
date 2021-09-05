package HWorks.Lesson3.addTask.dao;

import HWorks.Lesson3.addTask.Building;

public interface BuildingDAO {

    Building save(Building building);

    Building getBuildingByIdWithHQL(Integer id);


}
