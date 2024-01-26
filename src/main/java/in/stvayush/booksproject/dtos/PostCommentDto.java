package in.stvayush.booksproject.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class PostCommentDto {
    private Long id;
    private String commentContent;
}
