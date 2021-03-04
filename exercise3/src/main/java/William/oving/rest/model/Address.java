package William.oving.rest.model;

public class Address {
    private int id;
    private String name;
    private int number;

    public Address(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Address() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
