package ua.leonpasha.corp.core.web.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ua.leonpasha.corp.api.dto.Author;
import ua.leonpasha.corp.core.service.AuthorService;

@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    public Author createAuthor(final Author author){
        return authorService.createAuthor(author);
    }
}
