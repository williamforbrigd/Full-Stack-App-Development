package calculator.server.models;

public class Operation {
    private String num1;
    private String num2;
    private String operator;

    public Operation(String num1, String num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int calculate() {
        if(this.operator == "+")
            return Integer.parseInt(num1) + Integer.parseInt(num2);
        else if(this.operator == "-")
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        else if(this.operator == "*")
            return Integer.parseInt(num1) * Integer.parseInt(num2);
        else if(this.operator == "/")
            return Integer.parseInt(num1) / Integer.parseInt(num2);
        return -1;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1='" + num1 + '\'' +
                ", num2='" + num2 + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
