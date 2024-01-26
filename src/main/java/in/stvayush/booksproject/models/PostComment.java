package in.stvayush.booksproject.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "comments")
@Getter
@Setter
@JsonNaming(SnakeCaseStrategy.class)
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String commentContent;
//    private Long pid;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post referencedPost;
}
