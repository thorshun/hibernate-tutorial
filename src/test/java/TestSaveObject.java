import com.hibernate.domain.Student;
import com.hibernate.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class TestSaveObject {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            String theDateOfBirthStr = "31/12/1998";

            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student tempStudent = new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
