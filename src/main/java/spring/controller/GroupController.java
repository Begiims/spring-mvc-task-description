package spring.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Company;
import spring.model.Course;
import spring.model.Group;
import spring.repository.interfaces.CompanyInterface;
import spring.repository.interfaces.CourseInterface;
import spring.repository.interfaces.GroupInterface;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/group/")
public class GroupController {
    private final GroupInterface repositorys;
    private final CompanyInterface companyInterface;
    private final CourseInterface courseInterface;

    @GetMapping("/find/{id}")
    public String findAllGroup(@PathVariable Long id, Model model) {
        model.addAttribute("find", repositorys.findAllGroups(id));
        model.addAttribute("ides", id);
        return "table-group";
    }

    @PostMapping("/saveGroups/{id}")
    private String saveGroups(
            @RequestParam("groupName") String groupName,
            @RequestParam("dataStart") String dataStart,
            @RequestParam("dataFinish") String dataFinish,
            @PathVariable("id") Long id,
            @RequestParam("idCourse") Long idCourse
    ) {
        Company company = companyInterface.findByIdCompany(id);
        List<Course> courses = new ArrayList<>();
        Course course = courseInterface.findByIdCourse(idCourse);
        Group group = new Group();
        courses.add(course);
        group.setGroupName(groupName);
        group.setDataStart(dataStart);
        group.setDataFinish(dataFinish);
        group.setCompany(company);
        group.setCourses(courses);
        repositorys.saveGroup(group);
        return "redirect:/group/find/" + id;
    }

    @GetMapping("/groupsForm/{id}")
    public String saveFormGroups(Model model, @PathVariable Long id) {
        model.addAttribute("ids", id);
        model.addAttribute("course", courseInterface.findAllCourses());
        return "save-group";
    }

    @GetMapping("/updateForm/{id}")
    public String updateByIdGroupForm(Model model, @PathVariable Long id) {
        model.addAttribute("group", repositorys.findByIdGroup(id));
        model.addAttribute("id",id);
        return "update-group";
    }
    @PostMapping("update/{id}")
    public String updateGroup(@PathVariable Long id,
                              @RequestParam("groupName") String groupName,
                              @RequestParam("dataStart") String dataStart,
                              @RequestParam("dataFinish") String dataFinish) {
        Group group = repositorys.findByIdGroup(id);
        group.setGroupName(groupName);
        group.setDataStart(dataStart);
        group.setDataFinish(dataFinish);
        repositorys.updateByIdGroup(id,group);
        return "redirect:/group/find/"+group.getCompany().getId();

    }
}
