package spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.model.enums.StudentFormat;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private StudentFormat studentFormat;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}