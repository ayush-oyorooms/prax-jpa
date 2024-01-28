package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Group, Long> {
}
