package in.stvayush.booksproject.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
@JsonInclude(Include.NON_NULL)
@Builder
public class ExpenseDto {
    private Long id;
    private String title;
    private Integer amount;
    private String godPayerId;
    private List<String> memberNames;
    private List<String> memberIds;
    private List<MemberDto> memberDto;
    private List<SplitDto> splitDto;
    private GroupDto groupDto;
}
