package com.graphql.server.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.server.model.Author;
import com.graphql.server.model.Tutorial;
import com.graphql.server.repository.AuthorRepository;
import com.graphql.server.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;
    private final TutorialRepository tutorialRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countTutorials() {
        return tutorialRepository.count();
    }

}
