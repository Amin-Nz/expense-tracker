package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing expenses.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    /**
     * Retrieves all expenses.
     *
     * @return a list of all expenses
     */
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    /**
     * Retrieves an expense by its ID.
     *
     * @param id the ID of the expense to retrieve
     * @return the expense with the specified ID, or null if not found
     */
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id);
    }

    /**
     * Adds a new expense.
     *
     * @param expense the expense to add, must not be null
     * @return the added expense
     */
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    /**
     * Updates an existing expense.
     *
     * @param id      the ID of the expense to update
     * @param expense the updated expense data, must not be null
     * @return the updated expense, or null if the original did not exist
     */
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }

    /**
     * Deletes an expense by its ID.
     *
     * @param id the ID of the expense to delete
     */
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
    }
}