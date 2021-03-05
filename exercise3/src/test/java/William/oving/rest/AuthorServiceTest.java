package William.oving.rest;

import William.oving.rest.dao.AuthorDaoImpl;
import William.oving.rest.model.Author;
import William.oving.rest.repo.AuthorRepo;
import William.oving.rest.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {
    @InjectMocks
    private AuthorService service;

    //@Mock
    //private AuthorRepo repo;
    @Mock
    private AuthorDaoImpl dao;

    @BeforeEach
    public void setUp() {
        Author neededForCreate = new Author(1, "william", "forb", "1999", 1);

        //Mockito.lenient().when(repo.saySomething()).thenReturn(neededForCreate);
        Mockito.lenient().when(dao.emptyAuthor()).thenReturn(neededForCreate);
    }

    @Test
    void getAuthors() {

    }
}
