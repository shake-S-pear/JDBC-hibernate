package HWorks.Lesson3.addTask;

import HWorks.Lesson3.addTask.dao.BuildingDAO;
import HWorks.Lesson3.addTask.dao.BuildingDaoImpl;
import HWorks.Lesson3.addTask.database.Init;


public class Main {

    public static final Init initDB = new Init();
    public static BuildingDAO buildingDAO = new BuildingDaoImpl();

    public static void main(String[] args) {

        Building building = new Building();

        building.setFloors(55);
        building.setNumberOfPeople(560);
        building.setAddress("Kyiv, Vasylkivska, 11190");
//        buildingDAO.save(building);
//        System.out.println("save done");
        System.out.println(buildingDAO.getBuildingByIdWithHQL(12).toString());
        initDB.close();
    }



}