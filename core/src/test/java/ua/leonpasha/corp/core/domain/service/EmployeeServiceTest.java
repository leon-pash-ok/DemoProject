package ua.leonpasha.corp.core.domain.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.leonpasha.corp.core.Application;
import ua.leonpasha.corp.api.dto.Address;
import ua.leonpasha.corp.api.dto.Employee;
import ua.leonpasha.corp.core.service.EmployeeService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test() {
        List<Employee> employees = employeeService.findAll();
        assertTrue(employees.size() >= 1);
    }

    @Test( expected = NullPointerException.class )
    public void test2() {
        employeeService.createEmployee(new Employee());
    }

    @Test
    public void test3() {
        // given
        Address address = Address.builder()
                .city("city_employee2")
                .street("street_employee2")
                .building("1_employee")
                .apartment(24)
                .phone("phone_employee")
                .build();
        Employee alex = Employee.builder().firstName("alex3").secondName("some2").position("position2").experience(1).address(address).build();

        Employee employee = employeeService.createEmployee(alex);
        log.info("employee = {}", employee);
        Address addressRes = employee.getAddress();
        Assert.assertThat(addressRes, is(notNullValue()));
        Long addressId = addressRes.getAddressId();
        log.info("addressId = {}", addressId);
        Assert.assertTrue(addressId >= 1);
    }
}
