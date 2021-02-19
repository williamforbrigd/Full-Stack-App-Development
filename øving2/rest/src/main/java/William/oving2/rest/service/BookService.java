package William.oving2.rest.service;

import William.oving2.rest.model.Book;
import William.oving2.rest.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    Logger logger = LoggerFactory.getLogger(BookService.class);

    public ArrayList<Book> getBooks() {
        logger.info("Getting the books");
        return bookRepo.getBooks();
    }

    public Book getBook(int id) {
        logger.info("Getting the book with id: " + id);
        return bookRepo.getBook(id);
    }

    public Book getBookByName(String name) {
        logger.info("Getting the book with name: " + name);
        return bookRepo.getBookByName(name);
    }

    public void addBook(Book book) {
        logger.info("Adding a book");
        bookRepo.addBook(book);
    }

    public void deleteBook(int id) {
        logger.info("Deleting book");
        bookRepo.deleteBook(id);
    }
}
