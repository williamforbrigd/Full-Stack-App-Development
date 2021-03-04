package William.oving.rest.service;

import William.oving.rest.model.Address;
import William.oving.rest.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo ar;

    public Address getAddress(int id) {
        return ar.getAddress(id);
    }

    public List<Address> getAll() {
        return ar.getAllAddresses();
    }

    public void addAddress(Address a) {
       ar.addAddress(a);
    }

    public void deleteAddress(int id) {
        ar.deleteAddress(id);
    }
}
