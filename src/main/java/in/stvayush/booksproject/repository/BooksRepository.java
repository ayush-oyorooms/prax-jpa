package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
