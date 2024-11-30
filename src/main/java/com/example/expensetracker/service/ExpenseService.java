package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides services for managing expenses.
 */
@Service
public class ExpenseService {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseService.class);

    @Autowired
    private ExpenseRepository repository;

    /**
     * Retrieves all expenses from the repository.
     *
     * @return a list of all expenses, not null
     */
    public List<Expense> getAllExpenses() {
        logger.debug("Fetching all expenses");
        List<Expense> expenses = repository.findAll();
        logger.info("Retrieved {} expenses", expenses.size());
        return expenses;
    }

    /**
     * Retrieves an expense by its ID.
     *
     * @param id the ID of the expense to retrieve, must not be null
     * @return the expense with the specified ID, or null if not found
     */
    public Expense getExpenseById(Long id) {
        logger.debug("Fetching expense with id: {}", id);
        Expense expense = repository.findById(id).orElse(null);
        if (expense == null) {
            logger.warn("Expense with id {} not found", id);
        } else {
            logger.info("Retrieved expense: {}", expense);
        }
        return expense;
    }

    /**
     * Adds a new expense to the repository.
     *
     * @param expense the expense to add, must not be null
     * @return the added expense, not null
     */
    public Expense addExpense(Expense expense) {
        logger.debug("Adding new expense: {}", expense);
        Expense savedExpense = repository.save(expense);
        logger.info("Added new expense with id: {}", savedExpense.getId());
        return savedExpense;
    }

    /**
     * Updates an existing expense.
     *
     * @param id      the ID of the expense to update, must not be null
     * @param expense the updated expense data, must not be null
     * @return the updated expense, or null if the original did not exist
     */
    public Expense updateExpense(Long id, Expense expense) {
        logger.debug("Updating expense with id: {}", id);
        Expense existingExpense = repository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setCategory(expense.getCategory());
            Expense updatedExpense = repository.save(existingExpense);
            logger.info("Updated expense: {}", updatedExpense);
            return updatedExpense;
        } else {
            logger.warn("Expense with id {} not found for update", id);
            return null;
        }
    }

    /**
     * Deletes an expense by its ID.
     *
     * @param id the ID of the expense to delete, must not be null
     */
    public void deleteExpense(Long id) {
        logger.debug("Deleting expense with id: {}", id);
        try {
            repository.deleteById(id);
            logger.info("Deleted expense with id: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting expense with id: {}", id, e);
        }
    }
}