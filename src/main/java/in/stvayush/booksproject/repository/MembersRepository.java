package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Member, Long> {
}
