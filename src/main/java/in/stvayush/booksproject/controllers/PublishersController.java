package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.services.PublishersService;
import org.springframework.stereotype.Controller;

@Controller
public class PublishersController {
    private final PublishersService publishersService;

    public PublishersController(PublishersService publishersService) {
        this.publishersService = publishersService;
    }

    public String greet() {
        return publishersService.greetPublisher();
    }
}
