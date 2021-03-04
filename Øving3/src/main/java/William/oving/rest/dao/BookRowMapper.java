package William.oving.rest.dao;

import William.oving.rest.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book b = new Book();
        b.setId(rs.getInt("book_id"));
        b.setName(rs.getString("name"));
        b.setPages(rs.getInt("pages"));

        return b;
    }
}
