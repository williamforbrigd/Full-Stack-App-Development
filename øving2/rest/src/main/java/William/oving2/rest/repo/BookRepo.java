package William.oving2.rest.repo;

import William.oving2.rest.model.Author;
import William.oving2.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Repository
public class BookRepo {
    private ArrayList<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1, "Harry Potter", 300),
            new Book(2, "Lord of the Rings", 400),
            new Book(3, "The intelligent investor", 500)
    ));

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Book getBook(int id) {
        Optional<Book> book = books
                .stream()
                .filter(b -> b.getId() == id)
                .findAny();
        return book.orElse(null);
    }

    public Book getBookByName(String name) {
        Optional<Book> book = books
                .stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findAny();
        return book.orElse(null);
    }

    public ArrayList<Author> getAuthors(int id) {
        return getBook(id).getAuthors();
    }

    public void addBook(Book book) {
        book.setId(books.size());
        books.add(book);
    }

    public void addAuthorToBook(int bookId, Author a) {
        getBook(bookId).getAuthors().add(a);
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }

}
