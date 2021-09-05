package HWorks.Lesson3.addTask.dao;

import HWorks.Lesson3.addTask.Building;
import org.hibernate.Session;
import org.hibernate.query.Query;

import static HWorks.Lesson3.addTask.Main.initDB;

public class BuildingDaoImpl implements BuildingDAO{

    public Building save(Building building){
        Session session = initDB.getSession();
        session.getTransaction().begin();
        session.save(building);
        session.getTransaction().commit();
//        System.out.println("data commited");
        session.close();
//        System.out.println("session closed");
        return building;
    }

    public Building getBuildingByIdWithHQL(Integer id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        Query<Building> query = session.createQuery("select b from Building b where b.id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}


//    public Author getAuthorByIdWithCriteria(Integer id) {
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Author> criteriaQuery = builder.createQuery(Author.class);
//        Root<Author> root = criteriaQuery.from(Author.class);
//        criteriaQuery.where(builder.equal(root.get("id"), id));
//        TypedQuery<Author> authorTypedQuery = session.createQuery(criteriaQuery);
//        return authorTypedQuery.getSingleResult();
//    }
