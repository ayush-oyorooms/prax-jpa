package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentsRepository extends JpaRepository<PostComment, Long> {
}
