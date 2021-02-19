package William.oving2.rest.repo;

import William.oving2.rest.model.Address;
import William.oving2.rest.model.Author;
import William.oving2.rest.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Repository
public class AuthorRepo {
    private ArrayList<Author> authors = new ArrayList<>(Arrays.asList(
        new Author(1, "William", "Forbrigd", "1999" , new Address("Fjordgata", 29)),
        new Author(2, "Alexander", "Forbrigd", "1999" , new Address("Huldre", 3)),
        new Author(3, "Erik", "Galler", "1999" , new Address("Fjordgata", 29)),
        new Author(4, "Even", "Lauvsnes", "1999" , new Address("Fjordgata", 29))
    ));

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public Author getAuthor(int id) {
        Optional<Author> author = authors
                .stream()
                .filter(a -> a.getId() == id)
                .findAny();
        return author.orElse(null);
    }

    public Author getAuthorByName(String firstName, String lastName) {
        Optional<Author> author = authors
                .stream()
                .filter(a -> a.getFirstName().equalsIgnoreCase(firstName) &&
                                a.getLastName().equalsIgnoreCase(lastName))
                .findAny();
        return author.orElse(null);
    }

    public ArrayList<Book> getBooks(int authorId) {
        return getAuthor(authorId).getBooks();
    }

    public void addAuthor(Author author) {
        author.setId(authors.size());
        authors.add(author);
    }

    public void addBookToAuthor(int authorId, Book b) {
        getAuthor(authorId).getBooks().add(b);
    }

    public void deleteAuthor(int id) {
        authors.removeIf(a -> a.getId() == id);
    }

}
