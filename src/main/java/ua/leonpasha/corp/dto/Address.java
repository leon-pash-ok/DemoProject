package ua.leonpasha.corp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long addressId;
    private String city;
    private String street;
    private String building;
    private Integer apartment;
    private String phone;
}
