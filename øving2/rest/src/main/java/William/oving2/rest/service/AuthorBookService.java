package William.oving2.rest.service;

import William.oving2.rest.model.Author;
import William.oving2.rest.model.Book;
import William.oving2.rest.repo.AuthorRepo;
import William.oving2.rest.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorBookService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;

    public ArrayList<Book> getBooksByAuthor(int authorId) {
        return authorRepo.getBooks(authorId);
    }

    public ArrayList<Author> getAuthorsToBook(int bookId) {
        return bookRepo.getAuthors(bookId);
    }

    public void addBookToAuthor(int authorId, Book b) {
        authorRepo.addBookToAuthor(authorId, b);
    }

    public void addAuthorToBook(int bookId, Author a) {
        bookRepo.addAuthorToBook(bookId, a);
    }

}
