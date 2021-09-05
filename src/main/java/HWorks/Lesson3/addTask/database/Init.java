package HWorks.Lesson3.addTask.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Init {

    private static SessionFactory factory;

    public Init(){
        InitFactory();
    }

    private static SessionFactory InitFactory() {
        if (factory == null){
            factory = new Configuration().configure("hib.xml").buildSessionFactory();
        }
        return factory;
    }

    public Session getSession(){
        return factory.openSession();
    }

    public void close() {
        factory.close();
    }
}
