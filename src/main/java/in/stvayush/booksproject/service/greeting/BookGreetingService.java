package in.stvayush.booksproject.service.greeting;

import org.springframework.stereotype.Service;

@Service
public class BookGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Greeting (for) Books";
    }
}
