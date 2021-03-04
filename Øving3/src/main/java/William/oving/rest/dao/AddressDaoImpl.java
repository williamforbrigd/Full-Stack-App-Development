package William.oving.rest.dao;

import William.oving.rest.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AddressDaoImpl implements Dao<Address> {
    private JdbcTemplate jt;
    private SimpleJdbcInsert ji;

    @Autowired
    public void setDataSource(DataSource ds) {
        jt = new JdbcTemplate(ds);
        ji = new SimpleJdbcInsert(ds).withTableName("address");
    }
    @Override
    public Address get(int id) {
        String query = "SELECT * FROM address a WHERE a.address_id = ?";
        return jt.queryForObject(query, new Object[]{id}, new AddressRowMapper());
    }

    @Override
    public List<Address> getAll() {
        String query = "SELECT * FROM address";
        return jt.query(query, new AddressRowMapper());
    }

    @Override
    public int add(Address a) {
        jt.update("INSERT INTO address VALUES(?,?,?)",
                a.getId(), a.getName(), a.getNumber());
        return 0;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM address WHERE address_id = ?";
        jt.update(query,id);
    }
}
