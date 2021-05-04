package calculator.springserver.model;

public class Calculate {
    private double num1;
    private double num2;
    private String operator;
    private String ans;

    public Calculate(double num1, double num2, String operator, String ans) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.ans = ans;
    }

    public Calculate() {}

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "Calculate{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operator='" + operator + '\'' +
                ", ans='" + ans + '\'' +
                '}';
    }
}
