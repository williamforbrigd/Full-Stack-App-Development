package William.oving.rest.controllers;


import William.oving.rest.model.Book;
import William.oving.rest.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bs;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bs.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        Book b = bs.getBook(bookId);
        if(b != null)
            return b;
        else {
            logger.warn("Could not find the book with id: " + bookId + " written by the author with id: " + bookId);
            return null;
        }
    }

    /*
    @GetMapping("/books/{name}")
    public Book getBookByName(@PathVariable String name) {
        Book b = bs.getBookByName(name);
        if(b != null)
            return b;
        else {
            logger.error("Could not find the book with the name: " + name);
            return null;
        }
    }
     */

    @PostMapping("/books")
    public void addBook(@RequestBody Book b) {
        bs.addBook(b);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        bs.deleteBook(bookId);
    }
}
