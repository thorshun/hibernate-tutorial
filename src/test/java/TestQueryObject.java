import com.hibernate.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestQueryObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            //Retrieve all students
            List<Student> students = session.createQuery("from Student").getResultList();
            //Display the result
            displayTheResult(students);

            //Retrieve students whose last name is 'Doe'
            students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
            System.out.println("Students whose last name is Doe:");
            displayTheResult(students);

            //Retrieve students whose last name is 'Doe' or first name is Daffy
            students = session.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'").getResultList();
            System.out.println("Students whose first name is Daffy:");
            displayTheResult(students);

            //Retrieve students whose email ends with 'luv.com'
            students = session.createQuery("from Student s where s.email like '%luv.com'").getResultList();
            System.out.println("Students whose email ends with 'luv.com': ");
            displayTheResult(students);


            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }

    private static void displayTheResult(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
