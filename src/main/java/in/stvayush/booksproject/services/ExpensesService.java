package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.ExpenseDto;
import in.stvayush.booksproject.models.Expense;
import in.stvayush.booksproject.models.Member;
import in.stvayush.booksproject.models.Split;
import in.stvayush.booksproject.repository.ExpensesRepository;
import io.micrometer.common.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final MembersService membersService;
    private final SplitsService splitsService;

    private List<Split> splitEvenly(Expense expense) {
        int totalAmt = expense.getTotalAmount();
        int memberCount = expense.getMembers().size();
        int amtPerHead = totalAmt / memberCount;
        List<Split> splits = new ArrayList<>();
        expense.getMembers().forEach(member -> {
            Split split = new Split();
            if (!Objects.equals(expense.getGodPayer().getId(), member.getId())) {
                split.setAmount(amtPerHead);
                split.setOwedBy(member);
            } else {
                split.setAmount(totalAmt);
                split.setPaidBy(member);
            }
            split.setExpense(expense);
            splits.add(split);
            expense.getSplits().add(split);
        });
        return splits;
    }

    public ExpenseDto createExpense(ExpenseDto expenseDto) throws Exception {
        Expense expense = new Expense();
        List<Member> expenseMembers = new ArrayList<>();
        if (expenseDto != null) {
            if (StringUtils.isNotEmpty(expenseDto.getTitle())) {
                expense.setTitle(expenseDto.getTitle());
                List<Split> splits = new ArrayList<>();
                if (expenseDto.getAmount() != null) {
                    expense.setTotalAmount(expenseDto.getAmount());
                }
                expenseMembers = membersService.findMembersById(expenseDto.getMemberIds());
                expense.setMembers(expenseMembers);
                Optional<Member> godPayer = membersService.findMemberById(expenseDto.getGodPayerId());
                if (godPayer.isPresent()) {
                    expense.setGodPayer(godPayer.get());
                    splits = splitEvenly(expense);
                } else {
                    log.error("godPayer does not exist for the ExpenseDto {}", expenseDto);
                    throw new IllegalStateException("Expense without godPayer can never exist!");
                }
                if (!CollectionUtils.isEmpty(splits)) {
                    splitsService.persistSplits(splits);
                }
                expensesRepository.save(expense);
                expenseDto.setId(expense.getId());
            } else {
                log.error("No title for expense {} exists", expenseDto);
            }
        } else {
            log.error("Null expenseDto encountered {}", expenseDto);
            throw new IllegalArgumentException("Null ExpenseDto received for persisting");
        }
        return expenseDto;
    }
}
