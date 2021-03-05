package William.oving.rest.service;

import William.oving.rest.dao.AuthorDaoImpl;
import William.oving.rest.model.Author;
import William.oving.rest.repo.AuthorRepo;
import William.oving.rest.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @InjectMocks
    private AuthorService service;

    @Mock
    private AuthorRepo repo;

    private Author neededForCreate;

    @BeforeEach
    public void setUp() {
        neededForCreate = new Author(1, "william", "forb", "1999", 1);

        Mockito.lenient().when(repo.getAuthor(neededForCreate.getId())).thenReturn(neededForCreate);
        Mockito.lenient().when(repo.getAuthors()).thenReturn(new ArrayList<>(Collections.singletonList(neededForCreate)));
    }

    @Test
    void getAuthorWithId() {
        assert(service.getAuthor(neededForCreate.getId()).getId() == neededForCreate.getId());
    }

    @Test
    void getAuthors() {
        List<Author> authors = service.getAuthors();
        assert(authors.get(0).getId() == 1);
        assert(authors.get(0).getFirstName().equals("william"));
        assert(authors.get(0).getLastName().equals("forb"));
        assert(authors.get(0).getAddressId() == 1);
    }

    @Test
    void getAuthorsSize() {
        List<Author> authors = service.getAuthors();
        assert(authors.size() == 1);
    }

}
