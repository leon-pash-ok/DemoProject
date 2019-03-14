package ua.leonpasha.corp.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.leonpasha.corp.domain.entities.EmployeeEntity;
import ua.leonpasha.corp.domain.repository.EmployeeRepository;
import ua.leonpasha.corp.dto.Employee;
import ua.leonpasha.corp.service.converter.MapperUtilsForEntities;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Employee createEmployee(final Employee employee) {
        log.info("Create author with params: {}", employee);
        EmployeeEntity employeeEntity = MapperUtilsForEntities.mapToEntityEmployee(employee);

        EmployeeEntity resEntity = employeeRepository.saveAndFlush(employeeEntity);
        log.info("resEntity: {}", resEntity);
        return MapperUtilsForEntities.mapToDtoEmployee(resEntity);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Employee> findAll() {
        log.info("call findAllEmployees with params.");

        List<EmployeeEntity> resEntities = employeeRepository.findAll();
        return resEntities.stream()
                .map(MapperUtilsForEntities::mapToDtoEmployee)
                .collect(Collectors.toList());
    }
}
