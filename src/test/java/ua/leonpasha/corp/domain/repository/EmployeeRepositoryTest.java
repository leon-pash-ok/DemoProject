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
import ua.leonpasha.corp.dto.Employee;
import ua.leonpasha.corp.service.converter.MapperUtilsForEntities;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnAuthor2() {
        // given
        Employee alex = Employee.builder().firstName("alex3").secondName("some2").position("position2").experience(1).build();
        EmployeeEntity entity = MapperUtilsForEntities.mapToEntityEmployee(alex);
        employeeRepository.save(entity);
        employeeRepository.flush();

        // when
        List<EmployeeEntity> authorEntities = employeeRepository.findAll();

        // then
        Assertions.assertThat(authorEntities).isNotNull().isNotEmpty();
        assertTrue(authorEntities.size() >= 1);
    }
}
