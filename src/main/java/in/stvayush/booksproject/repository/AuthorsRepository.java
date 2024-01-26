package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
