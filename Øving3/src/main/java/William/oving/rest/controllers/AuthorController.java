package William.oving.rest.controllers;

import William.oving.rest.service.AuthorService;
import William.oving.rest.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        if(authorService.getAuthors() != null)
            return authorService.getAuthors();
        else {
            logger.warn("Could not get the authors");
            return null;
        }
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {
        //System.out.println("getAuthor() method called in AuthorController");
        Author a = authorService.getAuthor(id);
        if(a != null)
            return a;
        else {
            logger.warn("Could not find the author with the id: " + id);
            return null;
        }
    }

    /*
    @GetMapping("/authors/name")
    public Author getAuthorByName(@RequestParam String[] fullName) {
        if(fullName.length != 2) {
            logger.warn("Please enter first and last name only");
            return null;
        }
        Author a = authorService.getAuthorByName(fullName[0], fullName[1]);
        if(a != null) return a;
        else {
            logger.warn("Could not find the author with name: " + fullName[0] + " " + fullName[1]);
            return null;
        }
    }
     */


    @RequestMapping(value="/authors", method= RequestMethod.POST)
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }
    /*

    @PostMapping("/authors")
    public void addAuthors(@RequestBody List<Author> author) {
        author.forEach(a -> authorService.addAuthor(a));
    }

     */


    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }


}
