package in.stvayush.booksproject.services;

import in.stvayush.booksproject.service.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PublishersService {
    private final GreetingService greetingService;

    public PublishersService(
            @Qualifier("publisherGreetingService")
            GreetingService greetingService
    ) {
        this.greetingService = greetingService;
    }

    public String greetPublisher() {
        return greetingService.greet();
    }
}
