package William.oving.rest.controllers;

import William.oving.rest.model.Address;
import William.oving.rest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService as;

    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable int id) {
        return as.getAddress(id);
    }

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return as.getAll();
    }

    //@PostMapping("/addresses")
    @RequestMapping(value="/addresses", method = RequestMethod.POST)
    public void addAddress(@RequestBody Address a) {
        as.addAddress(a);
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable int id) {
        as.deleteAddress(id);
    }

}
