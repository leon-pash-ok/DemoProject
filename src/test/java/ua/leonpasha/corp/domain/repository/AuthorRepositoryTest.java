package ua.leonpasha.corp.domain.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.leonpasha.corp.Application;
import ua.leonpasha.corp.domain.entities.AuthorEntity;
import ua.leonpasha.corp.dto.Author;
import ua.leonpasha.corp.service.converter.MapperUtilsForEntities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
//@DataJpaTest
public class AuthorRepositoryTest {

    /*@Autowired
    private TestEntityManager entityManager;*/
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @Transactional
    public void whenFindByName_thenReturnAuthor() {
        // given
        Author alex = Author.builder().firstName("alex1").secondName("some1").build();
        AuthorEntity entity = MapperUtilsForEntities.mapToEntityAuthor(alex);
        entityManager.persist(entity);
        entityManager.flush();

        // when
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        // then
        Assertions.assertThat(authorEntities).isNotNull().isNotEmpty();
        assertEquals(authorEntities.size(), 1);
    }


    @Test
    public void whenFindByName_thenReturnAuthor2() {
        // given
        Author alex = Author.builder().firstName("alex2").secondName("some2").build();
        AuthorEntity entity = MapperUtilsForEntities.mapToEntityAuthor(alex);
        authorRepository.save(entity);
        authorRepository.flush();

        // when
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        // then
        Assertions.assertThat(authorEntities).isNotNull().isNotEmpty();
        assertEquals(authorEntities.size(), 1);
    }
}
