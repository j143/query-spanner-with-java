package labs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class App {

    public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) {

        // docs: https://hibernate.org/reactive/documentation/1.0/javadocs/org/hibernate/reactive/stage/Stage.SessionFactory.html
        // create a Hibernate sessionFactory and session
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // 
        // clearData(session);
        // writeData(session);
        // readData(session);

        // close Hibernate session and sessionFactory
        session.close();
        sessionFactory.close();
 
    }
}