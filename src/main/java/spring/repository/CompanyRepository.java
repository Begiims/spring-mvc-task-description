package spring.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Company;
import spring.repository.interfaces.CompanyInterface;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepository implements CompanyInterface {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Company> findAllCompanies() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    public Company findByIdCompany(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    public void deleteByIdCompany(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company where id=" + id).executeUpdate();
    }

    public void updateByIdCompany(Long id, Company company) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = findByIdCompany(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCompany(company.getLocatedCompany());
        session.merge(company1);
    }
}