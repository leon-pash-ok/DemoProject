package ua.leonpasha.corp.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.leonpasha.corp.api.dto.Author;
import ua.leonpasha.corp.core.domain.entities.AuthorEntity;
import ua.leonpasha.corp.core.domain.repository.AuthorRepository;
import ua.leonpasha.corp.core.service.converter.MapperUtilsForEntities;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Author createAuthor(final Author author) {
        log.info("Create author with params: {}", author);
        AuthorEntity authorEntity = new AuthorEntity(author.getFirstName(), author.getSecondName());

        AuthorEntity resEntity = authorRepository.saveAndFlush(authorEntity);
        return MapperUtilsForEntities.mapToDtoAuthor(resEntity);
    }


}
