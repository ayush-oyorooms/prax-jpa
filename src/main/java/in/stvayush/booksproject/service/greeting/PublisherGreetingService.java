package in.stvayush.booksproject.service.greeting;

import org.springframework.stereotype.Service;

@Service
public class PublisherGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Greeting (for) Publishers";
    }
}
