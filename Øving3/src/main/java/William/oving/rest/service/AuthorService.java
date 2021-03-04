package William.oving.rest.service;

import William.oving.rest.dao.AuthorDaoImpl;
import William.oving.rest.model.Author;
import William.oving.rest.repo.AuthorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public List<Author> getAuthors() {
        logger.info("Getting the authors");
        return authorRepo.getAuthors();
    }

    public Author getAuthor(int id) {
        logger.info("Getting author with the id: " + id);
        return authorRepo.getAuthor(id);
    }

    /*
    public Author getAuthorByName(String firstName, String lastName) {
        logger.info("Getting author with name: " + firstName + " " + lastName);
        return authorRepo.getAuthorByName(firstName, lastName);
    }
     */

    public void addAuthor(Author author) {
        logger.info("Adding author");
        authorRepo.addAuthor(author);
    }

    public void deleteAuthor(int id) {
        logger.info("Deleting author");
        authorRepo.deleteAuthor(id);
    }
}
