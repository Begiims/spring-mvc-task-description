package spring.repository.interfaces;

import spring.model.Course;

import java.util.List;

public interface CourseInterface {
    List<Course> findAllCourses(Long id);
    List<Course> findAllCourses();

    Course findByIdCourse(Long id);

    void saveCourse(Course course);

    void deleteByIdCourse(Long id);

    void updateByIdCourse(Long id, Course course);
}