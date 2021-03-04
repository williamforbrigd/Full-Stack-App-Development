package William.oving.rest.dao;

import William.oving.rest.model.Address;
import William.oving.rest.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {

    public Address mapRow(ResultSet rs, int i) throws SQLException {
        Address a = new Address();
        a.setId(rs.getInt("address_id"));
        a.setName(rs.getString("address_name"));
        a.setNumber(rs.getInt("address_number"));

        return a;
    }
}
