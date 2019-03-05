package ua.leonpasha.corp.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 512)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = false, length = 512)
    private String secondName;

    @Column(name = "POSITION", nullable = false, length = 512)
    private String position;

    @Column(name = "EXPERIENCE", nullable = false, length = 512)
    private Integer experience;

    public EmployeeEntity(String firstName, String secondName, String position, Integer experience) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.experience = experience;
    }

}
