package com.example.expensetracker;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import com.example.expensetracker.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository repository;

    @InjectMocks
    private ExpenseService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddExpense() {
        Expense expense = new Expense(null, "Lunch", 15.0, "Food");
        when(repository.save(expense)).thenReturn(expense);

        Expense result = service.addExpense(expense);

        assertNotNull(result);
        verify(repository, times(1)).save(expense);
    }

    @Test
    public void testGetAllExpenses() {
        List<Expense> expectedExpenses = Arrays.asList(
            new Expense(1L, "Groceries", 50.0, "Food"),
            new Expense(2L, "Gas", 30.0, "Transportation")
        );
        when(repository.findAll()).thenReturn(expectedExpenses);

        List<Expense> actualExpenses = service.getAllExpenses();

        assertEquals(expectedExpenses, actualExpenses);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testGetExpenseById_ExistingExpense() {
        Long id = 1L;
        Expense expectedExpense = new Expense(id, "Groceries", 50.0, "Food");
        when(repository.findById(id)).thenReturn(Optional.of(expectedExpense));

        Expense actualExpense = service.getExpenseById(id);

        assertEquals(expectedExpense, actualExpense);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testGetExpenseById_NonExistingExpense() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        Expense actualExpense = service.getExpenseById(id);

        assertNull(actualExpense);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testUpdateExpense_ExistingExpense() {
        Long id = 1L;
        Expense existingExpense = new Expense(id, "Groceries", 50.0, "Food");
        Expense updatedExpense = new Expense(id, "Updated Groceries", 60.0, "Food");
        when(repository.findById(id)).thenReturn(Optional.of(existingExpense));
        when(repository.save(any(Expense.class))).thenReturn(updatedExpense);

        Expense actualExpense = service.updateExpense(id, updatedExpense);

        assertEquals(updatedExpense, actualExpense);
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(any(Expense.class));
    }

    @Test
    public void testUpdateExpense_NonExistingExpense() {
        Long id = 1L;
        Expense updatedExpense = new Expense(id, "Updated Groceries", 60.0, "Food");
        when(repository.findById(id)).thenReturn(Optional.empty());

        Expense actualExpense = service.updateExpense(id, updatedExpense);

        assertNull(actualExpense);
        verify(repository, times(1)).findById(id);
        verify(repository, never()).save(any(Expense.class));
    }

    @Test
    public void testDeleteExpense() {
        Long id = 1L;

        service.deleteExpense(id);

        verify(repository, times(1)).deleteById(id);
    }
}