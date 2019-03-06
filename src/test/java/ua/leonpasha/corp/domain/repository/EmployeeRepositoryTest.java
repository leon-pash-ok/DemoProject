package ua.leonpasha.corp.domain.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.leonpasha.corp.Application;
import ua.leonpasha.corp.domain.entities.EmployeeEntity;
import ua.leonpasha.corp.dto.Address;
import ua.leonpasha.corp.dto.Employee;
import ua.leonpasha.corp.service.converter.MapperUtilsForEntities;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Address address = Address.builder()
                .city("city_employee2")
                .street("street_employee2")
                .building("1_employee")
                .apartment(24)
                .phone("phone_employee")
                .build();
        Employee alex = Employee.builder().firstName("alex3").secondName("some2").position("position2").experience(1).address(address).build();
        EmployeeEntity entity = MapperUtilsForEntities.mapToEntityEmployee(alex);
        employeeRepository.save(entity);
        employeeRepository.flush();

        // when
        List<EmployeeEntity> authorEntities = employeeRepository.findAll();

        // then
        Assertions.assertThat(authorEntities).isNotNull().isNotEmpty();
        assertTrue(authorEntities.size() >= 1);
        assertTrue(authorEntities.get(0).getAddress().getId() >= 1);
    }
}
