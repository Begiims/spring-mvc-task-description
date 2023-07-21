package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Company;
import spring.repository.interfaces.CompanyInterface;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyInterface companyInterface;

    @GetMapping("/")
    public String findAllCompanies(Model model) {
        model.addAttribute("find", companyInterface.findAllCompanies());
        return "table-company";
    }
    @GetMapping("/companyForm")
    public String saveFormCompany() {
        return "save-company";
    }
    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("companyName") String companyName,
                               @RequestParam("located") String located) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCompany(located);
        companyInterface.saveCompany(company);
        return "redirect:/";
    }


    @GetMapping("/deleteByCompany/{id}")
    public String deleteByIdCompany(@PathVariable Long id) {
        companyInterface.deleteByIdCompany(id);
        return "redirect:/";
    }

    @GetMapping("/getCompany/by/{id}")
    public String getByIdCompany(Model model, @PathVariable Long id) {
        Company company = companyInterface.findByIdCompany(id);
        model.addAttribute("company", company);
        return "get-company";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateCompany(@PathVariable Long id, Model model) {
        Company company = companyInterface.findByIdCompany(id);
        model.addAttribute("company", company);
        return "update-company";
    }

    @PostMapping("/updateCompanyPost/{id}")
    private String updateCompany(
            @RequestParam("companyName") String companyName,
            @RequestParam("locatedCompany") String locatedCompany,
            @PathVariable Long id) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCompany(locatedCompany);
        companyInterface.updateByIdCompany(id, company);
        return "redirect:/";
    }
}