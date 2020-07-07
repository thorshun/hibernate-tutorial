import com.hibernate.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestReadObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
//            Student student = new Student("Daffy", "Duck",  "Duck@luv.com");
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            System.out.println("Getting student with id: " + student.getId());
//            Student theStudent = session.get(Student.class, student.getId());
//            System.out.println(theStudent);
//            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
