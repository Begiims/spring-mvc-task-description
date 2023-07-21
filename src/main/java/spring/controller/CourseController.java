package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Company;
import spring.model.Course;
import spring.repository.CourseRepository;
import spring.repository.interfaces.CompanyInterface;
import spring.repository.interfaces.CourseInterface;

@Controller
@RequestMapping("/course/")
@RequiredArgsConstructor
public class CourseController {
    private final CourseInterface courseInterface;
    private final CompanyInterface companyInterface;

    @GetMapping("/findCourse/{id}")
    public String getCourseAll(@PathVariable Long id, Model model) {
        model.addAttribute("find", courseInterface.findAllCourses(id));
        model.addAttribute("ids", id);
        return "table-course";
    }

    @PostMapping("/saveCourse/{id}")
    private String saveCourse(
            @RequestParam("courName") String courName,
            @RequestParam("duration") String duration,
            @PathVariable("id") Long id) {
        Company company = companyInterface.findByIdCompany(id);
        Course course = new Course();
        course.setCourseName(courName);
        course.setDuration(duration);
        course.setCompany(company);
        courseInterface.saveCourse(course);
        return "redirect:/course/findCourse/" + id;
    }

    @GetMapping("/courseForm/{id}")
    public String saveFormCourse(Model model, @PathVariable Long id) {
        model.addAttribute("ids", id);
        return "save-course";
    }

    @GetMapping("update/{id}")
    public String updateFormCourse(Model model, @PathVariable Long id) {
        Course course = courseInterface.findByIdCourse(id);
        model.addAttribute("course", course);
        return "update-course";
    }

    @PostMapping("updateCourse/{id}")
    private String updateCourse(@RequestParam("courseName") String name, @RequestParam("duration") String duration, @PathVariable Long id) {
        Course course = courseInterface.findByIdCourse(id);
        course.setCourseName(name);
        course.setDuration(duration);
        courseInterface.updateByIdCourse(id, course);
        return "redirect:/course/findCourse/" +course.getCompany().getId();
    }

}