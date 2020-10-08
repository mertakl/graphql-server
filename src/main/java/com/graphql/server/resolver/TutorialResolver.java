package com.graphql.server.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.server.model.Author;
import com.graphql.server.model.Tutorial;
import com.graphql.server.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    private final AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}
