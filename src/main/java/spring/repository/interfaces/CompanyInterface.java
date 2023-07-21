package spring.repository.interfaces;

import spring.model.Company;

import java.util.List;

public interface CompanyInterface {
    List<Company> findAllCompanies();

    Company findByIdCompany(Long id);

    void saveCompany(Company company);

    void deleteByIdCompany(Long id);

    void updateByIdCompany(Long id, Company company);
}
