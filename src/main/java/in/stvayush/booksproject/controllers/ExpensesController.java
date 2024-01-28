package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.constants.Endpoints;
import in.stvayush.booksproject.dtos.ExpenseDto;
import in.stvayush.booksproject.services.ExpensesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = Endpoints.EXPENSE)
public class ExpensesController {
    private final ExpensesService expensesService;

    @PostMapping(value = Endpoints.CREATE)
    public ExpenseDto createExpense(@RequestParam String groupId, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto exd = new ExpenseDto();
        try {
            exd = expensesService.createExpense(groupId, expenseDto);
        } catch (Exception e) {
            log.error("An error {} occurred while adding an expense {}", e, expenseDto);
        }
        return exd;
    }

    @GetMapping(value = Endpoints.LIST)
    public List<ExpenseDto> getExpensesInAGroup(@RequestParam String groupId) {
        return expensesService.getExpensesInAGroup(groupId);
    }
}
