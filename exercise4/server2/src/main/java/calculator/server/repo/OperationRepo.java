package calculator.server.repo;

import calculator.server.models.Operation;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import calculator.server.utils.Logger;


@Repository
public class OperationRepo {
    //private Logger log = LoggerFactory.getLogger(OperationRepo.class.toString());

    public int addOperation(Operation operation) {
        //log.info("Add operation: " + operation.toString());

        try {
            return Integer.parseInt(operation.getNum1()) + Integer.parseInt(operation.getNum2());

        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /*
    public int minusOperation(Operation operation) {
        log.info("Minus operation: " + operation.toString());

        try {
            if(operation.getOperator() == '-')
                return operation.getNum1() + operation.getOperator() + operation.getNum2();
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int multiplyOperation(Operation operation) {
        log.info("Multiply operation: " + operation.toString());

        try {
            if(operation.getOperator() == '*')
                return operation.getNum1() + operation.getOperator() + operation.getNum2();
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int divideOperation(Operation operation) {
        log.info("Divide operation: " + operation.toString());

        try {
            if(operation.getOperator() == '/')
                return operation.getNum1() + operation.getOperator() + operation.getNum2();
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

     */
}
