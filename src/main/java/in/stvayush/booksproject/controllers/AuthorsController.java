package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.services.AuthorsService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorsController {
    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    public String greet() {
        return authorsService.greetAuthors();
    }
}
