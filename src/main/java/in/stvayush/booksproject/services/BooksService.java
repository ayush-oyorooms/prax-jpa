package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.BookDto;
import in.stvayush.booksproject.models.Author;
import in.stvayush.booksproject.models.Book;
import in.stvayush.booksproject.repository.BooksRepository;
import in.stvayush.booksproject.service.greeting.GreetingService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    private final GreetingService greetingService;
    private final BooksRepository booksRepository;

    public BooksService(
            @Qualifier("bookGreetingService")
            GreetingService greetingService,
            BooksRepository booksRepository
    ) {
        this.greetingService = greetingService;
        this.booksRepository = booksRepository;
    }

    public String greet() {
        return greetingService.greet();
    }

    public BookDto addBook(Book book) {
        Set<Author> author = book.getAuthors();
        author.forEach(athr -> {
            book.addAuthor(athr);
            athr.addBook(book);
        });
        booksRepository.save(book);
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookName(book.getName());
        bookDto.setAuthors(book.getAuthorNames());
        return bookDto;
    }
}
