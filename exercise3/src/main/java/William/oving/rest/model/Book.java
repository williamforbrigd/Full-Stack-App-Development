package William.oving.rest.model;

import java.util.ArrayList;

public class Book {
    private int id;
    private String name;
    private int pages;
    private ArrayList<Author> authors;

    public Book(int id, String name, int pages) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        authors = new ArrayList<>();
    }

    public Book() {}

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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(ArrayList<Author> authors)  {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
