package in.stvayush.booksproject.services;

import in.stvayush.booksproject.service.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    private final GreetingService greetingService;

    public AuthorsService (
            @Qualifier("authorGreetingService")
            GreetingService greetingService
    ) {
        this.greetingService = greetingService;
    }

    public String greetAuthors() {
        return greetingService.greet();
    }
}
