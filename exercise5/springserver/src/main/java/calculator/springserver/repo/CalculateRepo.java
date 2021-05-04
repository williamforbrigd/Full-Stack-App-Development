package calculator.springserver.repo;

import calculator.springserver.model.Calculate;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateRepo {

    public Calculate calculate(Calculate calculate) {
        if(calculate.getOperator().equals("+")) {
            calculate.setAns(calculate.getNum1() + calculate.getNum2() + "");
        } else if(calculate.getOperator().equals("-")) {
            calculate.setAns(calculate.getNum1() - calculate.getNum2() + "");
        } else if(calculate.getOperator().equals("*")) {
            calculate.setAns(calculate.getNum1() * calculate.getNum2() + "");
        } if(calculate.getOperator().equals("/")) {
            calculate.setAns(calculate.getNum1() / calculate.getNum2() + "");
        }
        return calculate;
    }
}
