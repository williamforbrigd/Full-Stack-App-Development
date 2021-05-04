package calculator.springserver.service;

import calculator.springserver.model.Calculate;
import calculator.springserver.repo.CalculateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    @Autowired
    CalculateRepo repo;

    public Calculate calculate(Calculate calculate) {
        return repo.calculate(calculate);
    }


}
