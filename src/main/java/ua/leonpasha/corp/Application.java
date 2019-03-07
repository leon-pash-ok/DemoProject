package ua.leonpasha.corp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


/*    @Bean
    public EmployeeRepositoryTest employeeRepositoryTest(EmployeeRepository employeeRepository){
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
        return new EmployeeRepositoryTest(employeeRepository);
    }*/


}