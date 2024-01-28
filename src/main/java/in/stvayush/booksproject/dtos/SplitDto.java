package in.stvayush.booksproject.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SplitDto {
    private Long paid;
    private Long owed;
    private Long expenseId;
}
