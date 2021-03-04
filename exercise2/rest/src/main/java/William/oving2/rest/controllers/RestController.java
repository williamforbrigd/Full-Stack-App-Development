//package William.oving2.rest.web;
//
//import William.oving2.rest.model.Author;
//import William.oving2.rest.model.Book;
//import William.oving2.rest.service.AuthorService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@org.springframework.web.bind.annotation.RestController
//public class RestController {
//
//    private ArrayList<Author> authors = new ArrayList<>();
//
//    Logger logger = LoggerFactory.getLogger(RestController.class);
//
//
//    //@GetMapping("/authors")
//    @RequestMapping(value="/authors", method=RequestMethod.GET)
//    public ArrayList<Author> getAuthors() {
//        return this.authors;
//    }
//
//    @GetMapping("authors/{id}")
//    public Author getAuthorById(@PathVariable int id) {
//        for(int i=0; i < authors.size(); i++) {
//            if(authors.get(i).getId() == id)
//                return authors.get(i);
//        }
//        logger.info("Could not find the author with id: " + id);
//        return null;
//    }
//
//    @GetMapping("authors/name")
//    public Author getAuthorByName(@RequestParam List<String> names) {
//        if(names.size() != 2) {
//            logger.warn("Pass in the first name and the last name");
//            return null;
//        }
//        for(Author a : authors) {
//            if(a.getFirstName().equalsIgnoreCase(names.get(0)) && a.getLastName().equalsIgnoreCase(names.get(1))) {
//                return a;
//            }
//        }
//        logger.warn("Could not find the author with name: " + names.get(0)+ " " + names.get(1));
//        return null;
//    }
//
//
//    /*
//    @PostMapping("/authors")
//    public Author addAuthor(@RequestBody Author author) {
//        System.out.println("new author method called");
//        author.setId(authors.size());
//        authors.add(author);
//        return author;
//    }
//
//     */
//
//    @PostMapping("/authors")
//    public List<Author> addAuthors(@RequestBody List<Author> addAuthors) {
//        for(Author a : addAuthors) {
//            a.setId(this.authors.size());
//            this.authors.add(a);
//        }
//        return authors;
//    }
//
//
//
//    @PutMapping("authors/{id}")
//    public Author changeAuthor(@RequestBody Author author, @PathVariable int id) {
//        for(int i=0; i < authors.size(); i++) {
//            if(authors.get(i).getId() == id) {
//                authors.set(i, author);
//                return author;
//            }
//        }
//        return null;
//    }
//
//    @DeleteMapping("authors/{id}")
//    public boolean deleteAuthor(@PathVariable int id) {
//        for(int i=0; i < authors.size(); i++) {
//            if(authors.get(i).getId() == id) {
//                authors.remove(i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @GetMapping("authors/{id}/books")
//    public ArrayList<Book> getBooks(@PathVariable int id) {
//        for(Author a : authors) {
//            if(a.getId() == id) {
//                return a.getBooks();
//            }
//        }
//        logger.trace("Could not find the books written by author with id: " + id);
//        return null;
//    }
//
//    @GetMapping("/author/{id}/books/{name}")
//    public Book getBookByName(@PathVariable String name, @PathVariable int authorId) {
//        System.out.println(name);
//        for(Author a : authors) {
//            if(a.getId() == authorId) {
//                for(Book b : a.getBooks()) {
//                    if(b.getName().equalsIgnoreCase(name)) {
//                        return b;
//                    }
//                }
//            }
//        }
//        logger.warn("Could not find the book with name: " + name + " written by author with id: " + authorId);
//        return null;
//    }
//
//    /*
//    @PostMapping("authors/{id}/books")
//    public Book addBook(@RequestBody Book book, @PathVariable int id) {
//        for(Author a : authors) {
//            if(a.getId() == id) {
//                book.setId(a.getBooks().size());
//                a.getBooks().add(book);
//                return book;
//            }
//        }
//        return null;
//    }
//
//     */
//
//    @RequestMapping(value="/authors/{id}/books", method=RequestMethod.POST)
//    public List<Book> addBooks(@RequestBody List<Book> books, @PathVariable int id) {
//        for(Author a : authors) {
//            if(a.getId() == id) {
//                for(Book b : books) {
//                    b.setId(a.getBooks().size());
//                    a.getBooks().add(b);
//                }
//                return books;
//            }
//        }
//        return null;
//    }
//
//}
