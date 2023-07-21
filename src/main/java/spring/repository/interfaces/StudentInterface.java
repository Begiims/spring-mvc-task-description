package spring.repository.interfaces;

import spring.model.Student;

import java.util.List;

public interface StudentInterface {
    List<Student> findAllStudents(Long id);

    Student findByIdStudent(Long id);

    void saveStudent(Student student);

    void deleteByIdStudent(Long id);

    void updateByIdStudent(Long id, Student student);
}
