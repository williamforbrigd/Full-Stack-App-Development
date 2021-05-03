package calculator.server.service;

import calculator.server.models.Operation;
import calculator.server.repo.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import calculator.server.utils.Logger;

@Service
public class OperationService {
    private Logger log = new Logger(OperationService.class.toString());

    @Autowired
    private OperationRepo repo;

    public int addOperation(Operation operation) {
        log.info("Add operation: " + operation.toString());
        return repo.addOperation(operation);
    }

    public int minusOperation(Operation operation) {
        log.info("Minus operation: " + operation.toString());
        return repo.minusOperation(operation);
    }

    public int multiplyOperation(Operation operation) {
        log.info("Multiply operation: " + operation.toString());
        return repo.multiplyOperation(operation);
    }

    public int divideOperation(Operation operation) {
        log.info("Add operation: " + operation.toString());
        return repo.divideOperation(operation);
    }


}
