package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.BookDto;
import in.stvayush.booksproject.models.Book;
import in.stvayush.booksproject.services.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "books")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    public String greet() {
        return booksService.greet();
    }

    @RequestMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody Book newBook) {
        final BookDto nbk = booksService.addBook(newBook);
        return new ResponseEntity<>(nbk, HttpStatus.OK);
    }

    @DeleteMapping(value = "/sd")
    public void ss() {
    }
}
