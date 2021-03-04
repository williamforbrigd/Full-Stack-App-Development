package William.oving.rest.dao;

import William.oving.rest.model.Address;
import William.oving.rest.model.Author;
import William.oving.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoImpl implements Dao<Author> {

    private JdbcTemplate jt;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jt = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("author");
    }

    @Override
    public Author get(int id) {
        String query = "SELECT * FROM AUTHOR WHERE ID = ?";
        return jt.queryForObject(query, new Object[] {id}, new AuthorRowMapper());
    }

    public Author get2(int id) {
        String query = "SElECT * FROM AUTHOR WHERE ID = ?";
        return jt.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
                new Author(
                        rs.getInt("author_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("birth_date"),
                        rs.getInt("address_id")
                ));
    }


    public List<Book> getBooksByAuthor(int authorId) {
        //String query = "SELECT book.book_id, book.name, book.pages FROM book, authorbook " +
                //"WHERE authorbook.book_id = book.book_id AND authorbook.author_id = ?";
        String query = "SELECT * FROM book b " +
                "JOIN authorbook ab ON b.book_id = ab.book_id AND ab.author_id = ?";
        return jt.query(query, new BookRowMapper());
    }

    /*
    public Author getAuthorByName(String firstName, String lastName) {
        String query = "SELECT * FROM AUTHOR WHERE NAME = ?";
        return jt.queryForObject(query, new Object[]{firstName, lastName}, new AuthorRowMapper());
    }
     */

    @Override
    public List<Author> getAll() {
        String query = "SELECT * FROM author";
        return jt.query(query, new AuthorRowMapper());
    }

    /*
    //Lager en mange til mange relasjon AuthorsBooks
    public List<Book> getBooks(int authorId) {
        String query = "SELECT b.id, b.name, b.pages FROM BOOK b, AUTHORSBOOKS ab WHERE b.authorId = ab.authorId";
        return jt.query(query, new BookRowMapper());
    }
     */

    @Override
    public int add(Author a) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("author_id", a.getId());
        parameters.put("first_name", a.getFirstName());
        parameters.put("last_name", a.getLastName());
        parameters.put("birth_date", a.getBirthDate());
        parameters.put("address_id", a.getAddressId());

        return simpleJdbcInsert.execute(parameters);
    }

    public void addBookToAuthor(Book b, int authorId) {
        jt.update("INSERT INTO book VALUES(?, ?, ?)",
                b.getId(), b.getName(), b.getPages());
         jt.update("INSERT INTO authorbook VALUES(?,?)",
                b.getId(), authorId
        );
    }

    //public void update(Author a, String[] params) {}

    @Override
    public void delete(int id) {
        String query = "DELETE FROM author WHERE author_id = ?";
        jt.update(query, id);
    }
}
