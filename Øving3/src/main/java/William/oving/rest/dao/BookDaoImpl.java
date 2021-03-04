package William.oving.rest.dao;

import William.oving.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDaoImpl implements Dao<Book> {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("book");
    }

    @Override
    public Book get(int id) {
        String query = "SELECT * FROM book b WHERE b.book_id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new BookRowMapper());
    }

    @Override
    public List<Book> getAll() {
        String query = "SELECT * FROM book";
        return jdbcTemplate.query(query, new BookRowMapper());
    }

    @Override
    public int add(Book book) {
        jdbcTemplate.update("INSERT INTO book VALUES(?, ?, ?)",
                book.getId(),book.getName(), book.getPages());
        return 0;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM book WHERE book_id = ?";
        jdbcTemplate.update(query, id);
    }
}
