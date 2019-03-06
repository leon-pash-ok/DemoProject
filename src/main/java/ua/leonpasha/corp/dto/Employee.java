package ua.leonpasha.corp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long employeeId;
    private String firstName;
    private String secondName;
    private String position;
    private Integer experience;
    private Address address;
}
