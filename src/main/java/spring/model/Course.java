package spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Group> group;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
