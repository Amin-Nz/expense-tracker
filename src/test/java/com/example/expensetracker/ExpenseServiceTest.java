package com.example.expensetracker;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository repository;

    @InjectMocks
    private ExpenseService service;

    public ExpenseServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddExpense() {
        Expense expense = new Expense(null, "Lunch", 15.0, "Food");
        when(repository.save(expense)).thenReturn(expense);

        Expense result = service.addExpense(expense);

        assertNotNull(result);
    }
}
