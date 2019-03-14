package ua.leonpasha.corp.core.domain.entities.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.leonpasha.corp.api.dto.Author;
import ua.leonpasha.corp.core.Application;
import ua.leonpasha.corp.core.domain.entities.AuthorEntity;
import ua.leonpasha.corp.core.domain.repository.AuthorRepository;
import ua.leonpasha.corp.core.service.converter.MapperUtilsForEntities;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
/*@Transactional
@Commit*/
public class AuthorRepositoryTest {

    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    private AuthorRepository authorRepository;

 /*   @Test
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
        //assertEquals(1, authorEntities.size());
    }*/


    @Test
    public void whenFindByName_thenReturnAuthor2() {
        // given
        Author alex = Author.builder().firstName("alex3").secondName("some2").build();
        AuthorEntity entity = MapperUtilsForEntities.mapToEntityAuthor(alex);
        authorRepository.save(entity);
        authorRepository.flush();

        // when
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        // then
        Assertions.assertThat(authorEntities).isNotNull().isNotEmpty();
        assertTrue(authorEntities.size() >= 1);
    }
}
