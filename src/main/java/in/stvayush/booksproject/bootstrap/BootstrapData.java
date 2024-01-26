package in.stvayush.booksproject.bootstrap;

import in.stvayush.booksproject.controllers.AuthorsController;
import in.stvayush.booksproject.controllers.BooksController;
import in.stvayush.booksproject.controllers.PublishersController;
import in.stvayush.booksproject.models.Author;
import in.stvayush.booksproject.models.Book;
import in.stvayush.booksproject.models.Publisher;
import in.stvayush.booksproject.repository.AuthorsRepository;
import in.stvayush.booksproject.repository.BooksRepository;
import in.stvayush.booksproject.repository.PublishersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;
    private final PublishersRepository publishersRepository;
    private final BooksController booksController;
    private final AuthorsController authorsController;
    private final PublishersController publishersController;

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public BootstrapData(
            BooksRepository booksRepository,
            AuthorsRepository authorsRepository,
            PublishersRepository publishersRepository,
            BooksController booksController,
            AuthorsController authorsController,
            PublishersController publishersController
    ) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
        this.publishersRepository = publishersRepository;
        this.booksController = booksController;
        this.authorsController = authorsController;
        this.publishersController = publishersController;
    }

    @Override
    public void run(String... args) throws Exception {
//        Book firstBook = new Book("First Book", new HashSet<>(), "1234");
//        Book secondBook = new Book("Second Book", new HashSet<>(), "1234");
//
//        Author firstAuthor = new Author("First Author", new HashSet<>());
//        Author secondAuthor = new Author("Second Author", new HashSet<>());
//
//        Publisher firstPublisher = new Publisher("First publisher", "Random Address", new HashSet<>());
//        Publisher secondPublisher = new Publisher("Second publisher", "Random Address", new HashSet<>());
//
//        booksRepository.save(firstBook);
//        booksRepository.save(secondBook);
//
//        authorsRepository.save(firstAuthor);
//        authorsRepository.save(secondAuthor);
//
//        publishersRepository.save(firstPublisher);
//        publishersRepository.save(secondPublisher);
//
//        List<String> greetings = new ArrayList<>();
//        greetings.add(booksController.greet());
//        greetings.add(authorsController.greet());
//        greetings.add(publishersController.greet());
//
//        greetings.forEach(greeting -> {
//            logger.log(Level.INFO, greeting);
//        });
    }
}
