package ua.leonpasha.corp.service.converter;

import javax.annotation.Nonnull;
import ua.leonpasha.corp.domain.entities.AddressEntity;
import ua.leonpasha.corp.domain.entities.AuthorEntity;
import ua.leonpasha.corp.domain.entities.EmployeeEntity;
import ua.leonpasha.corp.dto.Address;
import ua.leonpasha.corp.dto.Author;
import ua.leonpasha.corp.dto.Employee;

public class MapperUtilsForEntities {
    @Nonnull
    public static Author mapToDtoAuthor(@Nonnull AuthorEntity authorEntity){
        return Author.builder()
                .id(authorEntity.getId())
                .firstName(authorEntity.getFirstName())
                .secondName(authorEntity.getSecondName())
                .build();

    }

    @Nonnull
    public static AuthorEntity mapToEntityAuthor(@Nonnull Author author){
        return new AuthorEntity(author.getFirstName(), author.getSecondName());

    }

    @Nonnull
    public static Employee mapToDtoEmployee(@Nonnull EmployeeEntity employeeEntity){
        return Employee.builder()
                .employeeId(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .secondName(employeeEntity.getSecondName())
                .position(employeeEntity.getPosition())
                .experience(employeeEntity.getExperience())
                .address(mapToDtoAddress(employeeEntity.getAddress()))
                .build();

    }

    @Nonnull
    public static EmployeeEntity mapToEntityEmployee(@Nonnull Employee employee){
        return new EmployeeEntity(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getPosition(),
                employee.getExperience(),
                mapToEntityAddress(employee.getAddress())
        );
    }

    @Nonnull
    private static Address mapToDtoAddress(@Nonnull AddressEntity addressEntity){
        return Address.builder()
                .addressId(addressEntity.getId())
                .city(addressEntity.getCity())
                .street(addressEntity.getStreet())
                .building(addressEntity.getBuilding())
                .apartment(addressEntity.getApartment())
                .build();

    }

    @Nonnull
    public static AddressEntity mapToEntityAddress(@Nonnull Address address){
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
