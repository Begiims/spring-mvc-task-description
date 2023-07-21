package spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Student;
import spring.repository.interfaces.StudentInterface;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository implements StudentInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAllStudents(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Student c where c.group.id=" + id, Student.class).getResultList();
    }

    @Override
    public Student findByIdStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }


    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void deleteByIdStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=:personId").setParameter("personId", id).executeUpdate();
    }

    @Override
    public void updateByIdStudent(Long id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findByIdStudent(id);
        student1.setFirstName(student1.getFirstName());
        session.merge(student1);
    }
}
