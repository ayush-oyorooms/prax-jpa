package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
}
