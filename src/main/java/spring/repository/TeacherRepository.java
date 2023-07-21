package spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Teacher;
import spring.repository.interfaces.TeacherInterface;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TeacherRepository implements TeacherInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> findAllTeachers(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Teacher c where c.course.id=" + id, Teacher.class).getResultList();
    }

    @Override
    public Teacher findByIdTeacher(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }


    @Override
    public void saveTeacher(Teacher teacher) throws Exception {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(teacher);
        } catch (Exception e) {
            throw new Exception( "you stupid teacher and course one to one join");
        }
    }

    @Override
    public void deleteByIdTeacher(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=:personId").setParameter("personId", id).executeUpdate();
    }

    @Override
    public void updateByIdTeacher(Long id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findByIdTeacher(id);
        teacher1.setFirstName(teacher1.getFirstName());
        session.merge(teacher1);
    }
}