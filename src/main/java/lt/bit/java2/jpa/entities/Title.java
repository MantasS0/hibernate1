package lt.bit.java2.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "titles")
@Data
@IdClass(TitlePK.class)
public class Title {

    @Id
    @Column(name = "emp_no", insertable = false, updatable = false)
    private Integer empNo;

    @Id
    private String title;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
    private Employee employee;

}
