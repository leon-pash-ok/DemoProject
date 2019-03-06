package ua.leonpasha.corp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.leonpasha.corp.domain.entities.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
