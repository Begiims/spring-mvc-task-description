package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Group;
import spring.model.Student;
import spring.model.enums.StudentFormat;
import spring.repository.interfaces.GroupInterface;
import spring.repository.interfaces.StudentInterface;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student/")
public class StudentController {
    private final StudentInterface studentInterface;
    private final GroupInterface groupInterface;


    @GetMapping("/find/{id}")
    public String findAll(@PathVariable Long id, Model model) {
        model.addAttribute("find", studentInterface.findAllStudents(id));
        model.addAttribute("ids", id);
        return "table-student";
    }

    @GetMapping("/studentForm/{id}")
    public String studentForm(@PathVariable Long id, Model model) {
        model.addAttribute("i", id);
        return "save-student";
    }

    @PostMapping("/save/{id}")
    public String studentSave(@PathVariable Long id,
                              @RequestParam("email") String email,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("study") String studentFormat) {
        Group group = groupInterface.findByIdGroup(id);
        Student student = new Student();
        student.setEmail(email);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStudentFormat(StudentFormat.valueOf(studentFormat.toUpperCase()));
        student.setGroup(group);
        studentInterface.saveStudent(student);
        return "redirect:/student/find/" + id;
    }

    @GetMapping("/updateStudentBy/{id}")
    public String updateByIdStudent(@PathVariable Long id, Model model) {
        Student student = studentInterface.findByIdStudent(id);
        model.addAttribute("student", student);
        return "updateStudentId";
    }

    @PostMapping("/Student/update/{id}")
    public String updateByIdGroup(@RequestParam("companyName") String companyName,
                                  @RequestParam("age") int age, @PathVariable Long id) {
        Student student = new Student();
        student.setFirstName(companyName);
        student.setLastName(companyName);
        student.setEmail(student.getEmail());
        studentInterface.updateByIdStudent(id, student);
        return "redirect:/s";
    }
    @GetMapping("/deleteById/Student/{id}")
    public String deleteById(@PathVariable Long id) {
        Student student = studentInterface.findByIdStudent(id);
        return "redirect:/s";
    }
}