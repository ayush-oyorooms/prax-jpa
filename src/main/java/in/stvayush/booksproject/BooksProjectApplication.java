package in.stvayush.booksproject;

import in.stvayush.booksproject.models.Book;
import in.stvayush.booksproject.models.Publisher;
import in.stvayush.booksproject.repository.AuthorsRepository;
import in.stvayush.booksproject.repository.BooksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.UUID;

@SpringBootApplication
public class BooksProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksProjectApplication.class, args);
    }
}
