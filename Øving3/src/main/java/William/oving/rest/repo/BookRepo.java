package William.oving.rest.repo;

import William.oving.rest.dao.BookDaoImpl;
import William.oving.rest.model.Author;
import William.oving.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepo {
    @Autowired
    private BookDaoImpl bookDao;

    public List<Book> getBooks() {
        return bookDao.getAll();
    }

    public Book getBook(int id) {
        return bookDao.get(id);
    }

    /*
    public Book getBookByName(String name) {
    }
     */

    public ArrayList<Author> getAuthors(int id) {
        return getBook(id).getAuthors();
    }

    public int addBook(Book book) {
        return bookDao.add(book);
    }

    public void addAuthorToBook(int bookId, Author a) {
        getBook(bookId).getAuthors().add(a);
    }

    public void deleteBook(int id) {
        bookDao.delete(id);
    }

}
