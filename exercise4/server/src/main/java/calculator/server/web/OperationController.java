package calculator.server.web;

import calculator.server.models.Operation;
import calculator.server.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import calculator.server.utils.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operation")
public class OperationController {
    private static Logger log = new Logger(OperationController.class.toString());

    @Autowired
    private OperationService operationService;

    @PostMapping(value ="/add")
    public Operation addOperation(@RequestBody Operation operation) {
        log.debug("Received new add operation: " + operation.toString());

        return operation;
    }

    @PostMapping(value ="/minus")
    public Operation minusOperation(@RequestBody Operation operation) {
        log.debug("Received new minus operation: " + operation.toString());

        return operation;
    }

    @PostMapping(value ="/multiply")
    public Operation multiplyOperation(@RequestBody Operation operation) {
        log.debug("Received new multiply operation: " + operation.toString());

        return operation;
    }

    @PostMapping(value ="/divide")
    public Operation divideOperation(@RequestBody Operation operation) {
        log.debug("Received new divice operation: " + operation.toString());

        return operation;
    }

}
