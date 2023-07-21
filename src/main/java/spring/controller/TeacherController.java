package spring.controller;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Course;
import spring.model.Teacher;
import spring.repository.interfaces.CourseInterface;
import spring.repository.interfaces.TeacherInterface;

import javax.persistence.PersistenceException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher/")
public class TeacherController {
    private final TeacherInterface teacherInterface;
    private final CourseInterface courseInterface;

    @GetMapping("find/{id}")
    public String findAll(@PathVariable Long id, Model model) {
        model.addAttribute("find", teacherInterface.findAllTeachers(id));
        model.addAttribute("id", id);
        return "table-teacher";
    }


    @GetMapping("saveForm/{id}")
    public String saveForm(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "save-teacher";
    }

    @PostMapping("save/{id}")
    public String save(@PathVariable Long id,
                       @RequestParam("email") String email,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) throws Exception {
            Teacher teacher = new Teacher();
            Course course = courseInterface.findByIdCourse(id);
            teacher.setEmail(email);
            teacher.setFirstName(firstName);
            teacher.setLastName(lastName);
            teacher.setCourse(course);
            teacherInterface.saveTeacher(teacher);
        return "redirect:/teacher/find/" + id;
    }
}