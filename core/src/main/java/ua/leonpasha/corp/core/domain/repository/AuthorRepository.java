package ua.leonpasha.corp.core.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.leonpasha.corp.core.domain.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("from AuthorEntity ")
    List<AuthorEntity> findAll();
}
