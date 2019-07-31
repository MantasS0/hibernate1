package lt.bit.java2.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitlePK implements Serializable {

    @Id
    @Column(name = "emp_no", insertable = false, updatable = false)
    private Integer empNo;

    @Id
    private String title;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

}
