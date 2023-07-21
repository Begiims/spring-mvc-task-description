package spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String locatedCompany;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> courseList;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Group> groups;
}