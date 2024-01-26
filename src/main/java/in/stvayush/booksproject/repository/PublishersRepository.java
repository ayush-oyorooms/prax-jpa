package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishersRepository extends JpaRepository<Publisher, Long> {
}
