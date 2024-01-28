package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.ExpenseDto;
import in.stvayush.booksproject.services.ExpensesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/expenses")
public class ExpensesController {
    private final ExpensesService expensesService;

    @PostMapping("/add")
    public ExpenseDto addExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto exd = new ExpenseDto();
        try {
            exd = expensesService.addExpense(expenseDto);
        } catch (Exception e) {
            log.error("An error {} occurred while adding an expense {}", e, expenseDto);
        }
        return exd;
    }
}
