package ua.leonpasha.corp.core.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ADRESS")
public class AddressEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CITY", nullable = false, length = 512)
    private String city;

    @Column(name = "STREET", nullable = false, length = 512)
    private String street;

    @Column(name = "BUILDING", nullable = false, length = 64)
    private String building;

    @Column(name = "APARTMENT")
    private Integer apartment;

    @Column(name = "PHONE")
    private String phone;

    public AddressEntity(Long id, String city, String street, String building, Integer apartment, String phone) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.phone = phone;
    }

    public AddressEntity(Long id, String city, String street, String building, String phone) {
        this(id, city, street, building, null, phone);
    }
}
