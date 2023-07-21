package spring.repository.interfaces;

import spring.model.Teacher;

import java.util.List;

public interface TeacherInterface {
    List<Teacher> findAllTeachers(Long id);

    Teacher findByIdTeacher(Long id);

    void saveTeacher(Teacher teacher) throws Exception;

    void deleteByIdTeacher(Long id);

    void updateByIdTeacher(Long id, Teacher teacher);

}
