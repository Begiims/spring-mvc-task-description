package spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Course;
import spring.repository.interfaces.CourseInterface;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository implements CourseInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> findAllCourses(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c where c.company.id=" + id, Course.class).getResultList();
    }

    @Override
    public List<Course> findAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course findByIdCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }
    @Override
    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void deleteByIdCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course where id=" + id).executeUpdate();
    }

    @Override
    public void updateByIdCourse(Long id, Course course) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = findByIdCourse(id);
        course1.setCourseName(course.getCourseName());
        session.merge(course1);
    }

}