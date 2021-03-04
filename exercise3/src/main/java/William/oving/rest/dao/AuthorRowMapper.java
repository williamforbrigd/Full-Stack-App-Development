package William.oving.rest.dao;

import William.oving.rest.model.Author;
import William.oving.rest.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author a = new Author();
        a.setId(rs.getInt("author_id"));
        a.setFirstName(rs.getString("first_name"));
        a.setLastName(rs.getString("last_name"));
        a.setBirthDate(rs.getString("birth_date"));
        a.setAddressId(rs.getInt("address_id"));

        return a;
    }

}
