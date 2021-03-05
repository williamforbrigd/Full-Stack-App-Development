package William.oving.rest.repo;

import William.oving.rest.dao.AuthorDaoImpl;
import William.oving.rest.model.Address;
import William.oving.rest.model.Author;
import William.oving.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepo {
    @Autowired
    private AuthorDaoImpl authorDao;

    public List<Author> getAuthors() {
        return authorDao.getAll();
    }

    public Author getAuthor(int id) {
        return authorDao.get(id);
    }

    /*
    public Author getAuthorByName(String firstName, String lastName) {
        return authorDao.getAuthorByName(firstName, lastName);
    }
     */

    public List<Book> getBooksByAuthor(int authorId) {
        return authorDao.getBooksByAuthor(authorId);
    }

    public void addAuthor(Author author) {
        authorDao.add(author);
    }


    public void addBookToAuthor(Book b, int authorId) {
        authorDao.addBookToAuthor(b, authorId);
    }

    public void addBookToAuthor(int authorId, Book b) {
        getAuthor(authorId).getBooks().add(b);
    }

    public void deleteAuthor(int id) {
        authorDao.delete(id);
    }

}
