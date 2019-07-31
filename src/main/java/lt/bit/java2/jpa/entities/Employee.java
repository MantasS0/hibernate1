package lt.bit.java2.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "enum('M','F')")
    private Gender gender;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Title> titles;

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
}
