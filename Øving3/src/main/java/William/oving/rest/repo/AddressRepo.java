package William.oving.rest.repo;


import William.oving.rest.dao.AddressDaoImpl;
import William.oving.rest.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepo {
    @Autowired
    private AddressDaoImpl dao;

    public Address getAddress(int id) {
        return dao.get(id);
    }

    public List<Address> getAllAddresses() {
        return dao.getAll();
    }

    public void addAddress(Address a) {
        dao.add(a);
    }

    public void deleteAddress(int id){
        dao.delete(id);
    }


}
