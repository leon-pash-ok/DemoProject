package ua.leonpasha.corp.service.converter;

import ua.leonpasha.corp.dto.Author;
import ua.leonpasha.corp.domain.entities.AuthorEntity;

public class MapperUtilsForEntities {
    public static Author mapToDtoAuthor(AuthorEntity authorEntity){
        return Author.builder()
                .id(authorEntity.getId())
                .firstName(authorEntity.getFirstName())
                .secondName(authorEntity.getSecondName())
                .build();

    }

    public static AuthorEntity mapToEntityAuthor(Author author){
        return new AuthorEntity(author.getFirstName(), author.getSecondName());

    }
}
