package ua.leonpasha.corp.core.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;

    public EmployeeEntity(Long id, String firstName, String secondName, String position, Integer experience, AddressEntity address) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.position = position;
        this.experience = experience;
        this.address = address;
    }

}
