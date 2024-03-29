package ua.leonpasha.corp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
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
