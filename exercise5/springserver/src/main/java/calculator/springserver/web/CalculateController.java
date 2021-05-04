package calculator.springserver.web;

import calculator.springserver.model.Calculate;
import calculator.springserver.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CalculateController {
    @Autowired
    CalculateService service;

    @PostMapping("/calculate")
    public Calculate calculate(@RequestBody Calculate calculate) {
        return service.calculate(calculate);
    }
}
