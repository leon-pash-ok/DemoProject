package ua.leonpasha.corp.domain.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.leonpasha.corp.Application;
import ua.leonpasha.corp.domain.entities.AddressEntity;
import ua.leonpasha.corp.dto.Address;
import ua.leonpasha.corp.service.converter.MapperUtilsForEntities;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenFindByName_thenReturnAddress() {
        // given
        Address address = Address.builder()
                .city("city3")
                .street("street2")
                .building("1")
                .apartment(24)
                .phone("phone")
                .build();
        AddressEntity entity = MapperUtilsForEntities.mapToEntityAddress(address);
        addressRepository.saveAndFlush(entity);

        // when
        List<AddressEntity> addressEntities = addressRepository.findAll();

        // then
        Assertions.assertThat(addressEntities).isNotNull().isNotEmpty();
        assertTrue( addressEntities.size() >= 1);
    }
}
