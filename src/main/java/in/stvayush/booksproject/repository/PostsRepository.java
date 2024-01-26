package in.stvayush.booksproject.repository;

import in.stvayush.booksproject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
