package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Expense;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    @Query(value = "select * from expense where related_group_id = ?1", nativeQuery = true)
    List<Expense> findExpensesByGroupId(Long groupId);
}
