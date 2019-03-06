package ua.leonpasha.corp.service.converter;

import ua.leonpasha.corp.domain.entities.AddressEntity;
import ua.leonpasha.corp.domain.entities.EmployeeEntity;
import ua.leonpasha.corp.dto.Address;
import ua.leonpasha.corp.dto.Author;
import ua.leonpasha.corp.domain.entities.AuthorEntity;
import ua.leonpasha.corp.dto.Employee;

public class MapperUtilsForEntities {
    public static Author mapToDtoAuthor(AuthorEntity authorEntity){
        return Author.builder()
                .id(authorEntity.getId())
                .firstName(authorEntity.getFirstName())
                .secondName(authorEntity.getSecondName())
                .build();

    }

    public static AuthorEntity mapToEntityAuthor(Author author){
        return new AuthorEntity(author.getFirstName(), author.getSecondName());

    }

    public static Employee mapToDtoEmployee(EmployeeEntity employeeEntity){
        return Employee.builder()
                .employeeId(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .secondName(employeeEntity.getSecondName())
                .position(employeeEntity.getPosition())
                .experience(employeeEntity.getExperience())
                .build();

    }

    public static EmployeeEntity mapToEntityEmployee(Employee employee){
        return new EmployeeEntity(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getPosition(),
                employee.getExperience(),
                mapToEntityAddress(employee.getAddress())
        );
    }

    public static Address mapToDtoAddress(AddressEntity addressEntity){
        return Address.builder()
                .addressId(addressEntity.getId())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .building(addressEntity.getBuilding())
                .apartment(addressEntity.getApartment())
                .build();

    }

    public static AddressEntity mapToEntityAddress(Address address){
        return new AddressEntity(
                address.getAddressId(),
                address.getCity(),
                address.getStreet(),
                address.getBuilding(),
                address.getApartment(),
                address.getPhone()
        );
    }
}
