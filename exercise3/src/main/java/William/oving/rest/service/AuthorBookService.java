package William.oving.rest.service;

import William.oving.rest.model.Author;
import William.oving.rest.model.Book;
import William.oving.rest.repo.AuthorRepo;
import William.oving.rest.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooksByAuthor(int authorId) {
        return authorRepo.getBooksByAuthor(authorId);
    }

    /*
    public ArrayList<Author> getAuthorsToBook(int bookId) {
        return bookRepo.getAuthors(bookId);
    }
     */

    public void addBookToAuthor(int authorId, Book b) {
        authorRepo.addBookToAuthor(authorId, b);
    }

    /*
    public void addAuthorToBook(int bookId, Author a) {
        bookRepo.addAuthorToBook(bookId, a);
    }
     */

}
