package William.oving2.rest.controllers;


import William.oving2.rest.model.Author;
import William.oving2.rest.model.Book;
import William.oving2.rest.service.AuthorBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AuthorBookController {
    @Autowired
    private AuthorBookService abs;

    Logger logger = LoggerFactory.getLogger(AuthorBookController.class);

    @GetMapping("/authors/{authorId}/books")
    public ArrayList<Book> getBooksByAuthor(@PathVariable int authorId) {
        return abs.getBooksByAuthor(authorId);
    }

    @GetMapping("/books/{bookId}/authors")
    public ArrayList<Author> getAuthorsToBook(@PathVariable int bookId) {
        return abs.getAuthorsToBook(bookId);
    }

    @PostMapping("/authors/{authorId}/books")
    public void addBookToAuthor(@PathVariable int authorId, @RequestBody Book b) {
        abs.addBookToAuthor(authorId, b);
    }

    @PostMapping("/books/{bookId}/authors")
    public void addAuthorToBook(@PathVariable int bookId, @RequestBody Author a) {
        abs.addAuthorToBook(bookId, a);
    }
}
