package William.oving2.rest.model;

public class Address {
    private String name;
    private int number;

    public Address(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Adress{" +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
